/**
 * @author Matej Bogomolec
 */
package hr.fer.oop.lab6.zad1;


/**
 * The Class EnrolmentRecord holds and changes information of a single enrloment.
 */
public class EnrolmentRecord 
{
	
	/** The course id. */
	private String courseID;
	
	/** The student jmbag. */
	private String studentJMBAG;
	
	/** The grade. */
	private int grade;
	
	/**
	 * Instantiates a new enrolment record.
	 *
	 * @param courseID the course id
	 * @param studentJMBAG the student jmbag
	 * @param grade the grade
	 */
	public EnrolmentRecord (String courseID, String studentJMBAG, int grade)
	{
		this.courseID = courseID;
		this.studentJMBAG = studentJMBAG;
		this.grade = grade;
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
	 * Sets the course id.
	 *
	 * @param courseID the new course id
	 */
	public void setCourseID(String courseID) 
	{
		this.courseID = courseID;
	}
	
	/**
	 * Gets the student jmbag.
	 *
	 * @return the student jmbag
	 */
	public String getStudentJMBAG() 
	{
		return studentJMBAG;
	}
	
	/**
	 * Sets the student jmbag.
	 *
	 * @param studentJMBAG the new student jmbag
	 */
	public void setStudentJMBAG(String studentJMBAG) 
	{
		this.studentJMBAG = studentJMBAG;
	}
	
	/**
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public int getGrade() 
	{
		return grade;
	}
	
	/**
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade(int grade) 
	{
		this.grade = grade;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseID == null) ? 0 : courseID.hashCode());
		result = prime * result + ((studentJMBAG == null) ? 0 : studentJMBAG.hashCode());
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
		EnrolmentRecord other = (EnrolmentRecord) obj;
		if (courseID == null) {
			if (other.courseID != null)
				return false;
		} else if (!courseID.equals(other.courseID) && !studentJMBAG.equals(other.studentJMBAG))
			return false;
		if (studentJMBAG == null) {
			if (other.studentJMBAG != null)
				return false;
		} else if (!studentJMBAG.equals(other.studentJMBAG) && !courseID.equals(other.courseID))
			return false;
		return true;
	}
	
	
}
