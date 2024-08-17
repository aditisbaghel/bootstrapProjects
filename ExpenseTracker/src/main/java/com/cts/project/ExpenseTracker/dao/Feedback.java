package com.cts.project.ExpenseTracker.dao;

import org.springframework.stereotype.Component;

@Component
public class Feedback {
	private String userId;
	private String feedback;
	private int feedbackId;
	private int questionId;

	public String getUserId() {
		return userId;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public Feedback(String userId, String feedback, int feedbackId, int questionId) {
		super();
		this.userId = userId;
		this.feedback = feedback;
		this.feedbackId = feedbackId;
		this.questionId = questionId;
	}

	

	

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
}
