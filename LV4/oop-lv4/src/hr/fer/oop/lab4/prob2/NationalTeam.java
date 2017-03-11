package hr.fer.oop.lab4.prob2;


import hr.fer.oop.lab4.prob1.FootballPlayer;
import hr.fer.oop.lab4.prob1.Formation;

public class NationalTeam extends Team 
{
	private final String country;
	public NationalTeam(String name, Formation formation, String country )
	{
		super(name,formation);
		if (country == null) throw new IllegalArgumentException("Country string must not be " + country +"!");
		this.country = country;
		super.MAX_TEAM_SIZE = 23;
		
	}
	public String getCountry()
	{
		return country;
	}

	@Override
	public double calculateRating ()
	{
		double rating = 0;
		rating+= 0.3*calculateTeamSkill() + 0.7*calculateTeamSpirit();
		return rating;
	}
	@Override
	public void registerPlayer (FootballPlayer player) throws NotEligiblePlayerException
	{
		if (isPlayerRegistrable(player) && registeredPlayers.size() <= MAX_TEAM_SIZE) registeredPlayers.add(player);
		else throw new NotEligiblePlayerException("Player " +player.getName()+" is not registrable");
	}
	@Override
	public boolean isPlayerRegistrable (FootballPlayer player)
	{
		for (FootballPlayer registered : registeredPlayers)
		{
			if (registered.equals(player)) return false;
		}
		if (player.getCountry() == country) return true;
		else return false;
	}
	/**
	 * Method which determines if this club is national.
	 * @return always true
	 */
	public boolean isTeamNational()
	{
		return true;
	}

}
