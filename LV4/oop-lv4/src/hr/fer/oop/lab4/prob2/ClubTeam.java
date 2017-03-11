package hr.fer.oop.lab4.prob2;

import hr.fer.oop.lab4.prob1.FootballPlayer;
import hr.fer.oop.lab4.prob1.Formation;
import hr.fer.oop.lab4.prob2.NotEligiblePlayerException;

public class ClubTeam extends Team
{
	private static int MAX_REP = 100;
	private static int MIN_REP = 0;
	private int reputation;
	public ClubTeam (String name, Formation formation, int reputation)
	{
		super(name,formation);
		if(reputation < MIN_REP || reputation > MAX_REP) throw new IllegalArgumentException("Team reputation "
				+ "value must be in interval [" + MIN_REP + "," + MAX_REP + "], not:" + reputation);
		this.reputation = reputation;
		super.MAX_TEAM_SIZE = 23;
	}
	public int getReputation()
	{
		return reputation;
	}
	public void setReputation(int reputation)
	{
		if(reputation < MIN_REP || reputation > MAX_REP) throw new IllegalArgumentException("Players Skill "
				+ "value must be in interval [" + MIN_REP + "," + MAX_REP + "], not:" + reputation);
		this.reputation = reputation;
	}
	@Override
	public double calculateRating ()
	{
		double rating = 0;
		rating+= 0.7*calculateTeamSkill() + 0.3*calculateTeamSpirit();
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
		if (player.getPlayingSkill() >= reputation) return true;
		else return false;
	}
	/**
	 * Method which determines if this club is national.
	 * @return always false
	 */
	public boolean isTeamNational()
	{
		return false;
	}


}