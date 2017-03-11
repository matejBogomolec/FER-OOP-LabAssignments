package hr.fer.oop.lab5.shell;

public class QuitCommand extends AbstractCommand
{

	public QuitCommand() 
	{
		super("QUIT", "Exits the shell.");
	}

	@Override
	public CommandStatus execute(Environment env, String command)
	{
		return CommandStatus.EXIT;
	}
}
