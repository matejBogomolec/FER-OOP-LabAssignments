package hr.fer.oop.lab4.prob3;

import java.util.function.Predicate;
import hr.fer.oop.lab4.prob1.FootballPlayer;
import hr.fer.oop.lab4.prob2.IManageableTeam;


/**
 * Interface which contains all necessary methods and exceptions for a coach to manage a team.
 * @author Matej Bogomolec
 *
 */
public interface IManager
{
	/**
	 * Method which registers all offered players based on a given criteria.
	 * @param offeredPlayers - list of players pending for registration.
	 * @param criteria - filter for registration.
	 * @throws UnemployedCoachException thrown when team is not assigned to a coach.
	 */
	public void registerPlayers(Iterable<FootballPlayer> offeredPlayers, Predicate<FootballPlayer> criteria) throws UnemployedCoachException;
	/**
	 * Method which pick starting eleven from all registered players based on a given criteria.
	 * @param criteria - filter for assigning a player to the starting eleven
	 * @throws UnemployedCoachException thrown when team is not assigned to a coach.
	 */
	public void pickStartingEleven(Predicate<FootballPlayer> criteria) throws UnemployedCoachException;
	/**
	 * Method which sets teams position into coaches favorite position.
	 * @throws UnemployedCoachException thrown when team is not assigned to a coach.
	 */
	public void forceMyFormation() throws UnemployedCoachException;
	/**
	 * Method which assigns a team to a coach.
	 * @param team - team which is assigned to a coach
	 */
	public void setManagingTeam(IManageableTeam team);
	
}
