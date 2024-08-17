package com.cts.project.ExpenseTracker.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.cts.project.ExpenseTracker.dao.User;

@Service
public class UserService {

	@Autowired
	private User user;

	@Autowired
	JdbcTemplate jdbc;

	public boolean isValidUser(String username, String password, String userType) {

		int count = jdbc.queryForObject("select count(*) from user where userid= '" + username + "' AND password= '"
				+ password + "' AND usertype='" + userType + "'", Integer.class);
		return count == 1;

	}

	public boolean findByUserId(User user) {
		int result = jdbc.queryForObject("select count(*) from user where userId='" + user.getUserId() + "'",
				Integer.class);
             System.out.println("result"+result+"    "+user.getUserId());
		return result == 1;
	}

	public void addUser(User user) {
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		try {
			jdbc.update(sql, user.getUserId(), user.getFirstName(), user.getLastName(), user.getPassword(),
					user.getDateOfBirth(), user.getGender(), user.getContactNo(), user.getsQuestion(),
					user.getsAnswer(), user.getUserType());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public List<User> getAllUser() {

		List<User> list = new ArrayList<>();

		SqlRowSet rowSet = jdbc.queryForRowSet("select * from user");
		while (rowSet.next()) {
			list.add(
					new User(rowSet.getString("firstName"), rowSet.getString("lastName"), rowSet.getDate("dateOfBirth"),
							rowSet.getString("gender"), rowSet.getString("contactNo"), rowSet.getString("userId"),
							rowSet.getString("password"), rowSet.getString("sQuestion"), rowSet.getString("sAnswer")));
		}
		return list;
	}

}
