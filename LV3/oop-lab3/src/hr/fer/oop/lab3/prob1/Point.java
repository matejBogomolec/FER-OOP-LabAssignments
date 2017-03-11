package hr.fer.oop.lab3.prob1;
/**
 * Class Point represents a single point.
 * It provides methods to create a single point.
 * @author Matej Bogomolec
 *
 */
public class Point {
	private int x, y;
	/**
	 * Point constructor which creates a new point by defining it's coordiantes.
	 * @param x - x coordinate of this point.
	 * @param y - y coordinate of this point.
	 */
	Point (int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	/**
	 * Point constructor which creates a new point using an existing Point class object.
	 * @param point - Point class object.
	 */
	Point (Point point)
	{
		this(point.x,point.y);
	}
	/**
	 * Returns the x coordinate of this Point
	 * @return x
	 */
	int getX ()
	{
		return x;
	}
	/**
	 * Returns the y coordinate of this Point.
	 * @return y
	 */
	int getY ()
	{
		return y;
	}
	/**
	 * Sets the x coordinate of this Point.
	 * @param x - x coordinate
	 */
	void setX (int x)
	{
		this.x = x;
	}
	/**
	 * Sets the y coordinate of this Point.
	 * @param y - y coordinate
	 */
	void setY (int y)
	{
		this.y = y;
	}
}
