package hr.fer.oop.lab4.prob1;
/**Class FotballPlayer contains list of methods used to create and modify a football player
* @extends  <code> Person </code>
* @author Matej Bogomolec
* 
*/
public class FootballPlayer extends Person 
{
	private int playingSkill;
	private PlayingPosition playingPosition;
	public final static int MIN_PLAYING_SKILL = 0;
	public final static int MAX_PLAYING_SKILL = 100;
	
	/**
	 * Constructor used to create an object of a class <code> FootballPlayer </code>
	 * @param name - football players name..
	 * @param country - football players country.
	 * @param emotion - football players emotion.
	 * @param playingSkill - football players playing skill.
	 */
	public FootballPlayer(String name, String country, int emotion, int playingSkill,
			PlayingPosition playingPosition)
	{
		super (name,country,emotion);
		if (playingSkill < MIN_PLAYING_SKILL || playingSkill > MAX_PLAYING_SKILL) throw new IllegalArgumentException("Players Skill "
				+ "value must be in interval [" + MIN_PLAYING_SKILL + "," + MAX_PLAYING_SKILL + "], not:" + playingSkill);
		this.playingSkill = playingSkill;
		this.playingPosition = playingPosition;
	}
	
	/**
	 * Getter method which returns playing skill of this football player.
	 * @return playing skill.
	 */
	public int getPlayingSkill()
	{
		return playingSkill;
	}
	
	/**
	 * Setter method which sets the playing skill of this football player.
	 * @param playingSkill - desired playing skill.
	 */
	public void setPlayingSkill(int playingSkill)
	{
		this.playingSkill=playingSkill;
	}
	
	/**
	 * Getter method which returns playing position of this football player.
	 * @return playing position of this football player.
	 */
	public PlayingPosition getPlayingPosition()
	{
		return playingPosition;
	}
	
	/**
	 * Setter method which sets the playing position of this football player.
	 * @param playingPosition - desired playing position.
	 */
	public void setPlayingPosition(PlayingPosition playingPosition)
	{
		this.playingPosition = playingPosition;
	}
}
