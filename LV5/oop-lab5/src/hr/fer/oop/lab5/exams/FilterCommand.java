package hr.fer.oop.lab5.exams;

import java.util.stream.Collectors;

import hr.fer.oop.lab5.shell.CommandStatus;

public class FilterCommand extends AbstractExamCommand 
{
	FilterCommand() 
	{
		super("FILTER");
	}
	@Override
	public CommandStatus execute(ExamEnvironment env, String[] arg) 
	{
		if (arg.length != 2)
		{
			env.write("Illegal number of arguments");
			return CommandStatus.CONTINUE;
		}
		switch (arg[1])
		{
			case "graded" :
			{
				env.setActiveList(env.getActiveList().stream().filter(s -> s.getTotalScore().isPresent()).collect(Collectors.toList()));
				break;
			}
			case "!graded" :
			{
				env.setActiveList(env.getActiveList().stream().filter(s -> !s.getTotalScore().isPresent()).collect(Collectors.toList()));
				break;
			}
			case "group=" :
			{
				String[]data = arg[1].split("=");
				String group = data[1];
				env.setActiveList(env.getActiveList().stream().filter(s -> s.getGroup().equals(group)).collect(Collectors.toList()));
				break;
			}
			default :
			{
				env.write("Wrong filter!");
				break;
			}
		}
		
		
		return CommandStatus.CONTINUE;
	}

}