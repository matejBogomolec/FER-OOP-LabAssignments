package hr.fer.oop.lab4.prob1;
import java.util.*;
import java.util.function.Predicate;

import hr.fer.oop.lab4.prob2.IManageableTeam;
import hr.fer.oop.lab4.prob2.NotEligiblePlayerException;
import hr.fer.oop.lab4.prob3.*;
import hr.fer.oop.lab4.zad.ITrainer;


/**
 * Class Coach contains list of methods used in managing an assigned object of a class <code> Team </code> via <code> IManaegableTeam </code> interface.
 * @extends  <code> Person </code>
 * @implements <code> IManager </code>
 * @author Matej Bogomolec
 *
 */

public class Coach extends Person implements IManager, ITrainer
{
	private int coachingSkill;
	private Formation favoriteFormation;
	private final int MIN_SKILL = 0;
	private final int MAX_SKILL = 100;
	private IManageableTeam managingTeam;
	//Komparator potreban za sortiranje po vještini igraèa.
	final Comparator<FootballPlayer> PLAYER_SKILL = 
             new Comparator<FootballPlayer>() 
	{
		public int compare(FootballPlayer p1, FootballPlayer p2) 
		{
			return p1.getPlayingSkill() - p2.getPlayingSkill();
		}
	};
	/**
	 * Constructor method used to create an object of class <code> Coach</code>.
	 * @param name - name of this Coach.
	 * @param country - country of this Coach.
	 * @param emotion - emotion of this Coach.
	 * @param coachingSkill - Coaching skill of this Coach.
	 * @param formation - preferred formation of this Coach.
	 */
	public Coach (String name, String country, int emotion, int coachingSkill, 
			Formation formation)
	{
		super (name,country,emotion);
		if (coachingSkill < MIN_SKILL || coachingSkill > 100) throw new IllegalArgumentException("Coachers Skill "
				+ "value must be in interval [" + MIN_SKILL + "," + MAX_SKILL + "], not:" + coachingSkill);
		this.coachingSkill = coachingSkill;
		this.favoriteFormation = formation;
	}
	
	/**
	 * Getter method that returns the value of coachingSkill of this <code> Coach</code>.
	 * @return Coaching skill of this Coach.
	 */
	public int getCoachingSkill()
	{
		return coachingSkill;
	}
	
	/**
	 * Setter method that sets coaching skill of this <code> Coach</code>.
	 * @param coachingSkill - Coaching skill of this Coach.
	 */
	public void setCoachingSkill (int coachingSkill)
	{
		this.coachingSkill = coachingSkill;
	}
	
	/**
	 * Getter method that returns the  favorite formation of this <code> Coach</code>.
	 * @return - preferred formation of this Coach.
	 */
	public Formation getFavoriteFormation()
	{
		return favoriteFormation;
	}
	
	/**
	 * Setter method that sets favorite formation of this <code> Coach</code>.
	 * @param formation
	 */
	public void setFavoriteFormation(Formation formation)
	{
		this.favoriteFormation = formation;
	}
	
	/**
	 * Method used to register a list of players using a given criteria.
	 */
	public void registerPlayers(Iterable<FootballPlayer> offeredPlayers, Predicate<FootballPlayer> criteria) throws UnemployedCoachException
	{
		if (managingTeam == null) throw  new UnemployedCoachException("Coach" + super.getName()+ "is unemployed.");
		for(FootballPlayer player : offeredPlayers)
		{
			if(criteria.test(player)) 
			{
				try
				{
					managingTeam.registerPlayer(player);
				}
				catch (NotEligiblePlayerException e)
				{
					System.out.println("Greška: " + e.toString() +"\nOporavak ");
				}
			}

		}
		
	}
	
	/**
	 * Method used to pick starting eleven of a team using a list of registered players and a given criteria.
	 */
	public void pickStartingEleven(Predicate<FootballPlayer> criteria) throws UnemployedCoachException
	{
		if (managingTeam == null) throw  new UnemployedCoachException("Coach" + super.getName()+ "is unemployed.");
		
		for(FootballPlayer player : managingTeam.getRegisteredPlayers())
		{
			if(criteria.test(player))
			{
				try 
				{
					managingTeam.addPlayerToStartingEleven(player);
				} 
				catch (NotEligiblePlayerException e) 
				{
					System.out.println("Greška: " + e.toString() +"\nOporavak ");
				}
			}
		}
	}
	
	/**
	 * Method used to set the teams formation using the coaches favorite formation.
	 */
	public void forceMyFormation() throws UnemployedCoachException
	{
		if (managingTeam == null) throw  new UnemployedCoachException("Coach" + super.getName()+ "is unemployed.");
		managingTeam.setFormation(favoriteFormation);
		managingTeam.clearStartingEleven();
	}
	
	/**
	 * Method used to assign a <code> Team</code> to this <code> Coach</code>.
	 */
	public void setManagingTeam(IManageableTeam team)
	{
		this.managingTeam = team;
	}
	
	/**
	 * Getter method used to return the assigned <code> Team</code>. of this <code> Coach</code>.
	 * @return
	 */
	public IManageableTeam getManagingTeam()
	{
		return managingTeam;
	}
	
	//Metode zadatka
	public void performTrainingSession ()
	{
		Collection <FootballPlayer> trainingPlayers = managingTeam.filterRegisteredPlayers(
				(FootballPlayer player) -> (player.getPlayingSkill() < coachingSkill) 
				&& !managingTeam.getStartingEleven().contains(player));
		for(FootballPlayer player : trainingPlayers)
		{
			player.setPlayingSkill(player.getPlayingSkill() + (int) (0.1*coachingSkill));
		}
	}
	public Collection <FootballPlayer> sortRegisteredPlayers()
	{
		List<FootballPlayer> bestRegisteredtPlayers =  (List<FootballPlayer>) managingTeam.getRegisteredPlayers();
		Collections.sort(bestRegisteredtPlayers, PLAYER_SKILL);
		return bestRegisteredtPlayers;
	}
}
