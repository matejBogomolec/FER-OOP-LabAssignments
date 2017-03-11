/**
 * @author Matej Bogomolec
 */
package hr.fer.oop.lab6.zad1;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentRecord holds and changes information of a single student.
 */
public class StudentRecord 
{
	
	/** The jmbag. */
	private final String jmbag;
	
	/** The first name. */
	private final String firstName;
	
	/** The last name. */
	private final String lastName;
	
	/** The final grade. */
	private int finalGrade;
	
	/**
	 * Instantiates a new student record.
	 *
	 * @param jmbag the jmbag of a student
	 * @param firstName the first name of a student
	 * @param lastName the last name of a student
	 * @param finalGrade the final grade of a student
	 */
	public StudentRecord(String jmbag, String firstName, String lastName, int finalGrade)
	{
		this.jmbag = jmbag;
		this.firstName = firstName;
		this.lastName = lastName;
		this.finalGrade = finalGrade;
	}
	
	/**
	 * Gets the final grade.
	 *
	 * @return the final grade
	 */
	public int getFinalGrade() 
	{
		return finalGrade;
	}

	/**
	 * Sets the final grade.
	 *
	 * @param finalGrade the new final grade
	 */
	public void setFinalGrade(int finalGrade) 
	{
		this.finalGrade = finalGrade;
	}

	/**
	 * Gets the jmbag.
	 *
	 * @return the jmbag
	 */
	public String getJmbag() 
	{
		return jmbag;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() 
	{
		return lastName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jmbag == null) ? 0 : jmbag.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentRecord other = (StudentRecord) obj;
		if (jmbag == null) {
			if (other.jmbag != null)
				return false;
		} else if (!jmbag.equals(other.jmbag))
			return false;
		return true;
	}
	
}
