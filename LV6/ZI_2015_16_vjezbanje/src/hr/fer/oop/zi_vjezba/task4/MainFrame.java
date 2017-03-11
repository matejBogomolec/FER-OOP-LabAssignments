package hr.fer.oop.zi_vjezba.task4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class MainFrame extends JFrame implements FileSearchMonitor  {
	JTextArea text;
	public MainFrame(){
		text = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(text);
		add(scrollPane, BorderLayout.CENTER);		
		this.setPreferredSize(new Dimension(800, 600));
	}
	@Override
	public void directoryChangedTo(String directory) {
		text.append("Dir changed to: " + directory + "\n");
	
	}

	@Override
	public void fileFound(String filename) {
		text.append(filename + "\n");		
	}

	@Override
	public void searchFinished() {
		text.append("Search finihed");
		
	}
	public static void main(String[] args) {		
		SwingUtilities.invokeLater(() -> {	
			MainFrame frame = new MainFrame();
			frame.pack();
			frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			SwingWorker <List<String>, String> worker = new FileSearcher(frame, "H:\\FER\\3.semestar\\OOP", "H:\\FER\\3.semestar\\OOP\\Zadaci");
			worker.execute();
		});		
	}
}
