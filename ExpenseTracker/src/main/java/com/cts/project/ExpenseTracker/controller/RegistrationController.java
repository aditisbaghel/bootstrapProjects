//<<<<<<< HEAD:Source Code/ExpenseTracker/src/main/java/com/cts/project/ExpenseTracker/controller/RegistrationController.java
//package com.cts.project.ExpenseTracker.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.cts.project.ExpenseTracker.dao.User;
//import com.cts.project.ExpenseTracker.service.ForgotProcess;
//import com.cts.project.ExpenseTracker.service.UserService;
//
////import com.piyush.Project.User;
//
//@Controller
//public class RegistrationController {
//
//	@Autowired
//	private User user;
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private ForgotProcess forgetProcess;
//	
//	@RequestMapping(value = "/SuccessController", method = RequestMethod.POST)
//	public String userHome(@ModelAttribute("user") @Valid User user, BindingResult result, ModelMap model) {
//			if(result.hasErrors())
//			{
//				return "Registration";
//			}
//			System.out.println(user);
//		boolean existing=userService.findByUserId(user);
//		if (!existing) {
//			System.out.println(user);
//		     userService.addUser(user);
//		     model.addAttribute("user1", "New user created successfully");
//		     System.out.println(user);
//			return "UserLogin";
//		}
//		
//		model.addAttribute("userId", "There is already an account registered with that UserId");
//		return "Registration";
//
//	}
//
//	@RequestMapping(value = "/Registration", method = RequestMethod.GET)
//	public String loginMessage(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {
//
//		return "Registration";
//
//	}
//	
//	@ModelAttribute("sQuestionController")
//	   public Map<String, String> getSQuestion() {
//	      Map<String, String> sQuestion = new HashMap<String, String>();
//	      sQuestion.put("Pet", "Your Pet's Name");
//	      sQuestion.put("Teacher", "Your Favorite Teacher's Name");
//	      sQuestion.put("Place", "Your Favorite Place");
//	      return sQuestion;
//	   }
//	
//
//	@RequestMapping(value="/UserLogin" , method= RequestMethod.GET)
//	public String GoToLogin( ModelMap model){
//		
//		return "UserLogin";
//	}
//	
//	
//	
//	
//	@RequestMapping(value="/forgetUserId" , method= RequestMethod.GET)
//	public String retrieveUserId(@ModelAttribute("forget")User user){
//		
//		return "forgetUserId";
//	}
//	
//	
//	@RequestMapping(value="/UserId" , method= RequestMethod.POST)
//	public String submitRetrieveUserId(@ModelAttribute("forget")User user, BindingResult result,@RequestParam String sQuestion, @RequestParam String sAnswer,ModelMap model){
//		
//		boolean existing=forgetProcess.validateUserId(sQuestion,sAnswer);
//		if(existing){
//			String userid=forgetProcess.findUserId(sQuestion, sAnswer);
//			model.addAttribute("UserId","This is your UserId:- "+userid );
//		return "forgetUserId";
//	  }
//		model.addAttribute("Error", "Security Question Answer didn't Match");
//		return "forgetUserId";
//		}
//	
//	
//	
//	@RequestMapping(value="/forgetPassword", method= RequestMethod.GET)
//	public String retrievePassword(@ModelAttribute("forgetPass")User user ){
//		
//		return "forgetPassword";
//	}
//	
//	
//	
//	@RequestMapping(value="/recoverPassword", method= RequestMethod.POST)
//	public String submitretrievePassword(@ModelAttribute("forgetPass")User user, BindingResult result,@RequestParam String userId,@RequestParam String sQuestion, @RequestParam String sAnswer, ModelMap model){
//		boolean existing=forgetProcess.validateUQA(userId,sQuestion,sAnswer);
//		String userIdDefault=forgetProcess.saveUserId(userId);
//		if(existing){
//		return "ResetPassword";
//		}
//		model.addAttribute("passError", "Question answer and userId didn't Match");
//		return "forgetPassword";
//	}
//	
//	
//	
//	@RequestMapping(value="/ResetPassword", method= RequestMethod.GET)
//	public String resetPassword(@ModelAttribute("resetPass")User user, ModelMap model){
//		
//		return "ResetPassword";
//	}
//	
//	
//	@RequestMapping(value="/resetPassword", method= RequestMethod.POST)
//	public String submitresetPassword(@ModelAttribute("resetPass")User user,BindingResult result,@RequestParam String password,@RequestParam String rePassword, ModelMap model){
//		boolean existing=forgetProcess.validatePassword(password,rePassword);
//		
//		if(existing){
//			forgetProcess.SavePassword(password);
//		return "index";
//		}
//		model.addAttribute("passSimlarError", "Passwords didn't match");
//		return "ResetPassword";
//	}
//	
//	
//	
//	
//	
//	
//=======
package com.cts.project.ExpenseTracker.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.project.ExpenseTracker.dao.User;
import com.cts.project.ExpenseTracker.service.ForgotProcess;
import com.cts.project.ExpenseTracker.service.UserService;

