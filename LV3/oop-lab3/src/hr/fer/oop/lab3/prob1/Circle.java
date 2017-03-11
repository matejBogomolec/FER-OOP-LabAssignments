package hr.fer.oop.lab3.prob1;
import hr.fer.oop.lab3.pic.*;
/** Class Circle represents a circle. 
 * It provides methods to create a circle and drawing a circle on a Picture class object.
 * 
 * @author Matej Bogomolec
 *
 *
 */
public class Circle 
{
	private int radius;
	private Point center= new Point(0,0);
	/**
	 * Circle constructor which creates a new circle by defining its radius and location of it's center.
	 * The center is defined by a Point class object.
	 *
	 * @param x - radius of a circle
	 * @param point - coordinates of the center of circle via Point class object.
	 */
	Circle (int x, Point point)
	{
		radius=x;
		center=point;
		
	}
	/**
	 * Circle constructor which creates a new circle using an existing Circle class object.
	 * @param circle - Circle class object.
	 */
	Circle (Circle circle)
	{
		this(circle.radius,circle.center);
	}
	/**
	 * Circle constructor which creates a new circle by defining its radius and location of it's center.
	 * @param r - radius of a circle.
	 * @param x - x coordinate of the circle's center.
	 * @param y - y coordinate of the circle's center.
	 */
	Circle (int r, int x, int y)
	{
		radius=r;
		center.setX(x);
		center.setY(y);
	}
	/**
	 * Returns radius of this circle.
	 * @return radius
	 */
	public int getRadius()
	{
		return radius;
	}
	/**
	 * Returns a Point class object which represent a center of this circle.
	 * @return Center of this circle
	 */
	public Point getCenter()
	{
		return center;
	}
	/**
	 * Sets the center of this circle using a Point class object.
	 * @param point - center of this circle.
	 */
	public void setCenter (Point point)
	{
		center=point;
	}
	/**
	 * Method which draws this circle on a Picture class object.
	 * @param picture - Picture object upon which this circle is drawn.
	 */
	public void drawOnPicture(Picture picture)
	{
		int dx, dy;
		for (int i = 0; i < picture.getWidth(); i++)
		{
			for(int j = 0; j < picture.getHeight(); j++)
			{
				dx = i - this.center.getX();
				dy = j - this.center.getY();
				if (dx * dx + dy * dy <= radius * radius) 
				{
					picture.turnPixelOn(i, j);
				}
			}
		}
	}
}
