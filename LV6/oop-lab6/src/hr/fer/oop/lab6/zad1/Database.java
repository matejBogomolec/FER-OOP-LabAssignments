/**
 * @author Matej Bogomolec
 */
package hr.fer.oop.lab6.zad1;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Database contains StudentTable, CourseTable and EnrolmentTable.
 */
public class Database 
{
	
	/** The enrolment path. */
	private Path studentPath, coursePath, enrolmentPath;
	
	/** The current path. */
	private Path currentPath;
	
	/** The student table. */
	private StudentTable studentTable = new StudentTable();
	
	/** The course table. */
	private CourseTable courseTable = new CourseTable();
	
	/** The enrolment table. */
	private EnrolmentTable enrolmentTable = new EnrolmentTable();
	
	/**
	 * Instantiates a new database.
	 *
	 * @param file1 the file1
	 * @param file2 the file2
	 * @param file3 the file3
	 */
	public Database (String file1, String file2, String file3)
	{
		this.currentPath = Paths.get(".").normalize().toAbsolutePath();
		this.studentPath = currentPath.resolve(file1);
		this.coursePath = currentPath.resolve(file2);
		this.enrolmentPath = currentPath.resolve(file3);
		Map<String, StudentRecord> students = studentTable.getStudentTable();
		List<String> lines;
		try {
			lines = Files.readAllLines(studentPath, StandardCharsets.UTF_8);
			for(String s : lines)
			{
				String[] data = s.split("\t");
				students.put(data[0], 
						new StudentRecord(data[0], data[2], 
								data[1], Integer.parseInt(data[3])));
			}
			studentTable.setStudentTable(students);
			Map<String, CourseRecord> courses = courseTable.getCourseTable();
			lines = Files.readAllLines(coursePath, StandardCharsets.UTF_8);
			for(String s : lines)
			{
				String[] data = s.split("\t");
				courses.put(data[0], 
						new CourseRecord(data[0], data[1]));
			}
			courseTable.setCourseTable(courses);
			Collection<EnrolmentRecord> enrolments = enrolmentTable.getEnrolmentTable();
			lines = Files.readAllLines(enrolmentPath, StandardCharsets.UTF_8);
			for(String s : lines)
			{
				String[] data = s.split("\t");
				enrolments.add(new EnrolmentRecord(data[0], data[1], 
								Integer.parseInt(data[2])));
			}
			enrolmentTable.setEnrolmentTable(enrolments);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Gets the student table.
	 *
	 * @return the student table
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public StudentTable getStudentTable() throws IOException
	{
		return studentTable;
	}
	
	/**
	 * Gets the course table.
	 *
	 * @return the course table
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public CourseTable getCourseTable() throws IOException 
	{
		return courseTable;
	}
	
	/**
	 * Gets the enrolment table.
	 *
	 * @return the enrolment table
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public EnrolmentTable getEnrolmentTable() throws IOException
	{
		return enrolmentTable;
	}
}
