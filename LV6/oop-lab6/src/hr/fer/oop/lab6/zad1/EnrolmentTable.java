/**
 * @author Matej Bogomolec
 */
package hr.fer.oop.lab6.zad1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

// TODO: Auto-generated Javadoc
/**
 * The Class EnrolmentTable contains a collection of every enrollment. 
 */
public class EnrolmentTable
{
	
	/** The enrolment table. */
	private Collection<EnrolmentRecord> enrolmentTable;
	
	/**
	 * Instantiates a new enrolment table.
	 *
	 * @param enrolmentTable the enrolment table
	 */
	public EnrolmentTable(Collection<EnrolmentRecord> enrolmentTable) 
	{
		this.enrolmentTable = enrolmentTable;
	}

	/**
	 * Instantiates a new enrolment table.
	 */
	public EnrolmentTable() 
	{
		this.enrolmentTable = new LinkedList<EnrolmentRecord>();
	}

	/**
	 * Gets the enrolment table.
	 *
	 * @return the enrolment table
	 */
	public Collection<EnrolmentRecord> getEnrolmentTable() 
	{
		return enrolmentTable;
	}

	/**
	 * Sets the enrolment table.
	 *
	 * @param enrolmentTable the new enrolment table
	 */
	public void setEnrolmentTable(Collection<EnrolmentRecord> enrolmentTable) 
	{
		this.enrolmentTable = enrolmentTable;
	}
	
	/**
	 * Finds an EnrolmentRecord by students JMBAG.
	 *
	 * @param studentJMBAG the student jmbag
	 * @return the collection
	 */
	public Collection<EnrolmentRecord> findByStudent(String studentJMBAG)
	{
		EnrolmentRecord pom = new EnrolmentRecord(null, studentJMBAG, 0);
		return enrolmentTable.stream().filter(t ->t.equals(pom)).collect(Collectors.toList());
	}
	
	/**
	 * Finds an EnrolmentRecord by course id.
	 *
	 * @param courseID the course id
	 * @return the collection
	 */
	public Collection<EnrolmentRecord> findByCourse(String courseID) 
	{
		EnrolmentRecord pom = new EnrolmentRecord(courseID, null, 0);
		return enrolmentTable.stream().filter(t ->t.equals(pom)).collect(Collectors.toList());
	}
	
	/**
	 * Finds an EnrolmentRecord by student JMBAG and course ID.
	 *
	 * @param studentJMBAG the student jmbag
	 * @param courseID the course id
	 * @return the enrolment record
	 */
	public EnrolmentRecord findByStudentAndCourse(String studentJMBAG,
	String courseID)
	{
		return enrolmentTable.stream().filter(t ->t.equals(courseID) && t.equals(studentJMBAG)).findFirst().orElse(null);
	}
	
	/**
	 * Creates a new EnrolmentRecord.
	 *
	 * @param studentJMBAG the student jmbag
	 * @param courseID the course id
	 * @return the enrolment record
	 */
	public EnrolmentRecord newCourse(String studentJMBAG,String courseID)
	{
		return new EnrolmentRecord(studentJMBAG, courseID, 0);// default grade is 0 – not passed
	}
	
	/**
	 * Update enrolment table.
	 *
	 * @param record the record used for updatitng.
	 */
	public void updateEnrolment(EnrolmentRecord record)
	{
		enrolmentTable.add(record);
	}
	
	/**
	 * Deletes a record using the students JMBAG and course ID.
	 *
	 * @param studentJMBAG the student jmbag
	 * @param courseID the course id
	 */
	public void deleteRecord(String studentJMBAG, String courseID)
	{
		enrolmentTable.remove(enrolmentTable.stream().filter(t-> t.equals(studentJMBAG) && t.equals(courseID)).findFirst());
	}
}
