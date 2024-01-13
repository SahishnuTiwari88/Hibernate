package com.map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int qId;
	private String question;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ans_id")// it is used to rename the foreign key column
	private Answer answer;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int qId, String question, Answer answer) {
		super();
		this.qId = qId;
		this.question = question;
		this.answer = answer;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Question [qId=" + qId + ", question=" + question + ", answer=" + answer + "]";
	}
	
}
