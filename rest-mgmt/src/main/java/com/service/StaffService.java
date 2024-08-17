package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.model.ProductPojo;
import com.model.StaffPojo;

@Service

public class StaffService {
	
	
	@Autowired
	JdbcTemplate j;
	
	public List<StaffPojo> getAllStaffDetails() {
		List<Map<String, Object>> l = j.queryForList("SELECT * FROM staff");
		List<StaffPojo> s = new ArrayList<StaffPojo>();
		for (int i = 0; i < l.size(); i++) {
			s.add(new StaffPojo ((String) l.get(i).get("email"), (String) l.get(i).get("name"),(int) l.get(i).get("contact")));
		}
		return s;
	}

	
	

}
