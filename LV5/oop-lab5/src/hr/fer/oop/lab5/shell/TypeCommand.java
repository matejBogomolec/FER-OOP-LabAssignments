package hr.fer.oop.lab5.shell;

import java.io.File;
import java.io.FilenameFilter;


public class TypeCommand extends AbstractCommand
{

	public TypeCommand() 
	{
		super("TYPE", "Display all content of a given file");
	}

	@Override
	public CommandStatus execute(Environment env, String command) 
	{
		File start = env.resolvePath(command).toFile();
		FilenameFilter filter = (dir, name) -> new File(dir,name).isDirectory() || new File(dir,name).isFile();
		File[] files = start.listFiles(filter);
		for (File file : files) env.writeln(file.getName().toString());
		return CommandStatus.CONTINUE;
	}

}
