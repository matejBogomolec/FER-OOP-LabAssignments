package hr.fer.oop.lab4.prob2;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import hr.fer.oop.lab4.prob1.*;
/**
 * Interface which contains all necessary methods and exceptions for managing a team.
 * @author Matej Bogomolec
 *
 */
public interface IManageableTeam 
{
	
	/**
	 * Method which inserts a <code> FootballPlayer </code> object into a registered players collection.
	 * @param player - player for registration.
	 * @throws NotEligiblePlayerException - thrown when a player cannot be registered.
	 */
	public void registerPlayer(FootballPlayer player) throws NotEligiblePlayerException;
	
	/**
	 * Method which removes a <code> FootballPlayer </code> object into a registered players collection.
	 * @param player - player that needs to be removed.
	 * @throws IllegalArgumentException thrown when an illegal argument player is given to the method.
	 */
	public void unregisterPlayer(FootballPlayer player) throws IllegalArgumentException;
	/**
	 * Method which removes all players from starting eleven array .
	 */
	public void clearStartingEleven();
	
	/**
	 * Method which inserts a <code> FootballPlayer </code> object into a starting eleven collection.
	 * @param player - player for registration.
	 * @throws NotEligiblePlayerException - thrown when a player cannot be registered.
	 */
	public void addPlayerToStartingEleven(FootballPlayer player) throws NotEligiblePlayerException;
	
	/**
	 * Method which removes a <code> FootballPlayer </code> object into a starting eleven collection.
	 * @param player - player that needs to be removed.
	 * @throws IllegalArgumentException - thrown when an illegal argument player is given to the method.
	 */
	public void removePlayerFromStartingEleven(FootballPlayer player) throws IllegalArgumentException;
	
	/**
	 * Setter method which sets the formation of an object that iterates this interface.
	 * @param formation
	 */
	public void setFormation(Formation formation);
	
	/**
	 * Getter method which returns the formation of an object that iterates this interface.
	 * @return
	 */
	public Formation getFormation();
	
	/**
	 * Method which creates a <b> NEW </b> collection of the registered players.
	 * @return registered player collection.
	 */
	public Collection<FootballPlayer> getRegisteredPlayers();
	
	/**
	 * Method which creates a <b> NEW </b> collection of the starting eleven.
	 * @return registered player collection.
	 */
	public Collection<FootballPlayer> getStartingEleven();
	
	/**
	 * Method used to check if the player is registrable into the team
	 * @param player - player pending for registration.
	 * @return true if player is registrable, else false.
	 */
	public boolean isPlayerRegistrable(FootballPlayer player);
	/**
	 *  Method which creates a <b> NEW </b> filtered collection of the registered players.
	 * @param criteria - filter
	 * @return filtered collection of the registered players.
	 */
	public Collection<FootballPlayer> filterRegisteredPlayers(Predicate<FootballPlayer> criteria);
}
