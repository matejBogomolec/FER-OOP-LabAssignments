package hr.fer.oop.lab4.prob2;
import java.util.*;
import java.util.function.Predicate;

import hr.fer.oop.lab4.prob1.*;
/**
 * 
 * @author Matej Bogomolec
 *
 */
public abstract class Team implements IManageableTeam, IMatchInspectableTeam
{
	private static final int MIN_TEAM_SIZE = 1;
	protected int MAX_TEAM_SIZE = 25;
	public static int STARTING_ELEVEN_SIZE = 11;
	private final String name;
	private Formation formation;
	protected Collection<FootballPlayer> registeredPlayers = null;
	private Collection<FootballPlayer> startingEleven = null;
	public int[] formationPlaces = {0,0,0,1}; //FW,MF,DF,GK
	/**
	 * Constructor used to create an object which extends this class.
	 * @param name - name of a team
	 * @param formation - formation of a team
	 */
	public Team (String name, Formation formation)
	{
		if (name == null) throw new IllegalArgumentException("Name string must not be " + name +"!");
		this.name = name;
		this.formation = formation;
		startingEleven = new LinkedHashSet<FootballPlayer>(STARTING_ELEVEN_SIZE);
		registeredPlayers = new LinkedHashSet<FootballPlayer>(MAX_TEAM_SIZE);
		setPlaces(formation);
	}
	/**
	 * Getter method which returns the name of this team.
	 * @return name of this team
	 */
	public String getName ()
	{
		return name;
	}
	
	@Override
	public void registerPlayer(FootballPlayer player) throws NotEligiblePlayerException
	{
		if (isPlayerRegistrable(player))registeredPlayers.add(player);
		else throw new NotEligiblePlayerException("Player is not registrable!");
	}
	@Override
	public void unregisterPlayer(FootballPlayer player)
	{
		if(registeredPlayers == null) return;
		registeredPlayers.remove(player);
	}
	@Override
	public void clearStartingEleven()
	{
		startingEleven.clear();
		setPlaces(formation);
	}
	@Override
	public void addPlayerToStartingEleven(FootballPlayer player)
	{
		if(startingEleven.contains(player));
		switch (player.getPlayingPosition())
		{
			case DF :
			{
				if (formationPlaces[0] > 0)
					{
						if(startingEleven.add(player)) formationPlaces[0]--;
						break;
					}
			}
			case MF :
			{
				if (formationPlaces[1] > 0)
				{
					if(startingEleven.add(player)) formationPlaces[1]--;
					break;
				}
			}
			case FW :
			{
				if (formationPlaces[2] > 0)
				{
					if(startingEleven.add(player)) formationPlaces[2]--;
					break;
				}
			}
			default :
			{
				if (formationPlaces[3] > 0)
				{
					if(startingEleven.add(player)) formationPlaces[3]--;
					break;
				}
			}
		}
	}
	@Override
	public void removePlayerFromStartingEleven(FootballPlayer player)
	{
		if(startingEleven.remove(player))
		{
			switch (player.getPlayingPosition())
			{
				case FW:
				{
					formationPlaces[0]++;
					break;
				}
				case MF:
				{
					formationPlaces[1]++;
					break;
				}
				case DF:
				{
					formationPlaces[2]++;
					break;
				}
				default :
				{
					formationPlaces[2]++;
					break;
				}
			}
		}
		
	}
	@Override
	public void setFormation(Formation formation)
	{
		this.formation = formation;
		setPlaces(formation);
	}
	@Override
	public Formation getFormation()
	{
		return formation;
	}
	@Override
	public Collection<FootballPlayer> getRegisteredPlayers()
	{
		Collection<FootballPlayer> collection = new LinkedHashSet<FootballPlayer>();
		collection.addAll(registeredPlayers);
		return collection;
	}
	@Override
	public Collection<FootballPlayer> getStartingEleven()
	{
		Collection<FootballPlayer> collection = new LinkedHashSet<FootballPlayer>();
		collection.addAll(startingEleven);
		return collection;
	}
	@Override
	public boolean isPlayerRegistrable(FootballPlayer player)
	{
		for (FootballPlayer registered : registeredPlayers)
		{
			if (registered.equals(player)) return false;
		}
		return true;
	}
	@Override
	public Collection<FootballPlayer> filterRegisteredPlayers(Predicate<FootballPlayer> criteria)
	{
		Collection<FootballPlayer> collection = new LinkedHashSet<FootballPlayer>();
		for(FootballPlayer player : registeredPlayers)
		{
			if (criteria.test(player)) collection.add(player);
		}
		return collection;
	}
	@Override
	public boolean isMatchReady()
	{
		if (startingEleven.size() < MIN_TEAM_SIZE) return false;
		else return true;
	}
	@Override
	public int calculateTeamSpirit()
	{
		int sum = 0;
		for(FootballPlayer player : startingEleven)
		{
			sum+=player.getEmotion();
		}
		return sum;
	}
	@Override
	public int calculateTeamSkill()
	{
		int sum = 0;
		for(FootballPlayer player : startingEleven)
		{
			sum+=player.getPlayingSkill();
		}
		return sum;
	}
	@Override
	public double calculateRating()
	{
		double rating = 0;
		rating+= calculateTeamSkill() + calculateTeamSpirit();
		return rating;
	}
	public void setPlaces(Formation formation)
	{
		switch (formation)
		{
			case F442 : 
			{
				setFormationPlaces(4,4,2);
				break;
			}
			case F541 :
			{
				setFormationPlaces(5,4,1);
				break;
			}
			default :
			{
				setFormationPlaces(3,5,2);
				break;
			}
		}
	}
	public void setFormationPlaces(int df, int mf, int fw)
	{
		formationPlaces[0] = df;
		formationPlaces[1] = mf;
		formationPlaces[2] = fw;
		formationPlaces[3] = 1;
	}
	public int getTeamSize ()
	{
		return MAX_TEAM_SIZE;
	}
}
