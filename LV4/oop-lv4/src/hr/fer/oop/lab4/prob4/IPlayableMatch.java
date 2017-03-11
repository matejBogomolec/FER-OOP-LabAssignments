package hr.fer.oop.lab4.prob4;
/**
 * Interface for simulation of a football match between two teams.
 * @author Matej Bogomolec
 *
 */
public interface IPlayableMatch 
{
	/**
	 * Method which simulates a match.
	 * @throws NotPlayableMatchException thrown when a match is not playable.
	 */
	public void play() throws NotPlayableMatchException;
}
