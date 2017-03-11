package hr.fer.oop.lab3.prob1;

import hr.fer.oop.lab3.pic.Picture;
/**
 * Class EquilateralTriangle represents a equilateral triangle. 
 * It provides methods to create a equilateral triangle and drawing a circle on a Picture class object.
 * @author Matej Bogomolec
 *
 */
public class EquilateralTriangle {
	private int side;
	private Point base_midpoint = new Point(0,0);
	/**
	 * EquilateralTriangle constructor which creates a new equilateral triangle by defining its side and location of it's base midpoint.
	 * The base midpoint is defined by a Point class object.
	 * @param x - side of this triangle
	 * @param point - coordinates of the base midpoint via Point class object.
	 */
	EquilateralTriangle(int x, Point point)
	{
		side = x;
		base_midpoint = point;
	}
	/**
	 * EquilateralTriangle constructor which creates a new equilateral triangle using an existent Triangle class object.
	 * @param triangle EquilateralTriangle class object.
	 */
	EquilateralTriangle(EquilateralTriangle triangle)
	{
		this(triangle.side,triangle.base_midpoint);
	}
	/**
	 * EquilateralTriangle constructor which creates a new equilateral triangle by defining its side and location of it's base midpoint.
	 * @param z - side of the triangle
	 * @param x - x coordinate of the base midpoint
	 * @param y - y coordinate of the base midpoint
	 */
	EquilateralTriangle(int z, int x, int y)
	{
		side = x;
		base_midpoint.setX(y);
		base_midpoint.setY(z);
	}
	/**
	 * Method which draws this  equilateral triangle on a Picture class object.
	 * @param picture - Picture object upon which this circle is drawn.
	 */
	public void drawOnPicture(Picture picture)
	{
		Point triangle_top = new Point(this.base_midpoint.getX(), 
				this.base_midpoint.getY() + (int) ((Math.sqrt(3) / 4)* 20.));
		for (int i = 0; i < picture.getWidth(); i++)
		{
			for(int j = 0; j < picture.getHeight(); j++)
			{
				if ((j >= triangle_top.getY()) && (j <=triangle_top.getY() + side) 
						&& (i <= base_midpoint.getX() + Math.abs(j - triangle_top.getY()) / 2)
						&& (i >= base_midpoint.getX() - Math.abs(j - triangle_top.getY()) / 2))
				{
					picture.turnPixelOn(i, j);

				}
			}
		}
	}
}

