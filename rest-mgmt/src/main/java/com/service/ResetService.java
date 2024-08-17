package com.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.model.RegistrationPojo;
import com.model.ResetPojo;
@Service
public class ResetService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public String validate(ResetPojo reset) {
		List<Map<String, Object>> res = jdbcTemplate
				.queryForList("select * from user WHERE EMAIL = \"" + reset.getEmail() + "\"");
		if (res.size() == 0) {
			return "Email not present";
		}
		String question = reset.getQuestion();
		String Answer = reset.getAnswer();
		if (!res.get(0).get("SECRET_QUESTION").equals(question)) {
			return "please choose correct question";
		}
		if (!res.get(0).get("SECRET_ANSWER").equals(Answer)) {
			return "please choose correct answer";
		}
		if(!reset.getPassword().equals(reset.getConfirm())){
			return "confirm password thik se dalo";
		}
		return "success";

	}
	public void Save(ResetPojo reset){
		String sql="update user set password=? where email=?";
		jdbcTemplate.update(sql, reset.getPassword(),reset.getEmail());
		
	}


}
