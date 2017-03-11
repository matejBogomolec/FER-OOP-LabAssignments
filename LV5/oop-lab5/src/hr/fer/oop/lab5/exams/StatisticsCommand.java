package hr.fer.oop.lab5.exams;

import hr.fer.oop.lab5.shell.CommandStatus;

public class StatisticsCommand extends AbstractExamCommand 
{
	StatisticsCommand() 
	{
		super("STATISTICS");
	}

	
	@Override
	public CommandStatus execute(ExamEnvironment env, String[] arg) 
	{
		env.write(env.getActiveList().stream().mapToDouble(t -> t.getTotalScore().getAsDouble()).average().toString());
		return CommandStatus.CONTINUE;
	}

}