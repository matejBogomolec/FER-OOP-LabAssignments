package hr.fer.oop.lab3.prob1;
import hr.fer.oop.lab3.pic.*;
/**
 * Class Demonstration contains method main to test the execution of classes Circle, EquilateralTriangle and Rectangle 
 * @author Matej Bogomolec
 *
 */
public class Demostration {
	public static void main (String args[])
	{
	Picture frame = new Picture (100, 50);
	Rectangle rec1 = new Rectangle (10, 6 , 15, 20);
	EquilateralTriangle tri = new EquilateralTriangle (15,50,25);
	rec1.drawOnPicture(frame);
	tri.drawOnPicture(frame);
	frame.renderImageToStream(System.out);
	PictureDisplay.showPicture(frame, 3);
	}

}
