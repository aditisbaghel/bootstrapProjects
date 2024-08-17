package com.cts.project.ExpenseTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ForgotProcess {
	
	@Autowired
	JdbcTemplate jdbc;
	
	
	private static String sql;
	
	public  boolean validateUserId(String sQuestion, String sAnswer){

		int count = jdbc.queryForObject("select count(*) from user where sQuestion= '"+sQuestion+"' AND sAnswer= '"+sAnswer+"'", Integer.class);
		return count == 1;
	}

	public String findUserId(String sQuestion, String sAnswer) {
		
			String sql = jdbc.queryForObject("select userId from user where sQuestion= '"+sQuestion+"' AND sAnswer= '"+sAnswer+"'",
					String.class);
			return sql;
			
		}


	public boolean validateUQA(String userId, String sQuestion, String sAnswer) {
		int count = jdbc.queryForObject("select count(*) from user where userId='"+userId+"' AND sQuestion= '"+sQuestion+"' AND sAnswer= '"+sAnswer+"'", Integer.class);
		return count == 1;
	}

	public boolean validatePassword(String password, String rePassword) {
		if(password.equals(rePassword)){
			return true;
		}
		return false;
	}
	public String saveUserId(String userId) {
		sql=userId;
		return sql;
	}

	public void SavePassword(String password) {
		
		jdbc.update("update user set password = '"+password+"' where userId ='"+sql+"'");
	}

	
}
