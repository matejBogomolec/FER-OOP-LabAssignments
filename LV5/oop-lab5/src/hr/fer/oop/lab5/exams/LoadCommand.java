package hr.fer.oop.lab5.exams;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import hr.fer.oop.lab5.shell.CommandStatus;

public class LoadCommand extends AbstractExamCommand 
{
	LoadCommand() 
	{
		super("LOAD");
	}

	
	@Override
	public CommandStatus execute(ExamEnvironment env, String[] arg) 
	{
		if (arg.length != 6)
		{
			env.write("Illegal number of arguments");
			return CommandStatus.CONTINUE;
		}
		Path src1 = Paths.get(arg[1]).normalize().toAbsolutePath();
		Path src2 = Paths.get(arg[2]).normalize().toAbsolutePath();
		double points[] =
			{
					Double.parseDouble(arg[3]),
					Double.parseDouble(arg[4]),
					Double.parseDouble(arg[5])
			};
		try 
		{
			env.setFullList(SheetDataLoader.loadSheets(src1));
			env.setActiveList(SheetDataLoader.loadSheets(src1));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try 
		{
			env.setExamAnswers(SheetDataLoader.loadCorrectAnswers(src2));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
			env.setAnswerPoints(points);
		for (SheetData student : env.getFullList())
		{
			OptionalDouble  exam_points = OptionalDouble.empty();
			List<AnswerScore> scores = new ArrayList<AnswerScore>();
			if (env.getExamAnswers().containsKey(student.getGroup()))
			{
				int pointer = 0;
				for(String answer : student.getAnswers())
				{
					AnswerScore pom;
					if(answer.equals(env.getExamAnswers().get(student.getGroup())[pointer]))
					{
						pom = new AnswerScore(env.getAnswerPoints()[0], AnswerStatus.ANSWERED_CORRECT);
					}
					else if (answer.equals("BLANK"))
					{
						pom = new AnswerScore(env.getAnswerPoints()[1], AnswerStatus.UNANSWERED);
					}
					else pom = new AnswerScore(env.getAnswerPoints()[2], AnswerStatus.ANSWERED_FALSE);
					scores.add(pom);
					pointer ++;
				}
				exam_points = OptionalDouble.of(scores.stream().mapToDouble(t -> t.getScore()).sum());
				student.setTotalScore(exam_points);
				student.setAnswerScores(scores);
			}
			else
			{
				env.write("Student " + student.getJmbag()+ " je unio krivu grupu:"+ student.getGroup());
			}
		
			
		}
		env.setActiveList(env.getFullList().stream().filter(t -> t.getTotalScore().isPresent()).collect(Collectors.toList()));
		env.setAverage(env.getActiveList().stream().mapToDouble(t -> t.getTotalScore().getAsDouble()).average().getAsDouble());
		return CommandStatus.CONTINUE;
	}

}
