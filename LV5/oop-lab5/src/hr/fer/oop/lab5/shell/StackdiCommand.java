package hr.fer.oop.lab5.shell;

import java.nio.file.Path;

public class StackdiCommand extends AbstractCommand{

	public StackdiCommand() {
		super("STACKDI", "Prints all directories from the directory stack.");
	}

	@Override
	public CommandStatus execute(Environment env, String command) {
		for(Path path : env.getDirStack())
			{	
				if (path.getFileName() == null) env.writeln(path.toString());
				else env.writeln(path.toFile().getName());
			}
		return CommandStatus.CONTINUE;
	}

}
