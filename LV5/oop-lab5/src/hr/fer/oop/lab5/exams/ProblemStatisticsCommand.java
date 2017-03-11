package hr.fer.oop.lab5.exams;

import hr.fer.oop.lab5.shell.CommandStatus;

public class ProblemStatisticsCommand extends AbstractExamCommand 
{
	ProblemStatisticsCommand() 
	{
		super("PROBLEMSTATISTICS");
	}

	
	@Override
	public CommandStatus execute(ExamEnvironment env, String[] arg) 
	{
		return null;
	}

}