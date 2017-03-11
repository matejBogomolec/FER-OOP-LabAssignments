package hr.fer.oop.lab5.shell;

public class PwdCommand extends AbstractCommand
{

	public PwdCommand() {
		super("PWD", "Displays absolute adress of the current directory.");
	}

	@Override
	public CommandStatus execute(Environment env, String command)
	{
		String pom = env.getCurrentPath().toAbsolutePath().toString();
		env.writeln(pom);
		return CommandStatus.CONTINUE;
	}

}
