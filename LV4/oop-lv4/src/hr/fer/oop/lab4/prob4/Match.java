package hr.fer.oop.lab4.prob4;

import hr.fer.oop.lab4.prob2.IMatchInspectableTeam;
import java.math.*;
/**
 * Class for simulating a football match.
 * @author Matej Bogomolec
 * @implements IPlayableMatch
 *
 */
public class Match implements IPlayableMatch
{
	private final IMatchInspectableTeam home;
	private final IMatchInspectableTeam away;
	private final MatchType type;
	private MatchOutcome outcome = MatchOutcome.NOT_AVAILABLE;
	/**
	 * Constructor for creating object of football match.
	 * @param home - home team
	 * @param away - away team
	 * @param type - match type
	 */
	Match(IMatchInspectableTeam home, IMatchInspectableTeam away, MatchType type)
	{
		this.home = home;
		this.away = away;
		this.type = type;
	}
	@Override
	public void play () throws NotPlayableMatchException
	{
		if((home == null || away == null)) throw new NotPlayableMatchException("One of the teams are not set.");
		if(!home.isMatchReady() || !away.isMatchReady()) throw new NotPlayableMatchException("One of the teams are not ready.");
		if(home.equals(away)) throw new NotPlayableMatchException("Both teams are the same.");
		if(type == MatchType.COMPETITIVE)
		{
			if (home.isTeamNational() != away.isTeamNational()) throw new NotPlayableMatchException("Both teams must be eiter "
					+ "clubs or national teams in a competetive match.");
		}
		double h, a, rng;
		rng = Math.random();
		h = (home.calculateRating()) / (home.calculateRating() + away.calculateRating());
		a = (away.calculateRating()) / (home.calculateRating() + away.calculateRating());
		if(rng < h - (Math.min(a, h)/2.)) outcome = MatchOutcome.HOME_WIN;
		else if (rng > h + (Math.min(a, h)/2.)) outcome = MatchOutcome.AWAY_WIN;
		else outcome = MatchOutcome.DRAW;
		
	}
	/**
	 * Getter method which returns home team.
	 * @return home team
	 */
	public IMatchInspectableTeam getHome()
	{
		return home;
	}
	/**
	 * Getter method which returns away team.
	 * @return away team
	 */
	public IMatchInspectableTeam getAway()
	{
		return away;
	}
	/**
	 * Getter method which returns match type.
	 * @return match type
	 */
	public MatchType getType()
	{
		return type;
	}
	/**
	 * Getter method which returns outcome of this match.
	 * @return outcome of this match.
	 */
	public MatchOutcome getOutcome()
	{
		return outcome;
	}
}
