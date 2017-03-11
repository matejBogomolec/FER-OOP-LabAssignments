package hr.fer.oop.lab4.prob1;

/**
 * An abstract class listing all basic variables and methods used in extended classes.
 * @author Matej Bogomolec
 *
 */
public abstract class Person 
{
	private final String name;
	private final String country;
	private final int emotion;
	private final int MIN_EMOTION = 0;
	private final int MAX_EMOTION = 100;
	/**
	 * Constructor method used to create an object of extended classes of <code> Person</code>.
	 * @param name - name of this person.
	 * @param country - country of this person.
	 * @param emotion - emotion of this person.
	 */
	public Person (String name, String country, int emotion)
	{
		if (country == null) throw new IllegalArgumentException("Country string must not be " + country +"!");
		if (name == null) throw new IllegalArgumentException("Name string must not be " + name + "!");
		if (emotion < MIN_EMOTION || emotion > MAX_EMOTION) throw new IllegalArgumentException("Person's Emotion "
				+ "value must be in interval [" + MIN_EMOTION + "," + MIN_EMOTION + "], not:" + emotion);
		this.name = name;
		this.country = country;
		this.emotion = emotion;
	}
	/**
	 * Getter method which returns the name of this <code> Person</code>.
	 * @return - name of this person.
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Getter method which returns the country of this <code> Person</code>.
	 * @return - country of this person.
	 */
	public String getCountry()
	{
		return country;
	}
	/**
	 * Getter method which returns the emotion of this <code> Person</code>.
	 * @return - emotion of this person.
	 */
	public int getEmotion()
	{
		return emotion;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (country == null) 
		{
			if (other.country != null)
				return false;
		} 
		else if (!country.equals(other.country))
			return false;
		if (emotion != other.emotion)
			return false;
		if (name == null) 
		{
			if (other.name != null)
				return false;
		} 
		else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + emotion;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
}
