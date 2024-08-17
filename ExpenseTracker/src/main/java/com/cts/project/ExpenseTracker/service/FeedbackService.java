package com.cts.project.ExpenseTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.project.ExpenseTracker.dao.FeedbackQuestion;

@Service
public interface FeedbackService {

	public List<FeedbackQuestion> getAllQuestion();

}
