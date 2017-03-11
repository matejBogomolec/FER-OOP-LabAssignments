package hr.fer.oop.lab5.shell;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CdpCommand extends AbstractCommand{

	public CdpCommand() 
	{
		super("CDP", "Puts current directory into directory stack and sets given directory as current.");
	}

	@Override
	public CommandStatus execute(Environment env, String command) 
	{
		Path dir = env.resolvePath(command);
		Stack<Path> stack = env.getDirStack();
		if(dir.equals(env.getCurrentPath()))
		{
			env.writeln("Given path does not exist!");
			return CommandStatus.CONTINUE;
		}
		else
		{
			stack.push(env.getCurrentPath());
			env.setCurrentPath(dir);
			env.setDirStack(stack);
			return CommandStatus.CONTINUE;
		}
		
	}

}
