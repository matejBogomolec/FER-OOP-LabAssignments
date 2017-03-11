package hr.fer.oop.lab4.prob2;

/**
 * Exception for reporting an illegal player.
 * @author Matej Bogomolec
 *
 */
public class NotEligiblePlayerException extends Exception
{
	/**
	 * Constructor of the exception.
	 * @param message - exception message
	 */
	public NotEligiblePlayerException (String message)
	{
		super(message);
	}
}
