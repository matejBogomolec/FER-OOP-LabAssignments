package hr.fer.oop.zi_vjezba.task3;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		FileSearchMonitor monitor = new FileSearchMonitor() {				
			@Override
			public void searchFinished() {
				System.out.println("Search finished");				
			}			
			@Override
			public void fileFound(String filename) {
				System.out.println("\t" + filename);				
				
			}			
			@Override
			public void directoryChangedTo(String directory) {
				System.out.println("Dir changed to: " + directory);
				
			}
		};
		FileSearcher searcher = new FileSearcher(monitor);
		List<String> list = searcher.findPDFsInRange("H:\\", "H:\\FER\\3.semestar\\OOP");
		System.out.println("Total files: " + list.size());
		
	}

}
