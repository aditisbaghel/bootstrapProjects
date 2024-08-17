package com.example.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class User {
	

	@Size(min = 1, message = "Please update the highlighted mandatory(*) fields.")
	private String firstName;
	//private String status;

	@Size(min = 1, message = "Please update the highlighted mandatory(*) fields.")
	private String lastName;
	@Pattern(regexp = "(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}", message = "Please update the highlighted mandatory(*) fields.")
	private String DoB;
	@NotNull
	private String gender;
	@NotNull
	private String userId;
	@Size(min = 6, /*
					 * regexp="^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{4,}$",
					 */message = "Please update the highlighted mandatory(*) fields.")
	private String Password;
	private String questionType;
	@NotNull
	private String answer;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/*
	 * public String getStatus() { return status; } public void setStatus(String
	 * status) { this.status = status; }
	 */
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDoB() {
		
		return DoB;
	}
	public void setDoB(String DoB) {
		this.DoB = DoB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", DoB=" + DoB
				+ ", gender=" + gender + ", userId=" + userId + ", Password=" + Password + ", questionType="
				+ questionType + ", answer=" + answer + "]";
	}
	

	

}
