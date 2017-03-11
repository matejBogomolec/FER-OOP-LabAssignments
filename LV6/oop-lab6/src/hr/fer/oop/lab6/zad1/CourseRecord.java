/**
 * @author Matej Bogomolec
 */
package hr.fer.oop.lab6.zad1;

/**
 * The Class CourseRecord holds and changes information of a single course.
 */
public class CourseRecord 
{
	
	/** The course id. */
	private final String courseID;
	
	/** The course name. */
	private final String courseName;
	
	/**
	 * Instantiates a new course record.
	 *
	 * @param courseID the course id
	 * @param courseName the course name
	 */
	public CourseRecord(String courseID, String courseName) 
	{
		this.courseID = courseID;
		this.courseName = courseName;
	}
	
	/**
	 * Gets the course id.
	 *
	 * @return the course id
	 */
	public String getCourseID() 
	{
		return courseID;
	}
	
	/**
	 * Gets the course name.
	 *
	 * @return the course name
	 */
	public String getCourseName() 
	{
		return courseName;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseID == null) ? 0 : courseID.hashCode());
		return result;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseRecord other = (CourseRecord) obj;
		if (courseID == null) {
			if (other.courseID != null)
				return false;
		} else if (!courseID.equals(other.courseID))
			return false;
		return true;
	}
	
}
