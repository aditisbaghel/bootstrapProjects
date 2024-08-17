package com.cts.project.ExpenseTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.cts.project.ExpenseTracker.dao.FeedbackQuestion;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	public static List<FeedbackQuestion> l = new ArrayList<>();
	static {
		l.add(new FeedbackQuestion(1, "abc"));
		l.add(new FeedbackQuestion(2, "abc"));
		l.add(new FeedbackQuestion(3, "abc"));
	}

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<FeedbackQuestion> getAllQuestion() {
		List<FeedbackQuestion> list = new ArrayList<>();

		
		 SqlRowSet queryForRowSet = jdbc.queryForRowSet("select * from feedbackquestion");
		 while (queryForRowSet.next()) {
		 list.add(new FeedbackQuestion(queryForRowSet.getInt("id"),
		 queryForRowSet.getString("question")));
		 }
		return list;
	}

}
