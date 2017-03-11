package hr.fer.oop.lab5.exams;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;


/**@author Matej Bogomolec
 * The Interface ExamEnvironment. This interface lists all methods used by ExamEnvironment objects.
 */
public interface ExamEnvironment 
{
	
	/**
	 * Read line.
	 *
	 * @return the string read by the given input.
	 */
	public String readLine();
	
	/**
	 * Read a line of string from the given input
	 *
	 * @param string the string
	 */
	public void write(String string);
	
	/**
	 * Commands gives an iterable object used in for each loop.
	 *
	 * @return the iterable object
	 */
	public Iterable<ExamCommand> commands();
	
	/**
	 * Find command.
	 *
	 * @param cmd the command which needs to be found 
	 * @return the exam command
	 */
	public ExamCommand findCommand(String cmd);
	
	/**
	 * Gets the full list.
	 *
	 * @return the full list
	 */
	public List<SheetData> getFullList();
	
	/**
	 * Sets the full list.
	 *
	 * @param fullList the new full list
	 */
	public void setFullList(List<SheetData> fullList);
	
	/**
	 * Gets the active list.
	 *
	 * @return the active list
	 */
	public List<SheetData> getActiveList();
	
	/**
	 * Sets the active list.
	 *
	 * @param activeList the new active list
	 */
	public void setActiveList(List<SheetData> activeList);
	
	/**
	 * Gets the exam answers.
	 *
	 * @return the exam answers
	 */
	public Map<String, String[]> getExamAnswers();
	
	/**
	 * Sets the exam answers.
	 *
	 * @param examAnswers the exam answers
	 */
	public void setExamAnswers(Map<String, String[]> examAnswers);
	
	/**
	 * Gets the answer points.
	 *
	 * @return the answer points
	 */
	public double[] getAnswerPoints();
	
	/**
	 * Sets the answer points.
	 *
	 * @param answerPoints the new answer points
	 */
	public void setAnswerPoints(double[] answerPoints);
	
	/**
	 * Gets the average points.
	 *
	 * @return the average points
	 */
	public double getAverage();
	
	/**
	 * Sets the average points.
	 *
	 * @param d the new average points
	 */
	public void setAverage(double d);

}
