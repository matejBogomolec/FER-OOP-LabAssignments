package hr.fer.oop.lab5.shell;


import java.nio.file.Path;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


// TODO: Auto-generated Javadoc
/**
 * The Interface Environment.
 *
 * @author Matej Bogomolec
 * The Interface Environment. This interface lists all methods used by Environment object.
 */
public interface Environment 
{
	
	/**
	 * Read line from the given input.
	 *
	 * @return the string read from the given input.
	 */
	public String readLine();
	
	/**
	 * Writes a line of string to the given output.
	 *
	 * @param string the string which will be streamed to the given output.
	 */
	public void write(String string);
	
	/**
	 * Writes a line of string terminated by a \n terminator to the given output.
	 *
	 * @param string the string which will be streamed to the given output.
	 */
	public void writeln(String string);
	
	/**
	 * Commands give an iterable object used in a for each loop.
	 *
	 * @return the iterable object
	 */
	public Iterable<ShellCommand> commands();
	
	/**
	 * Gets the current path.
	 *
	 * @return the current path
	 */
	public Path getCurrentPath();
	
	/**
	 * Sets the current path.
	 *
	 * @param path the new current path
	 */
	public void setCurrentPath(Path path);
	
	/**
	 * Find command.
	 *
	 * @param cmd - command which needs to be found
	 * @return the shell command
	 */
	public ShellCommand findCommand(String cmd);
	
	/**
	 * Resolve path.
	 *
	 * @param path - the path which needs to be resolved
	 * @return the absolute path 
	 */
	public Path resolvePath(String path);
	
	/**
	 * Gets the directory stack.
	 *
	 * @return the directory stack
	 */
	public Stack<Path> getDirStack();
	
	/**
	 * Sets the directory stack.
	 *
	 * @param dirStack the new directory stack
	 */
	public void setDirStack(Stack<Path> dirStack);
}
