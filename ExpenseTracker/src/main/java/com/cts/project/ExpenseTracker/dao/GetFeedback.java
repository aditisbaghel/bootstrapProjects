package com.cts.project.ExpenseTracker.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GetFeedback {

	
	private List<Feedback> feedbacks;

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	
	
}
