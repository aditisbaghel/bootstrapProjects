package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.model.RegistrationPojo;

@Service
public class ResgistrationService {
	@Autowired
	JdbcTemplate t;

	public String signUpUser(RegistrationPojo r) {
		List<Map<String, Object>> res = t.queryForList("select * from user WHERE EMAIL = \"" + r.getEmail() + "\"");
		if (res.size() != 0) {
			return "Email Already Present";
		}
		int response = t.update(
				"INSERT INTO `mydb`.`user` (`EMAIL`, `FIRST_NAME`, `LAST_NAME`, `CONTACT_NUMBER`, `PASSWORD`, `SECRET_QUESTION`, `SECRET_ANSWER`, `ROLE`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
				r.getEmail(), r.getFirstName(), r.getLastName(), r.getContactNumber(), r.getPassword(),
				r.getSecretQuestion(), r.getSecretAnswer(), r.getRole());
		return response == 1 ? "success" : "error";
	}
}
