package hr.fer.oop.lab5.exams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamShell
{
	private static Map<String, ExamCommand> commands;
	static 
	{
		commands = new HashMap<>();
		ExamCommand[] cc = 
		{
				new LoadCommand(),
				new FilterCommand(),
				new ResetCommand(),
				new StatisticsCommand(),
				new ProblemStatisticsCommand(),
				new StudentResultCommand(),
				new PrintCommand(),
		};
		for(ExamCommand c : cc) 
		{
			commands.put(c.getCommandName(), c);
		}
	}

	public static class Exam implements ExamEnvironment
	{
		private List<SheetData> fullList;
		private List<SheetData> activeList;
		private Map<String, String[]> examAnswers;
		private double[] answerPoints = {0,0,0};
		private double average;
		private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		public Exam (List<SheetData> List, double[] points)
		{
			this.fullList = List;
			this.activeList = List;
			this.answerPoints = points;
		}
		public Exam() 
		{
			this.fullList = new ArrayList<SheetData>();
			this.activeList = this.fullList;
		}
		@Override
		public List<SheetData> getFullList() 
		{
			return fullList;
		}
		@Override
		public void setFullList(List<SheetData> fullList) 
		{
			this.fullList = fullList;
		}
		@Override
		public List<SheetData> getActiveList() 
		{
			return activeList;
		}
		@Override
		public void setActiveList(List<SheetData> activeList) 
		{
			this.activeList = activeList;
		}
		@Override
		public Map<String, String[]> getExamAnswers()
		{
			return examAnswers;
		}
		@Override
		public void setExamAnswers(Map<String, String[]> examAnswers) 
		{
			this.examAnswers = examAnswers;
		}
		@Override
		public double[] getAnswerPoints() 
		{
			return answerPoints;
		}
		@Override
		public void setAnswerPoints(double[] answerPoints) 
		{
			this.answerPoints = answerPoints;
		}
		@Override
		public double getAverage() {
			return average;
		}
		@Override
		public void setAverage(double average) {
			this.average = average;
		}
		@Override
		public String readLine() 
		{
			String line = null;
			try 
			{
			 line = reader.readLine();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			return line;
		}
		@Override
		public void write(String string) 
		{
			string += '\n';
			try {
				writer.write(string);
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public Iterable<ExamCommand> commands() 
		{
			return commands.values();
		}
		@Override
		public ExamCommand findCommand(String command) 
		{
			command=command.toUpperCase();
			Iterable<ExamCommand> iterator = commands();
			for (ExamCommand  c : iterator)
			{
				if (c.getCommandName().equals(command)) return c;
			}
			return null;
		}
		
	}
	public static ExamEnvironment environment = new Exam();
	
	public static void main(String[] args) throws IOException 
	{
		environment.write("Welcome to ExamShell! You may enter commands.");
		while(true) 
		{
			environment.write("$> ");
			String line = environment.readLine();
			String[] input = line.trim().split(" ");			
			ExamCommand cmd = environment.findCommand(input[0]);
			if (cmd == null)
			{
				environment.write("Unknown command");
				continue;
			}
			cmd.execute(environment, input);
	}
}
	//load H:/podatci.txt H:/tocni.txt 3 0 0
}

		