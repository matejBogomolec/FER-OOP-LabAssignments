package hr.fer.oop.lab5.shell;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FilterCommand extends AbstractCommand
{
	public FilterCommand() 
	{
		super("FILTER", "Filter all files in currend and all sub-directories for a given pattern");
	}	
	@Override
	public CommandStatus execute(Environment env, String command) 
	{
		FileVisitor<Path> v = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String regex = "(?i)" + command.replace("*", "(.*)");

                if (file.getFileName().toString().matches(regex)) {
                    env.writeln(file.toFile().getAbsolutePath());
                }

                return FileVisitResult.CONTINUE;
            }
        };
        try 
        {
			Files.walkFileTree(env.getCurrentPath(), v);
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
		return CommandStatus.CONTINUE;
	}
	


}
