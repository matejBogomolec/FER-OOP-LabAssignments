package hr.fer.oop.lab4.prob2;
/**
 * Interface which contains all necessary methods to inspect if a team for a match.
 * @author Matej Bogomolec
 *
 */
public interface IMatchInspectableTeam 
{
	/**
	 * Method which checks if is the team ready for a match.
	 * @return true if the team is ready for a match, else false
	 */
	public boolean isMatchReady();
	/**
	 * Method which calculates team spirit.
	 * @return team spirit.
	 */
	public int calculateTeamSpirit();
	/**
	 * Method which calculates team skill.
	 * @return team skill.
	 */
	public int calculateTeamSkill();
	/**
	 * Method which calculates team rating.
	 * @return team rating.
	 */
	public double calculateRating();
	/**
	 * Method which determines if the team is national team or club team.
	 * @return true if team is national, else false.
	 */
	public boolean isTeamNational();
}
