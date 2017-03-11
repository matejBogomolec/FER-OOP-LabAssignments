package hr.fer.oop.lab6.zad3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hr.fer.oop.lab6.zad1.CourseRecord;
import hr.fer.oop.lab6.zad1.Database;
import hr.fer.oop.lab6.zad1.EnrolmentRecord;
import hr.fer.oop.lab6.zad1.StudentRecord;

// TODO: Auto-generated Javadoc
/**
 * The Class SubjectsPanel.
 */
@SuppressWarnings("serial")
public class SubjectsPanel extends JPanel
{
	
	/** The combo course. */
	private final JComboBox<String> comboCourse;
	
	/** The course array. */
	private String[] courseArray;
	
	/** The buttons. */
	private JButton[] buttons = new JButton[20];
	
	/** The center. */
	private JPanel center = new JPanel();
	
	/**
	 * Instantiates a new subjects panel.
	 *
	 * @param base the base
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public SubjectsPanel(Database base) throws IOException
	{
		setLayout(new BorderLayout());
		courseArray = base.getCourseTable().getCourseTable().values().stream().map(c -> c.getCourseName()).collect(Collectors.toList()).toArray(new String[0]);
		comboCourse = new JComboBox<String>(courseArray);
		comboCourse.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try 
				{
					setSubjectData(base);
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}

		});
		setSubjectData(base);
		add(comboCourse, BorderLayout.NORTH);
	}
	
	/**
	 * Sets the subject data.
	 *
	 * @param base the new subject data
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void setSubjectData(Database base) throws IOException 
	{
		center.removeAll();
		center.revalidate();
		center.repaint();
		CourseRecord current = null;
		for (CourseRecord course : base.getCourseTable().getCourseTable().values()) 
		{

			if (course.getCourseName().equals(
					comboCourse.getSelectedItem().toString())) 
			{
				current = course;
			}
		}
		List<String> firstAndLastNames = new ArrayList<String>();
		List<String> grades = new ArrayList<String>();
		for(EnrolmentRecord record : base.getEnrolmentTable()
				.findByCourse(current.getCourseID()))
		{
			StudentRecord student;
			student = base.getStudentTable().findByJMBAG(record.getStudentJMBAG());
			firstAndLastNames.add(student.getFirstName() + " " + student.getLastName());
			grades.add(String.valueOf(record.getGrade()));
		}
		
		JPanel boxPanel = createBoxPanel(firstAndLastNames,grades, base);
		add(boxPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Creates the box panel.
	 *
	 * @param firstAndLastNames the first and last names
	 * @param grades the grades
	 * @param base the base
	 * @return the j panel
	 */
	private JPanel createBoxPanel(List<String> firstAndLastNames, List<String> grades, Database base)
	{
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		int i = 0;
		Dimension boxDimensions;
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("Ime i Prezime"));
		box1.add(Box.createHorizontalGlue());
		box1.add(new JLabel("Ocjena"));
		boxDimensions = new Dimension(100, 10);
		box1.add(Box.createRigidArea(boxDimensions));
		center.add(box1);
		for (String name : firstAndLastNames)
		{
			Box box2 = Box.createHorizontalBox();
			JLabel nameLabel = new JLabel(name);
			box2.add(nameLabel);
			box2.add(Box.createHorizontalGlue());
			JLabel gradeLabel = new JLabel(grades.get(i));
			box2.add(gradeLabel);
			boxDimensions = new Dimension(5, 10);
			box2.add(Box.createRigidArea(boxDimensions));
			if (i % 2 == 0)
			{
				box2.setBackground(Color.RED);
				box2.setOpaque(true);
			}
			else
			{
				box2.setBackground(Color.BLUE);
				box2.setOpaque(true);
			}
			buttons[i] = new JButton("Detalji");
			buttons[i].addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) 
						{
							TabbedFrame.tabbedPane.setSelectedIndex(0);
							TabbedFrame.students.getComboStudent().setSelectedItem(name);
							TabbedFrame.students.setStudentData(base);
							
						}
				
					});
			box2.add(buttons[i]);
			center.add(box2);
			center.add(Box.createRigidArea(new Dimension(10, 10)));
			i++;
		}
		return center;
	}
}
