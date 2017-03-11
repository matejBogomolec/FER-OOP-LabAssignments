/**
 * @author Matej Bogomolec
 */
package hr.fer.oop.lab6.zad1;

import java.util.HashMap;
import java.util.Map;


/**
 * The Class StudentTable contains a map of all students. The map uses the students JMBAG as a key, and StudentRecord objects as values.
 */
public class StudentTable
{
	
	/** The student table. */
	private Map<String, StudentRecord> studentTable;
	
	/**
	 * Instantiates a new empty student table.
	 */
	public StudentTable()
	{
		this.studentTable = new HashMap<String, StudentRecord>();
	}
	
	/**
	 * Instantiates a new student table using an existing table.
	 *
	 * @param studentTable the student table
	 */
	public StudentTable(Map<String, StudentRecord> studentTable)
	{
		this.setStudentTable(studentTable);
	}
	
	/**
	 * Gets the student table.
	 *
	 * @return the student table
	 */
	public Map<String, StudentRecord> getStudentTable() {
		return studentTable;
	}
	
	/**
	 * Sets the student table.
	 *
	 * @param studentTable the student table
	 */
	public void setStudentTable(Map<String, StudentRecord> studentTable) {
		this.studentTable = studentTable;
	}
	
	/**
	 * Finds  StudentRecord by a students jmbag.
	 *
	 * @param jmbag the jmbag
	 * @return the student record
	 */
	public StudentRecord findByJMBAG (String jmbag)
	{
		return studentTable.get(jmbag);
	}
	
}
