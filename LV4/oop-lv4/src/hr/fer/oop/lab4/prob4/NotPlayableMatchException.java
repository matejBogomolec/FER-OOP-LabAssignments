package hr.fer.oop.lab4.prob4;
/**
 * Exception for reporting a not playable match.
 * @author Matej Bogomolec
 *
 */
public class NotPlayableMatchException extends Exception 
{
	/**
	 * Constructor of the exception.
	 * @param message - exception message
	 */
	public NotPlayableMatchException (String message)
	{
		super(message);
	}
}
