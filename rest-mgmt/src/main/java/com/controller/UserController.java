package com.controller;

import javax.validation.Valid;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.LoggedInUser;
import com.model.LoginPojo;
import com.model.RegistrationPojo;
import com.model.ResetPojo;
import com.service.*;
import com.service.ResgistrationService;

@Controller
//@SessionAttributes("loggedInUser")
public class UserController {

	@Autowired
	LoginService loginService;
	@Autowired
	ResgistrationService registerService;
	@Autowired
	ResetService resetService;
	@GetMapping("/home")
	public String Home(){
		return "home";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	   public String Register() {
	      return "register";
	   }
	
	
	@GetMapping("user/login")
	public String showUserLogin(@ModelAttribute("login") LoginPojo login, BindingResult res, ModelMap model) {
		return "login";
	}

	@PostMapping("user/login")
	public ModelAndView submitUserLogin(@ModelAttribute("loggedInUser") LoggedInUser loggedInUser,
			@ModelAttribute("login") @Valid LoginPojo login, BindingResult res, ModelMap model) {
		String result = loginService.logUserIn(login);
		if (result != "success") {
			model.addAttribute("error", result);
			return new ModelAndView("login", model);
		}
		loggedInUser.setEmail(login.getEmailId());
		loggedInUser.setRole(login.getRole());
		System.out.println(login.getRole());
		return new ModelAndView(
				login.getRole().equals("admin") ? "redirect:/admin/admin-dashboard" : "redirect:/user/user-dashboard", model);
	}

	@GetMapping("user/register")
	public String showUserRegister(@ModelAttribute("register") RegistrationPojo register, BindingResult res,
			ModelMap model) {
		return "register";
	}

	@PostMapping("user/register")
	public ModelAndView submitUserRegister(@ModelAttribute("loggedInUser") LoggedInUser loggedInUser,
			@ModelAttribute("register") RegistrationPojo register, BindingResult res, ModelMap model) {
		String result = registerService.signUpUser(register);
		if (result != "success") {
			model.addAttribute("error", result);
			return new ModelAndView("register", model);
		}
		loggedInUser.setEmail(register.getEmail());
		loggedInUser.setRole(register.getRole());

		return new ModelAndView(
				register.getRole().equals("admin") ? "redirect:admin-dashboard" : "redirect: user/user-dashboard", model);
	}
	@ModelAttribute("list")
	public Map<String, String> buildState() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("What was your first pet?", "What was your first pet?");
		map.put("In what city were you born?", "In what city were you born?");
		map.put("What was your childhood nickname?", "What was your childhood nickname?");
		return map;

	}
	@ModelAttribute("role")
	public Map<String, String> buildRole() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("admin", "admin");
		map.put("user", "user");
		
		return map;

	}
	@GetMapping("admin/admin-dashboard")
	public String AdminPage(){
		return "admin/admindashboard";
	}
	@GetMapping("user/user-dashboard")
	public String UserPage(){
		return "user/userdashboard";
	}

	@GetMapping("/passwordreset")
	public String ResetPass(@ModelAttribute("reset") ResetPojo reset) {
		return "passwordreset";
	}

	@PostMapping("/passwordreset")
	public String ResetPassword(@ModelAttribute("reset") ResetPojo reset, ModelMap model) {

		String result = resetService.validate(reset);
		if (!result.equals("success")) {
			model.put("error", result);
			return "passwordreset";
		}
		resetService.Save(reset);
		model.put("error", "password changed successfully");
		return "passwordreset";
	}

	
}
