package hr.fer.oop.lab5.exams;

public abstract class AbstractExamCommand implements ExamCommand
{
	private String name;
	AbstractExamCommand(String name)
	{
		this.name = name;
	}
	@Override
	public String getCommandName() 
	{
		return name;
	}
	
}
