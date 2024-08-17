package com.cts.project.ExpenseTracker.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.project.ExpenseTracker.dao.User;
import com.cts.project.ExpenseTracker.dao.userid;
import com.cts.project.ExpenseTracker.service.UserService;

@Controller
@SessionAttributes("userId")
public class LoginController {
	@Autowired
	UserService userService;

	@RequestMapping("/expensetracker")
	public String indexPage() {
		return "index";
	}
	@RequestMapping("/login")
	public String userLogin(ModelMap model) {
		return "UserLogin";
	}

	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public String directHome() {
		return "UserLogin";
	}

	@RequestMapping(value = "/Home", method = RequestMethod.POST)
	public String goToUserHome(@ModelAttribute("userid")userid Userid,@RequestParam String userName, @RequestParam String password,
			@RequestParam String userType, ModelMap model) {
		if (userService.isValidUser(userName, password, userType)) {
			if (userType.equalsIgnoreCase("user")) {
				model.addAttribute("userId", userName);
				System.out.println(userType);
				return "UserHome";
			} else {
				System.out.println(userType);
				model.addAttribute("userId", userName);
				model.addAttribute("userType",userType);
				ArrayList<User> list=(ArrayList<User>) userService.getAllUser();
				Map<String, String> map = new HashMap<>();
				for(User user:list)
					map.put(user.getFirstName(), user.getUserId());
				model.addAttribute("allusers",map);
				return "AdminHome";
			}

		}

		model.addAttribute("loginError", "Please enter valid Username/Password");
		return "UserLogin";
	}

	// //fatching all users
	// @ModelAttribute("allusers")
	// public List<User> getAllUser(){
	// return userService.getAllUser();
	// }

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutUser(ModelMap model) {
		model.remove("userId");
		return "index";
	}

}
