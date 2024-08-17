package com.cts.project.ExpenseTracker.dao;

import org.springframework.stereotype.Component;

@Component
public class FeedbackQuestion {

	private int id;
	private String question;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public FeedbackQuestion(int id, String question) {
		super();
		this.id = id;
		this.question = question;
	}
	public FeedbackQuestion() {
		super();
	}
	@Override
	public String toString() {
		return "FeedBackQuestion [id=" + id + ", question=" + question + "]";
	}
	

}
