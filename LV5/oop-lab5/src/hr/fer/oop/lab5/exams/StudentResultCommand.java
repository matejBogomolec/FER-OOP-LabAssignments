package hr.fer.oop.lab5.exams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import hr.fer.oop.lab5.shell.CommandStatus;

public class StudentResultCommand extends AbstractExamCommand 
{
	StudentResultCommand() 
	{
		super("STUDENTSRESULT");
	}

	
	@Override
	public CommandStatus execute(ExamEnvironment env, String[] arg) 
	{
		return CommandStatus.CONTINUE;
	}

}

