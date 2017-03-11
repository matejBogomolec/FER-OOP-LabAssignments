package hr.fer.oop.lab5.shell;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
// TODO: Auto-generated Javadoc

/**
 * The Class MyShell.
 */
public class MyShell 
{
	
	/** The commands. */
	private static Map<String, ShellCommand> commands;
	static 
	{
		commands = new HashMap<>();
		ShellCommand[] cc = 
		{
				new HelpCommand(),
				new QuitCommand(),
				new CdCommand(),
				new PwdCommand(),
				new DateCommand(),
				new TypeCommand(),
				new FilterCommand(),
				new CopyCommand(),
				new XCopyCommand(),
				new CdpCommand(),
				new PopdCommand(),
				new StackdiCommand()
		};
		for(ShellCommand c : cc) 
		{
			commands.put(c.getCommandName(), c);
		}
	}
	
	/**
	 * The Class EnvironmentImpl.
	 */
	public static class EnvironmentImpl implements Environment 
	{
		
		/** The reader. */
		private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		/** The writer. */
		private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/** The current path. */
		private Path currentPath;
		
		
		private Stack<Path> dirStack = new Stack<Path>();
		/**
		 * Instantiates a new environment implementation.
		 */
		public EnvironmentImpl()
		{
			this.currentPath = Paths.get(".").normalize().toAbsolutePath();
		}
		
		/* (non-Javadoc)
		 * @see hr.fer.oop.lab5.shell.Environment#readLine()
		 */
		@Override
		public String readLine() 
		{
			String line = null;
			try {
			 line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return line;
		}

		/* (non-Javadoc)
		 * @see hr.fer.oop.lab5.shell.Environment#write(java.lang.String)
		 */
		@Override
		public void write(String string) 
		{
			try {
				writer.write(string);
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}

		/* (non-Javadoc)
		 * @see hr.fer.oop.lab5.shell.Environment#writeln(java.lang.String)
		 */
		@Override
		public void writeln(String string) 
		{
			string += '\n';
			try {
				writer.write(string);
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/* (non-Javadoc)
		 * @see hr.fer.oop.lab5.shell.Environment#commands()
		 */
		@Override
		public Iterable<ShellCommand> commands() 
		{
			return commands.values();
		}

		/* (non-Javadoc)
		 * @see hr.fer.oop.lab5.shell.Environment#getCurrentPath()
		 */
		@Override
		public Path getCurrentPath() 
		{	
			return this.currentPath;
		}

		/* (non-Javadoc)
		 * @see hr.fer.oop.lab5.shell.Environment#setCurrentPath(java.nio.file.Path)
		 */
		@Override
		public void setCurrentPath(Path path) 
		{
			this.currentPath = path;
		}
		
		/* (non-Javadoc)
		 * @see hr.fer.oop.lab5.shell.Environment#findCommand(java.lang.String)
		 */
		public ShellCommand findCommand (String command)
		{
			command=command.toUpperCase();
			Iterable<ShellCommand> iterator = commands();
			for (ShellCommand  c : iterator)
			{
			//	System.out.println(c.getCommandName()+"="+command);
				if (c.getCommandName().equals(command)) return c;
				
			}
			return null;
		}
		
		/* (non-Javadoc)
		 * @see hr.fer.oop.lab5.shell.Environment#resolvePath(java.lang.String)
		 */
		public Path resolvePath (String path)
		{
			Path pom = currentPath;
			if (path.equals(".."))
			{
				pom = currentPath.getParent();
				return pom;
			}
			else if (!path.isEmpty() && pom.resolve(path).toFile().isDirectory())
			{
				return pom.resolve(path);
			}
			else return currentPath;
			
		}

		public Stack<Path> getDirStack() {
			return dirStack;
		}

		public void setDirStack(Stack<Path> dirStack) {
			this.dirStack = dirStack;
		}
	}
	
	
	
	
	
	/** The environment. */
	public static Environment environment = new EnvironmentImpl();
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException 
	{
		environment.writeln("Welcome to MyShell! You may enter commands.");
		while(true) 
		{
			if(environment.getCurrentPath().getFileName() == null)
				environment.write("$" + environment.getCurrentPath().toString()+"> ");
			else
				environment.write("$" + environment.getCurrentPath().toFile().getName().toString()+ "> ");
			String line = environment.readLine();
			String[] input = line.trim().split(" ", 2);
			String cmd = input[0];
			String arg = null;
			if(input.length>1) arg = input[1];
//			System.out.println(cmd);
//			System.out.println(arg);
			ShellCommand shellCommand = environment.findCommand(cmd);	
			if(shellCommand==null) 
			{
				environment.writeln("Unknown command!");
				continue;
			}
			//environment.writeln(shellCommand.getCommandName());
			if(shellCommand.execute(environment, arg)==CommandStatus.EXIT) break;
		}
		environment.writeln("Thank you for using this shell. Goodbye!");
	}
}
