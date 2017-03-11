package hr.fer.oop.lab6.zad3;
/*
 * U treæem zadatku dodati karticu s nazivom "Svi predmeti" u kojoj æe biti navedeni svi predmeti iz CourseTable. Za svaki predmet treba biti navedeno ime predeta te broj studenata koji su upisali taj predmet.
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hr.fer.oop.lab6.zad1.CourseRecord;
import hr.fer.oop.lab6.zad1.Database;

@SuppressWarnings("serial")
public class SubjectListPanel extends JPanel
{
	private String[] courseArray;
	private int[] studentsNumber;
	private JPanel center = new JPanel();
	public SubjectListPanel(Database base) throws IOException
	{
		setLayout(new BorderLayout());
		courseArray = base.getCourseTable().getCourseTable().values().stream().map(c -> c.getCourseName()).collect(Collectors.toList()).toArray(new String[0]);
		studentsNumber = new int[courseArray.length];
		setSubjectData(base);
		add(center, BorderLayout.NORTH);
	}
	
	private void setSubjectData(Database base) throws IOException 
	{
		int i = 0;
		
		for(CourseRecord current : base.getCourseTable().getCourseTable().values())
		{
			studentsNumber[i] =(int) base.getEnrolmentTable().getEnrolmentTable().stream().filter(r -> r.getCourseID().equals(current.getCourseID())).mapToInt(r->r.getGrade()).count();
			i++;
		}
		JPanel boxPanel = createBoxPanel(studentsNumber, courseArray, base);
		add(boxPanel, BorderLayout.NORTH);
		
	}

	private JPanel createBoxPanel(int[] studentsNumber, String[] courseArray, Database base) 
	{
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		Dimension boxDimensions;
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("Predmet"));
		box1.add(Box.createHorizontalGlue());
		box1.add(new JLabel("Broj studenata"));
		boxDimensions = new Dimension(100, 10);
		box1.add(Box.createRigidArea(boxDimensions));
		center.add(box1);
		for (int i = 0; i < studentsNumber.length; i++)
		{
			Box box = Box.createHorizontalBox();
			JLabel courseLabel = new JLabel(courseArray[i]);
			box.add(courseLabel);
			box.add(Box.createHorizontalGlue());
			JLabel numberLabel = new JLabel(String.valueOf(studentsNumber[i]));
			box.add(numberLabel);
			boxDimensions = new Dimension(5, 10);
			box.add(Box.createRigidArea(boxDimensions));
			center.add(box);
			center.add(Box.createRigidArea(new Dimension(10,10)));
		}
		return center;
	}
	
}
