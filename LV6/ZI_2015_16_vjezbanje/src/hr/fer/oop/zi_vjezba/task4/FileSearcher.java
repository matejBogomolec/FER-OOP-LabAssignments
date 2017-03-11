package hr.fer.oop.zi_vjezba.task4;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class FileSearcher extends SwingWorker<List<String>, String> {
	
	private FileSearchMonitor monitor;
	private String from, to;
	public FileSearcher(FileSearchMonitor monitor, String from, String to){
		this.monitor = monitor;
		this.from = from;
		this.to = to;
	}
	/* 
	 * Search for PDF files from disk root to directory
	 * e.g. if from directory is c:/Books and to directory is c:/Books/Java/v8 it search pdfs in
	 * c:/Books/Java/v8, c:/Books/Java, c:/Books (can be ordered in both ways)
	 * for each PDF found, directory change, or end of search it calls appropriate monitor method
	 */
	public List<String> findPDFsInRange(String from, String to){
		List<String> pdfs = new ArrayList<>();
		Path path = Paths.get(from);
		Path root = path.getRoot();
		try {
			Files.walkFileTree(root, new MyFileVisitor(to, pdfs));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}	
		
		return pdfs;
	}
	
	@Override
	protected List<String> doInBackground(){
		return findPDFsInRange(from, to);
	}
	
	
	@Override
	protected void process(List<String> chunks) {
		for(String filename : chunks)
			monitor.fileFound(filename);
	}
	
	@Override
	protected void done() {
		monitor.searchFinished();
	}

	
	private class MyFileVisitor extends SimpleFileVisitor<Path>{
		
		private String directory;
		private List<String> list;

		public MyFileVisitor(String directory, List<String> list){
			this.directory = directory;
			this.list = list;
		}	
		
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			if (!directory.startsWith(dir.toString())){				
				return FileVisitResult.SKIP_SUBTREE;
			}
			else{
				SwingUtilities.invokeLater(() -> monitor.directoryChangedTo(dir.toString()));				
				return FileVisitResult.CONTINUE;
			}
		}
		
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			if (file.toString().toUpperCase().endsWith(".PDF")){
				publish(file.toString());
				list.add(file.toString());
			}
			return FileVisitResult.CONTINUE;
		}
		
		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			return FileVisitResult.CONTINUE;
		}
	}
}
