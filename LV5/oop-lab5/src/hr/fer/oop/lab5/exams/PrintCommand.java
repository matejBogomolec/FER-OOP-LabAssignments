package hr.fer.oop.lab5.exams;

import hr.fer.oop.lab5.shell.CommandStatus;

public class PrintCommand extends AbstractExamCommand 
{
	PrintCommand() 
	{
		super("PRINT");
	}

	
	@Override
	public CommandStatus execute(ExamEnvironment env, String[] arg) 
	{
		Integer size = env.getActiveList().size();
		env.write(size.toString());
		env.getActiveList().forEach(t -> env.write(t.getJmbag() 
				+" "+t.getGroup()
				+" "+t.getAnswers().toString()
				+" "+t.getTotalScore().getAsDouble()));
		return CommandStatus.CONTINUE;
	}

}