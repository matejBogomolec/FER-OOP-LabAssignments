/**
 * @author Matej Bogomolec
 */
package hr.fer.oop.lab6.zad1;

import java.util.HashMap;
import java.util.Map;


/**
 * The Class CourseTable contains a map of all courses. The map uses the course as a key, and CourseRecord objects as values.
 */
public class CourseTable
{
	
	/** The course table. */
	private Map<String, CourseRecord> courseTable;

	/**
	 * Instantiates a new course table from an existing course table.
	 *
	 * @param courseTable the course table
	 */
	public CourseTable(Map<String, CourseRecord> courseTable) 
	{
		this.courseTable = courseTable;
	}

	/**
	 * Instantiates a new empty course table.
	 */
	public CourseTable() 
	{
		this.courseTable = new HashMap<String, CourseRecord>();
	}

	/**
	 * Gets the course table.
	 *
	 * @return the course table
	 */
	public Map<String, CourseRecord> getCourseTable()
	{
		return courseTable;
	}

	/**
	 * Sets the course table.
	 *
	 * @param courseTable the course table
	 */
	public void setCourseTable(Map<String, CourseRecord> courseTable) 
	{
		this.courseTable = courseTable;
	}
	
	/**
	 * Finds a single CourseRecord by id.
	 *
	 * @param courseID the course id
	 * @return the course record
	 */
	public CourseRecord findById(String courseID)
	{
		return courseTable.get(courseID);
	}
	
	/**
	 * Finds a single CourseRecord name.
	 *
	 * @param courseName the course name
	 * @return the course record
	 */
	public CourseRecord findByName(String courseName)
	{
		courseName.toLowerCase();
		return courseTable.values().stream().filter(t->t.getCourseName().toLowerCase().equals(courseName)).findFirst().orElse(null);
	}
}
