package hr.fer.oop.lab2.prob1;
import java.util.Scanner;

/**
 * The type Rectangle.
 */
public class Rectangle
{
	/**
	 * Print.
	 *
	 * @param width  the width
	 * @param height the height
	 */
	public static void print(double width, double height)
	{
		System.out.format(
				"You have specified a rectangle of width %.2f and height %.2f."
				+ "Its area is %.2f and its perimeter is %.2f.", width, 
				height, width * height, 2 * (width + height));
	}

	/**
	 * Main.
	 *
	 * @param args the args
	 */
	public static void main (String args[])
	{
		Scanner scan = new Scanner(System.in);
		double rectWidth = 0;
		double rectHeight = 0;
		int argNum = args.length;
		if (argNum != 2 && argNum !=0 )
		{
			System.err.println("Invalid number of arguments was provided.");
			System.exit(1);
		}
		if(argNum==2)
		{
			rectWidth=Double.parseDouble(args[0]);
			rectHeight=Double.parseDouble(args[0]);
			if(rectWidth < 1E-6 || rectHeight < 1E-6)
			{
				System.err.println("Invalid arguments were provided.");
				System.exit(1);	
			}
			else print(rectWidth, rectHeight);
		}
		else
		{
			do
			{
				System.out.print("\nPlease provide width: ");
				rectWidth=scan.nextDouble();
				if(rectWidth < 1E-6) System.out.println("The width must not be negative.");			
			} while(rectWidth < 1E-6);
			do
			{
				System.out.print("\nPlease provide height: ");
				rectHeight=scan.nextDouble();
				if(rectHeight < 1E-6) System.out.println("The width must not be negative.");			
			} while(rectHeight < 1E-6);
			print(rectWidth, rectHeight);
		}
		scan.close();
	}
	
}
