package hr.fer.oop.zi_vjezba.task3;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
	
	private FileSearchMonitor monitor;
	public FileSearcher(FileSearchMonitor monitor){
		this.monitor = monitor;
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
		monitor.searchFinished();
		return pdfs;
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
			//neæe raditi dobro ako je na Windowsima odredišni direktorij zadan s / umjesto \\
			//ali zanemarvo za ispit
			//u stvarnosti bi koristiti Path i metodu getName i usporeðivali dijelove putanje 			
			if (!directory.startsWith(dir.toString())){				
				return FileVisitResult.SKIP_SUBTREE;
			}
			else{
				monitor.directoryChangedTo(dir.toString());
				return FileVisitResult.CONTINUE;
			}
		}
		
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			if (file.toString().toUpperCase().endsWith(".PDF")){
				monitor.fileFound(file.toString());
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
