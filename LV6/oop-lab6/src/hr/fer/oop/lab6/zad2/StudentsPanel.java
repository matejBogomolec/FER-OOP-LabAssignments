package hr.fer.oop.lab6.zad2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import hr.fer.oop.lab6.zad1.CourseRecord;
import hr.fer.oop.lab6.zad1.Database;
import hr.fer.oop.lab6.zad1.EnrolmentRecord;
import hr.fer.oop.lab6.zad1.StudentRecord;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentsPanel.
 */
@SuppressWarnings("serial")
public class StudentsPanel extends JPanel
{
	
	/** The students array. */
	private String[] studentsArray;
	
	/** The tf student jmbag. */
	private JTextField tfStudentJMBAG;
	
	/** The tf student last name. */
	private JTextField tfStudentLastName;
	
	/** The tf student first name. */
	private JTextField tfStudentFirstName;
	
	/** The combo student. */
	private JComboBox<String> comboStudent;
	
	/** The student courses. */
	private JPanel studentCourses = new JPanel();
	
	/**
	 * Gets the combo student.
	 *
	 * @return the combo student
	 */
	public JComboBox<String> getComboStudent()
	{
		return this.comboStudent;
	}
	
	/**
	 * Instantiates a new students panel.
	 *
	 * @param base the base
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public StudentsPanel(Database base) throws IOException
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		studentsArray = base.getStudentTable().getStudentTable().values().stream().map(s -> s.getFirstName() + " " + s.getLastName()).collect(Collectors.toList()).toArray(new String[0]);
		comboStudent = new JComboBox<String>(studentsArray);
		comboStudent.addActionListener(new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						String jmbag = setStudentData(base);
						try {
							setCoursesData(base, jmbag);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		StudentRecord currentStudent = selectStudent(comboStudent, base);
		JPanel studentDataPanel =  new JPanel(new GridLayout(3, 2));
		studentDataPanel.add(new JLabel("JMBAG:", SwingConstants.RIGHT));
		tfStudentJMBAG = new JTextField();
		tfStudentJMBAG.setText(currentStudent.getJmbag());
		studentDataPanel.add(tfStudentJMBAG);
		
		studentDataPanel.add(new JLabel("Ime:", SwingConstants.RIGHT));
		tfStudentFirstName = new JTextField();
		tfStudentFirstName.setText(currentStudent.getFirstName());
		studentDataPanel.add(tfStudentFirstName);
		
		studentDataPanel.add(new JLabel("Prezime:", SwingConstants.RIGHT));
		tfStudentLastName = new JTextField();
		tfStudentLastName.setText(currentStudent.getLastName());
		studentDataPanel.add(tfStudentLastName);
		setCoursesData(base, currentStudent.getJmbag());
		
		add(comboStudent, BorderLayout.NORTH);
		panel.add(studentDataPanel, BorderLayout.NORTH);
		panel.add(studentCourses, BorderLayout.CENTER);
		add(panel, BorderLayout.CENTER);
		
	}
	
	/**
	 * Select student.
	 *
	 * @param comboStudent the combo student
	 * @param base the base
	 * @return the student record
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private StudentRecord selectStudent(JComboBox<String> comboStudent, Database base) throws IOException 
	{
		String[] data = comboStudent.getSelectedItem().toString().split(" ", 2);
		return base.getStudentTable().getStudentTable().values().stream().filter(s-> s.getFirstName().equals(data[0]) && s.getLastName().equals(data[1])).findFirst().orElse(null);
	}

	/**
	 * Sets the student data.
	 *
	 * @param base the base
	 * @return the string
	 */
	public String setStudentData(Database base)
	{
		String[] studentName = comboStudent.getSelectedItem().toString().split(" ", 2);
		String firstName = studentName[0];
		String lastName = studentName[1];
		StudentRecord student;
		try {
			student = base.getStudentTable().getStudentTable().values().stream().
					filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)).findFirst().orElse(null);
			tfStudentFirstName.setText(student.getFirstName());
			tfStudentLastName.setText(student.getLastName());
			tfStudentJMBAG.setText(student.getJmbag());
			return student.getJmbag();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * Sets the courses data.
	 *
	 * @param base the base
	 * @param jmbag the jmbag
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void setCoursesData(Database base, String jmbag) throws IOException
	{
		studentCourses.removeAll();
		studentCourses.revalidate();
		studentCourses.setLayout(new BoxLayout(studentCourses,BoxLayout.Y_AXIS));
		Map<String, CourseRecord> allCourses = base.getCourseTable().getCourseTable();
		TitledBorder title = new TitledBorder("Upisani predmeti");
		studentCourses.setBorder(title);
		Collection<EnrolmentRecord> studentEnrolment = base.getEnrolmentTable().findByStudent(jmbag);
		for (EnrolmentRecord record : studentEnrolment)
		{
			JButton courseButton = new JButton (allCourses.get(record.getCourseID()).getCourseName());
			courseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			courseButton.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e)
						{
							JFrame courseFrame = new JFrame();
							JOptionPane.showMessageDialog(courseFrame, "Student's grade on this subject: "
									+ record.getGrade(), "Student's grade", JOptionPane.INFORMATION_MESSAGE);
						}
					});
			studentCourses.add(courseButton);
			studentCourses.add(Box.createRigidArea(new Dimension(10,10)));
		}
		
	}
	
}

