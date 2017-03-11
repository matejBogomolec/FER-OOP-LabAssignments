package hr.fer.oop.lab6.zad3;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import hr.fer.oop.lab6.zad1.Database;
import hr.fer.oop.lab6.zad2.StudentsPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class TabbedFrame.
 */
@SuppressWarnings("serial")
public class TabbedFrame extends JFrame
{
	
	/** The students. */
	static StudentsPanel students;
	
	/** The subjects. */
	private SubjectsPanel subjects;
	
	/** The tabbed pane. */
	static JTabbedPane tabbedPane;
	
	private SubjectListPanel subjectList;
	
	/**
	 * Instantiates a new tabbed frame.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public TabbedFrame() throws IOException
	{
		Database data = new Database("studenti.txt", "predmeti.txt", "UpisaniPredmeti.txt");
		students = new StudentsPanel(data);
		subjects = new SubjectsPanel(data);
		subjectList = new SubjectListPanel(data);
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Studenti", students);
		tabbedPane.addTab("Predmeti", subjects);
		tabbedPane.addTab("Svi predmeti", subjectList);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(tabbedPane, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
}

