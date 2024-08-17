package com.validate;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.RegistrationBean;
@Service
public class CustomValidator implements Validator{

	
	public void validate(Object arg0, Errors arg1) {
		RegistrationBean registrationBean = (RegistrationBean)arg0;
		if(registrationBean.isStatus() == false){
		arg1.rejectValue("status", "","please agree to the terms and conditions");
		}
		
		String phoneNo = ""+registrationBean.getContactNumber();
		if(!phoneNo.matches("[0-9]{10}")){
			arg1.rejectValue("contactNumber", "", "Contact Number should be of 10 digits/Contact Number should not be blank");
		}
		
		if(registrationBean.getUserName().length()<=0){
			arg1.rejectValue("userName", "", "User Name cannot be blank");
		}
		boolean status1=true;
		boolean status2=true;
		
		ValidationUtils.rejectIfEmpty(arg1, "emailId", "emailId.required", "Email ID cannot be blank");
		ValidationUtils.rejectIfEmpty(arg1, "confirmEmailId", "confirmEmailId.required", "Confirm Email ID cannot be blank");
		if(!(registrationBean.getEmailId().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))){
			arg1.rejectValue("emailId", "","Should be a proper email ID format");
			status1=false;
		}
		if(!(registrationBean.getEmailId().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))){
			arg1.rejectValue("confirmEmailId", "","Should be a proper email ID format");
			status2=false;
		}
		if(status1 && status2){
		    if(!(registrationBean.getEmailId().equals(registrationBean.getConfirmEmailId()))){
			arg1.rejectValue("confirmEmailId","", "Email and Confirm Email should be same");
		    }}
	}	 	  	    	    	     	      	 	

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return RegistrationBean.class.equals(arg0);
	}
	

}
