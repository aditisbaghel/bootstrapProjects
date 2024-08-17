package com.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.RegistrationBean;
import com.validate.CustomValidator;

@Controller
public class RegistrationController {

	@Autowired
	private CustomValidator custValidator;
	
	@RequestMapping(value="/registerPage",method=RequestMethod.GET)
	public String registerPage(@ModelAttribute("register") RegistrationBean  registrationBean){
	registrationBean= new RegistrationBean();
	
		
		return "registrationpage";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	  public String performRegistration(@ModelAttribute("register") @Valid RegistrationBean  registrationBean,BindingResult result) {
		custValidator.validate(registrationBean , result);
		if(result.hasErrors()){
			return "registrationpage";
		}
		else{
		  
		//model.addAttribute("userName", registrationBean.getUserName());
		//model.addAttribute("emailId", registrationBean.getEmailId());
			
			return "thankyou";
		}
		
	}	 	  		    	    	     	      	 	
}
