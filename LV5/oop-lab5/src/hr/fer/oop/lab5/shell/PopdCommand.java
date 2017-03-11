package hr.fer.oop.lab5.shell;

import java.nio.file.Path;
import java.util.Stack;

public class PopdCommand extends AbstractCommand
{

	public PopdCommand() 
	{
		super("POPD", "Removes the top directory from the directory stack and sets it as a current directory");
	}

	@Override
	public CommandStatus execute(Environment env, String command)	
	{
		if (env.getDirStack().isEmpty())
		{
			env.writeln("Directory stack is empty!");
			return CommandStatus.CONTINUE;
		}
		Stack<Path> stack = env.getDirStack();
		env.setCurrentPath(stack.pop());
		env.setDirStack(stack);
		return CommandStatus.CONTINUE;
	}

}
