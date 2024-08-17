package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.model.ProductPojo;
import com.model.StaffPojo;
import com.service.ProductsSerivce;
import com.service.StaffService;

@Controller
public class StaffController {
	
	
	@Autowired
	StaffService staffService;

	
	
	
	@GetMapping("/staff")
	public String showStaff(ModelMap m) {
		List<StaffPojo> l = staffService.getAllStaffDetails();
		m.addAttribute("staff", l);
		return "admin/staff";
	}
	
	

}
