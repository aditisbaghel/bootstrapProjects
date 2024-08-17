package com.cts.project.ExpenseTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class FeedbackProcess {

	@Autowired
	JdbcTemplate jdbc;

	public void addQuestion(String question) {
		int id=jdbc.queryForObject("select Max(id) from AdminQuestion",Integer.class);
		id=id+1;
		
		try {
			jdbc.update("insert into AdminQuestion values(?,?)",id,question);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
}
