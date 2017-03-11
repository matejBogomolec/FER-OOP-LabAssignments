package hr.fer.oop.lab4.prob3;
/**
 * Exception for reporting a unemployed coach.
 * @author Matej Bogomolec
 *
 */
public class UnemployedCoachException extends Exception
{
	/**
	 * Constructor of the exception.
	 * @param message - exception message
	 */
	public UnemployedCoachException (String message)
	{
		super(message);
	}
}

