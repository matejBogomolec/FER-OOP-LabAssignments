package hr.fer.oop.lab6.zad2;

import javax.swing.SwingUtilities;

// TODO: Auto-generated Javadoc
/**
 * The Class Frame1Runner runs main method which generates a StudentFrame.
 */
public class Frame1Runner {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args)
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
}
