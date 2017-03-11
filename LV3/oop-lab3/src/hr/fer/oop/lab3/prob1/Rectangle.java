package hr.fer.oop.lab3.prob1;

import hr.fer.oop.lab3.pic.Picture;
/** Class Rectangle represents a rectangle. 
 * It provides methods to create a rectangle and drawing a rectangle on a Picture class object.
 * 
 * @author Matej Bogomolec
 *
 *
 */

public class Rectangle {
	private int height, width;
	private Point center = new Point(0,0);
	/**
	 * Rectangle constructor which creates a new rectangle by defining its height, width, and location of it's center.
	 * The center is defined by a Point class object.
	 * @param x - rectangle width
	 * @param y - rectangle height
	 * @param point - coordinates of the center of rectangle via Point class object.
	 */
	Rectangle (int x, int y, Point point)
	{
		height =  x;
		width = y;
		center = point;
	}
	/**
	 * Rectangle constructor which creates a new rectangle using an existing Rectangle class object.
	 * @param rectangle
	 */
	Rectangle (Rectangle rectangle)
	{
		this(rectangle.height,rectangle.width,rectangle.center);
	}
	/**
	 * Rectangle constructor which creates a new rectangle by defining its height, width, and location of it's center.
	 * @param x - rectangle width
	 * @param y - rectangle height
	 * @param z - x coordinate of the center
	 * @param q - y coordinate of the center
	 */
	Rectangle (int x, int y, int z, int q)
	{
		height =  x;
		width = y;
		center.setX(z);
		center.setY(q);
	}
	/**
	 *  Method which draws this rectangle on a Picture class object.
	 * @param picture - Picture object upon which this rectangle is drawn
	 */
	public void drawOnPicture(Picture picture)
	{
		for (int i = 0; i < picture.getWidth(); i++)
		{
			for(int j = 0; j < picture.getHeight(); j++)
			{
				if (((i < this.center.getX() + width / 2 ) && (i >= this.center.getX() - width / 2))
						&& (j < this.center.getY() + height / 2) && (j >= this.center.getY() - height / 2))
				{
					picture.turnPixelOn(i, j);
				}
			}
		}
	}
}
