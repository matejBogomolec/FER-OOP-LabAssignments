package hr.fer.oop.lab5.shell;

public abstract class AbstractCommand implements ShellCommand
{
	private final String commandName;
	private final String commandDescription;
	public AbstractCommand (String commandName, String commandDescription)
	{
		this.commandName = commandName;
		this.commandDescription = commandDescription;
	}
	@Override
	public String getCommandName()
	{
		return commandName;
	}
	@Override
	public String getCommandDescription()
	{
		return commandDescription;
	}
}
