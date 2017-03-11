package hr.fer.oop.lab5.shell;

import java.nio.file.Path;

public class CdCommand extends AbstractCommand
{

	public CdCommand() 
	{
		super("CD", "Display or change current directory.");
	}

	@Override
	public CommandStatus execute(Environment env, String command) 
	{
		Path pom;
		command = command.replace("\"", "");
		pom = env.resolvePath(command);
		if (!pom.equals(env.getCurrentPath()))
		{
			env.setCurrentPath(pom);
			env.write("Current directory is now set to:");
			env.writeln(env.getCurrentPath().toAbsolutePath().toString());
		}
		else env.writeln("Invalid directory!");
		return CommandStatus.CONTINUE;
	}

}
