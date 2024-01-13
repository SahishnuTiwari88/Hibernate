package com.map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int ansId;
	private String answer;
	
	@OneToOne(mappedBy = "answer")//if we want to keep foreign key in one table only then we use mappedBy and field where we want it
	//like her we want it in Question
	private Question que;

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int ansId, String answer, Question que) {
		super();
		this.ansId = ansId;
		this.answer = answer;
		this.que = que;
	}

	public int getAnsId() {
		return ansId;
	}

	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQue() {
		return que;
	}

	public void setQue(Question que) {
		this.que = que;
	}

	@Override
	public String toString() {
		return "Answer [ansId=" + ansId + ", answer=" + answer + ", que=" + que + "]";
	}
	
}
