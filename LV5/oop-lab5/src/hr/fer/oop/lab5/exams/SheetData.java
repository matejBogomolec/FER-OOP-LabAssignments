package hr.fer.oop.lab5.exams;

import java.util.*;

public class SheetData 
{
	private String jmbag;
	private String group;
	private List<String> answers;
	private OptionalDouble totalScore = OptionalDouble.empty();
	private List<AnswerScore> answerScores;
	public SheetData(String jmbag, String group, List<String> answers)
	{
		this.jmbag = jmbag;
		this.group = group;
		this.answers = answers;
		this.answerScores = new ArrayList<AnswerScore>();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerScores == null) ? 0 : answerScores.hashCode());
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((jmbag == null) ? 0 : jmbag.hashCode());
		result = prime * result + ((totalScore == null) ? 0 : totalScore.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SheetData other = (SheetData) obj;
		if (answerScores == null) {
			if (other.answerScores != null)
				return false;
		} else if (!answerScores.equals(other.answerScores))
			return false;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (jmbag == null) {
			if (other.jmbag != null)
				return false;
		} else if (!jmbag.equals(other.jmbag))
			return false;
		if (totalScore == null) {
			if (other.totalScore != null)
				return false;
		} else if (!totalScore.equals(other.totalScore))
			return false;
		return true;
	}

	public String getJmbag()
	{
		return this.jmbag;
	}
	public List<String> getAnswers()
	{
		return this.answers;
	}
	public String getGroup()
	{
		return this.group;
	}
	public OptionalDouble getTotalScore()
	{
		return this.totalScore;
	}
	public void setTotalScore(OptionalDouble totalScore)
	{
		this.totalScore = totalScore;
	}

	public List<AnswerScore> getAnswerScores()
	{
		return answerScores;
	}

	public void setAnswerScores(List<AnswerScore> answerScores) 
	{
		this.answerScores = answerScores;
	}
}
