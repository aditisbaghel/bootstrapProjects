package com.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class RegistrationPojo {

	@NotEmpty(message = "Required")
	private String firstName;
	@NotEmpty(message = "Required")
	private String lastName;
	@NotEmpty(message = "Required")
	private long contactNumber;
	@NotEmpty(message = "Required")
	private String email;
	@NotEmpty(message = "Required")
	private String role;
	@NotEmpty(message = "Required")
	private String password;
	@NotEmpty(message = "Required")
	private String secretQuestion;
	@NotEmpty(message = "Required")
	private String secretAnswer;
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
