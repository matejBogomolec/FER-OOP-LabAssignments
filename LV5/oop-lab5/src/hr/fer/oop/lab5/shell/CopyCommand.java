package hr.fer.oop.lab5.shell;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyCommand extends AbstractCommand {

	public CopyCommand() {
		super("COPY", "Copies a file into a given path.");
	}

	@Override
	public CommandStatus execute(Environment env, String command)
	{
		String [] pom = command.split(" ", 2);
		if (pom.length < 2)
		{
			env.writeln("Invalid arguments!");
			return CommandStatus.CONTINUE;
		}
		else
		{
			return CommandStatus.CONTINUE;
		}
		
	}

}
