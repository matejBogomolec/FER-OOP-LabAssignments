package hr.fer.oop.lab5.exams;

import java.util.stream.Collectors;

import hr.fer.oop.lab5.shell.CommandStatus;

public class ResetCommand extends AbstractExamCommand 
{
	ResetCommand() 
	{
		super("RESET");
	}

	
	@Override
	public CommandStatus execute(ExamEnvironment env, String[] arg) 
	{
		env.setActiveList(env.getFullList().stream().filter(t -> t.getTotalScore().isPresent()).collect(Collectors.toList()));
		return CommandStatus.CONTINUE;
	}

}