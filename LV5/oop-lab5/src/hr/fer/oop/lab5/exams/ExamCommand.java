
package hr.fer.oop.lab5.exams;

import hr.fer.oop.lab5.shell.CommandStatus;


/**@author Matej Bogomolec
 * The Interface ExamCommand. This interface lists all methods used by ExamCommand objects.
 */
public interface ExamCommand 
{
	
	/**
	 * Gets the command name.
	 *
	 * @return the command name
	 */
	public String getCommandName();
	
	/**
	 * Execute.
	 *
	 * @param env the environment in which this command is executed.
	 * @param input the arguments of this command
	 * @return the command status
	 */
	public CommandStatus execute(ExamEnvironment env, String[] input);
}
