package hr.fer.oop.lab5.shell;


/**
 * @author Matej Bogomolec
 * The Interface ShellCommand. This interface lists all methods used by ShellCommand objects.
 */
public interface ShellCommand 
{
	
	/**
	 * Gets the command name.
	 *
	 * @return the command name
	 */
	public String getCommandName();
	
	/**
	 * Gets the command description.
	 *
	 * @return the command description
	 */
	public String getCommandDescription();
	
	/**
	 * Execute the command with the given environment and arguments.
	 *
	 * @param env the environment in which this command will be used
	 * @param command the command arguments
	 * @return the command status
	 */
	public CommandStatus execute(Environment env, String command);
}
