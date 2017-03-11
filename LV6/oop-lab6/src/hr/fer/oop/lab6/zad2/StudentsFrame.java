package hr.fer.oop.lab6.zad2;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

import hr.fer.oop.lab6.zad1.*;
// TODO: Auto-generated Javadoc

/**
 * The Class StudentsFrame.
 */
public class StudentsFrame extends JFrame
{
	
	/** The panel. */
	private StudentsPanel panel;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException 
	{
		SwingUtilities.invokeLater(()-> 
		{
			StudentsFrame frame;
			try {
				frame = new StudentsFrame();
				  frame.pack();
			      frame.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		});
	}
	
	/**
	 * Instantiates a new students frame.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public StudentsFrame() throws IOException 
	{
		Database data = new Database("studenti.txt", "predmeti.txt", "UpisaniPredmeti.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel=new StudentsPanel(data);
		getContentPane().add(panel, BorderLayout.CENTER);
	}
	
}
