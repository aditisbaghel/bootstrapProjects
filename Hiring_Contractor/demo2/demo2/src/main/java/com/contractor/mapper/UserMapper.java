package com.contractor.mapper;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

      User user= new User();
      user.setFirstName(rs.getString("first_name"));
      user.setLastName(rs.getString("last_name"));
      user.setDoB(rs.getString("dob"));
      user.setGender(rs.getString("gender"));
      user.setUserId(rs.getString("user_id"));
      user.setPassword(rs.getString("password"));
      user.setQuestionType(rs.getString("security_question"));
      user.setAnswer(rs.getString("answer"));
        return user;
    }
}