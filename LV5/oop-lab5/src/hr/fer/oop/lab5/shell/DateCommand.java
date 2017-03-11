package hr.fer.oop.lab5.shell;
import java.time.LocalDate;
import java.time.LocalTime;
public class DateCommand extends AbstractCommand
{

	public DateCommand() 
	{
		super("DATE", "Displays the current date.");
	}

	@Override
	public CommandStatus execute(Environment env, String command) 
	{
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		env.writeln(date.toString()+" "+time.toString());
		return CommandStatus.CONTINUE;
	}

}
