package hr.fer.oop.lab5.exams;


public class AnswerScore 
{
	private double score;
	private AnswerStatus status;
	public AnswerScore()
	{
		this.score = 0;
		this.status = AnswerStatus.UNANSWERED;
	}
	public AnswerScore(double score, AnswerStatus status)
	{
		this.score = score;
		this.status = status;
	}
	
	public double getScore()
	{
		return this.score;
	}
	
	public void setScore (double score)
	{
		this.score = score;
	}
	
	public AnswerStatus getStatus()
	{
		return this.status;
	}
	
	public void setStatus(AnswerStatus status)
	{
		this.status = status;
	}
	
}
