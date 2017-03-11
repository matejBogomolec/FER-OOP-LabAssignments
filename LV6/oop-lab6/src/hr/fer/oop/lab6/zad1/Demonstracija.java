/**
 * @author Matej Bogomolec
 */
package hr.fer.oop.lab6.zad1;

import java.io.IOException;
import java.util.Collection;

// TODO: Auto-generated Javadoc
/**
 * The Class Demonstracija runs a demonstration of a Database's data processing.
 */
public class Demonstracija {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException 
	{
		Database demos = new Database("studenti.txt", "predmeti.txt", "UpisaniPredmeti.txt");
		System.out.println("Studenti:");
		for(StudentRecord s : demos.getStudentTable().getStudentTable().values())
		{
			System.out.println(s.getJmbag()+" "+ s.getFirstName()+" " + s.getLastName()+" " + s.getFinalGrade()+".");
		}
		System.out.println("Premeti:");
		for(CourseRecord c : demos.getCourseTable().getCourseTable().values())
		{
			System.out.println(c.getCourseID()+" "+ c.getCourseName()+".");
		}
		System.out.println("Upisani predmeti:");
		for(EnrolmentRecord e : demos.getEnrolmentTable().getEnrolmentTable())
		{
			System.out.println(e.getCourseID()+" "+ e.getStudentJMBAG()+" " + e.getGrade()+".");
		}
		System.out.println("Upisani predmeti studenta 3686190420");
		Collection<EnrolmentRecord> upis = demos.getEnrolmentTable().findByStudent("6873004907");
		CourseTable predmeti = demos.getCourseTable();
		upis.forEach(s -> System.out.println(predmeti.findById(s.getCourseID()).getCourseName()));
		
		
		System.out.println("Novi predmet i upisivanje studenta na taj predmet:");
		CourseRecord ui = new CourseRecord("10", "Umjetna inteligencija");
		demos.getCourseTable().getCourseTable().put(ui.getCourseID(), ui);
		EnrolmentRecord uir = new EnrolmentRecord(ui.getCourseID(), "6873004907", 5);
		demos.getEnrolmentTable().getEnrolmentTable().add(uir);
		CourseTable predmeti1 = demos.getCourseTable();
		upis = demos.getEnrolmentTable().findByStudent("6873004907");
		upis.forEach(s -> System.out.println(predmeti1.findById(s.getCourseID()).getCourseName()));
	}

}
