package com.example.Contractor;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.Dao.UserDaoImpl;
import com.example.model.Login;
import com.example.model.SpecificationDetails;
import com.example.model.User;

@Controller
@SessionAttributes("user_id")
public class RegistrationController {
	public static String userid;
	@Autowired
	private UserDaoImpl userDaoImpl;
	@RequestMapping(value="/Login",method=RequestMethod.GET)
	public String login(@ModelAttribute("login") Login login)
	{
		return "Login";	
	}
	@RequestMapping(value="/homepage",method=RequestMethod.POST)
	public String homePage(@ModelAttribute("login") Login login,ModelMap model)
	{
		if(userDaoImpl.userExist(login)) {
			if(login.getUserType().equals("Admin"))
				return "AdminAction";
			else if(login.getUserType().equals("User")) {
				model.put("user_id", login.getUserId());
				return "UserAction";
			}
				
				
		}
	   return "Login";
	}
	
	@RequestMapping(value="/Inbox",method=RequestMethod.GET)
	public String userInbox(@ModelAttribute("user_id")String user_id,ModelMap model) {
		List<String> msg=userDaoImpl.getMessages(user_id);
		if(msg!=null)
			{model.addAttribute("message", msg);}
			else {
		model.put("message","Please Fill the form");}
		return "Inbox";
	}
	
	@RequestMapping(value="/Registration", method=RequestMethod.GET)
	public String userRegistrationDisplay(@ModelAttribute("register") User register) {
		return "Registration";
	}
	
	@RequestMapping(value="/SpecificationsDetails", method=RequestMethod.GET)
	public String specificationDetails(@ModelAttribute("specificationDetails") SpecificationDetails specificationDetails) {
		return "SpecificationsDetails";
	}
	
	@RequestMapping(value="/message",method=RequestMethod.POST)
	public String message(@ModelAttribute("specificationDetails") SpecificationDetails specificationDetails, BindingResult bindingResult,ModelMap model)
	{
		if(userDaoImpl.enterSpecification(specificationDetails)) {
			model.put("message","Form saved Successfully");
			return "message";
		}
		model.put("message","Form not saved");
		return "message";
	}
	
	
	@RequestMapping(value="/Register",method=RequestMethod.POST)
	public String register(@ModelAttribute("register") @Valid User register, BindingResult bindingResult,ModelMap model)
	{
		 
		if (bindingResult.hasErrors())
		{
			return "Registration";
		}
		if(userDaoImpl.addUser(register)) {
			model.put("status", "Registeration done Successfully");
		}
		else {
			model.put("status", "User Id is already used");
		}
		return "Success";
	}
	
	
	@RequestMapping(value="/Success",method=RequestMethod.POST)
	public String success(@ModelAttribute("register") @Valid User register, BindingResult bindingResult,ModelMap model)
	{
		if (bindingResult.hasErrors())
		{
			return "Registration";
		}
		
		return "Success";
	} 
	
	@RequestMapping(value="/ForgetPassword",method=RequestMethod.POST)
	public String forgetPassword(@ModelAttribute("register") @Valid User register,BindingResult br, ModelMap model)
	{		
		/*if(br.hasErrors())
		{
			return "forgetPassword";
		}*/
		
		User user=userDaoImpl.checkQuestionAnswer(register.getUserId(), register.getQuestionType(), register.getAnswer());
		if(user!=null)
		{	userid=user.getUserId();
			return "ResetPassword";
		}
		model.put("error", "plz provide correct credentials");
		return  "forgetPassword";	
	}

	
	    @RequestMapping(value="/resetPassword") 
		public String resetPassword(@RequestParam String newpassword, @RequestParam String repassword) {
	    	System.out.println(newpassword+" "+repassword);
		 if(userDaoImpl.checkPassword(newpassword, repassword)) {
			 return "Login"; 
		 }
		return "ResetPassword";
		 
	    }
		 
	@ModelAttribute("questionList")
	public  Map<String,String> buildState(){
		Map<String, String> map=new HashMap<String, String>();
		map.put("What primary school did you attend?", "What primary school did you attend?");
		map.put("What Is your favorite book?", "What Is your favorite book?");
		map.put("What is your favorite food?", "What is your favorite food?");
		return map;
	}
	@RequestMapping(value="/pendingrequest")
	public String showDetails(ModelMap model){
		List<Map<String,Object>> list=userDaoImpl.showDetails();
		List<Object> l=new ArrayList<>();
		for(Map<String,Object> map:list)
		{    for(Object key:map.keySet())
			l.add(map.get(key));
		}
		//ModelMap model=new ModelMap();
		model.addAttribute("list",l);
		System.out.println(l);
		return "pendingrequest";
	}
	
	@ModelAttribute("usertype")
	public List<String> radio() {
		List<String> list = new ArrayList<>();
		list.add("Admin");
		list.add("User");
		return list;
	}
	
	@ModelAttribute("services")
	public List<String> select() {
		List<String> list = new ArrayList<>();
		list.add("Part Time");
		list.add("Full Time");
		return list;
	}
	
	@RequestMapping(value="/logout",method= RequestMethod.GET)
	public String logoutUser(ModelMap model){
		model.remove("user_id");
		return "Login";
	}
	@RequestMapping(value="/shh",method= RequestMethod.GET)
	public String forgetUserId(ModelMap model){
		
		return "shh";
	}
}

