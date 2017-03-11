package hr.fer.oop.lab5.shell;

public class HelpCommand extends AbstractCommand
{

	public HelpCommand() {
		super("HELP", "Displays names and descriptions of all implemented commands.");

	}

	@Override
	public CommandStatus execute(Environment env, String command) 
	{
		Iterable<ShellCommand> iterator = env.commands();
		for (ShellCommand  c : iterator)
		{
			env.writeln(c.getCommandName()+"-"+c.getCommandDescription());
		}
		return CommandStatus.CONTINUE;
	}

}
