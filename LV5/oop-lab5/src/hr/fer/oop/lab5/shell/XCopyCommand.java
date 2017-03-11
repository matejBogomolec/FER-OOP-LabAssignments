package hr.fer.oop.lab5.shell;

public class XCopyCommand extends AbstractCommand{

	public XCopyCommand() {
		super("XCOPY", "Copies and entire directory");
		// TODO Auto-generated constructor stub
	}

	@Override
	public CommandStatus execute(Environment env, String command) {
		// TODO Auto-generated method stub
		return CommandStatus.CONTINUE;
	}

}