//import com.piyush.Project.User;

@Controller
public class RegistrationController {

	@Autowired
	private User user;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ForgotProcess forgetProcess;
	
	@RequestMapping(value = "/SuccessController", method = RequestMethod.POST)
	public String userHome(@ModelAttribute("user") @Valid User user, BindingResult result, ModelMap model) {
			if(result.hasErrors())
			{
				return "Registration";
			}
			System.out.println(user);
		boolean existing=userService.findByUserId(user);
		if (!existing) {
			System.out.println(user);
		     userService.addUser(user);
		     model.addAttribute("user1", "New user created successfully");
		     System.out.println(user);
			return "UserLogin";
		}
		
		model.addAttribute("userId", "There is already an account registered with that UserId");
		return "Registration";

	}

	@RequestMapping(value = "/Registration", method = RequestMethod.GET)
	public String loginMessage(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {

		return "Registration";

	}
	
	@ModelAttribute("sQuestionController")
	   public Map<String, String> getSQuestion() {
	      Map<String, String> sQuestion = new HashMap<String, String>();
	      sQuestion.put("Pet", "Your Pet's Name");
	      sQuestion.put("Teacher", "Your Favorite Teacher's Name");
	      sQuestion.put("Place", "Your Favorite Place");
	      return sQuestion;
	   }
	

	@RequestMapping(value="/UserLogin" , method= RequestMethod.GET)
	public String GoToLogin( ModelMap model){
		
		return "UserLogin";
	}
	
	
	
	
	@RequestMapping(value="/forgetUserId" , method= RequestMethod.GET)
	public String retrieveUserId(@ModelAttribute("forget")User user){
		
		return "forgetUserId";
	}
	
	
	@RequestMapping(value="/UserId" , method= RequestMethod.POST)
	public String submitRetrieveUserId(@ModelAttribute("forget")User user, BindingResult result,@RequestParam String sQuestion, @RequestParam String sAnswer,ModelMap model){
		
		boolean existing=forgetProcess.validateUserId(sQuestion,sAnswer);
		if(existing){
			String userid=forgetProcess.findUserId(sQuestion, sAnswer);
			model.addAttribute("UserId","This is your UserId:- "+userid );
		return "forgetUserId";
	  }
		model.addAttribute("Error", "Security Question Answer didn't Match");
		return "forgetUserId";
		}
	
	
	
	@RequestMapping(value="/forgetPassword", method= RequestMethod.GET)
	public String retrievePassword(@ModelAttribute("forgetPass")User user ){
		
		return "forgetPassword";
	}
	
	
	
	@RequestMapping(value="/recoverPassword", method= RequestMethod.POST)
	public String submitretrievePassword(@ModelAttribute("forgetPass")User user, BindingResult result,@RequestParam String userId,@RequestParam String sQuestion, @RequestParam String sAnswer, ModelMap model){
		boolean existing=forgetProcess.validateUQA(userId,sQuestion,sAnswer);
		String userIdDefault=forgetProcess.saveUserId(userId);
		if(existing){
		return "ResetPassword";
		}
		model.addAttribute("passError", "Question answer and userId didn't Match");
		return "forgetPassword";
	}
	
	
	
	@RequestMapping(value="/ResetPassword", method= RequestMethod.GET)
	public String resetPassword(@ModelAttribute("resetPass")User user, ModelMap model){
		
		return "ResetPassword";
	}
	
	
	@RequestMapping(value="/resetPassword", method= RequestMethod.POST)
	public String submitresetPassword(@ModelAttribute("resetPass")User user,BindingResult result,@RequestParam String password,@RequestParam String rePassword, ModelMap model){
		boolean existing=forgetProcess.validatePassword(password,rePassword);
		
		if(existing){
			forgetProcess.SavePassword(password);
			model.addAttribute("passchanged", "Passwords Changed Successfully");
		return "UserLogin";
		}
		model.addAttribute("passSimlarError", "Passwords didn't match");
		return "ResetPassword";
	}
	
	
	
	
	
	
	// >>>>>>>
	// b587a1f4d3f79b5373db6c047da677e374f2f2ab:ExpenseTracker/src/main/java/com/cts/project/ExpenseTracker/controller/RegistrationController.java
}