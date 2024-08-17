package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class adminDashboardController {
	


	
	

	@GetMapping("/reviews")
	public String showreviews()
	{
		return "admin/reviews";
	}

	@GetMapping("/editquestionaire")
	public String showeditquestionaire()
	{
		return "admin/editquestionaire";
	}

}
