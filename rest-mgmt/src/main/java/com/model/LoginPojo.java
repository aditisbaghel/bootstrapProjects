package com.model;

import javax.validation.constraints.NotEmpty;


public class LoginPojo {                                                                                                                                                             
	@NotEmpty(message = "Required")
	private String emailId;
	@NotEmpty(message = "Required")
	private String password;
	@NotEmpty(message = "Required")
	private String role;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
