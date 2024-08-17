package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.model.LoginPojo;

@Service
public class LoginService {
	@Autowired
	JdbcTemplate t;

	public String logUserIn(LoginPojo l) {
		
		List<Map<String,Object>> res = t.queryForList("select * from user WHERE EMAIL = \""+ l.getEmailId()+"\"");
		if(res.size() == 0){
			return " User Id not present";
		}
		if(!res.get(0).get("PASSWORD").equals(l.getPassword())){
			return "Incorrect Password";
		}
		if(!res.get(0).get("ROLE").equals(l.getRole())){
			return "invalid role";
		}
		
		return "success";
		
		
	}
}
