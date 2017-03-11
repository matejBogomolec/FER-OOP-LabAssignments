package hr.fer.oop.lab6.zad3;

import javax.swing.SwingUtilities;

import hr.fer.oop.lab6.zad2.StudentsFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class Frame2Runner.
 */
public class Frame2Runner {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(()-> 
		{
			TabbedFrame frame;
			try 
			{
				frame = new TabbedFrame();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		});
	}

}
