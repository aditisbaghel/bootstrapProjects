package com.cts.project.ExpenseTracker.dao;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", contactNo=" + contactNo + ", userId=" + userId + ", password=" + password + ", sQuestion="
				+ sQuestion + ", sAnswer=" + sAnswer + ", userType=" + userType + "]";
	}

	@NotEmpty(message = "Please enter First Name")
		private String firstName;

	@NotEmpty(message = "Please enter Last Name")
	private String lastName;

	@NotNull(message="Please enter Date")
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateOfBirth;
	
	@NotEmpty(message = "Please select Gender")
	private String gender;

	@NotEmpty(message = "Please Enter Contactno.")
	private String contactNo;

	
	@NotEmpty(message = "Please Enter UserId")
	private String userId;

	@NotEmpty(message = "Please enter Password")
	private String password;

	@NotEmpty(message = "Please select Security Question")
	private String sQuestion;

	@NotEmpty(message = "Please enter Answer")
	private String sAnswer;
	private String userType;
	
	
	

	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User( String firstName,String lastName, Date dateOfBirth, String gender,String contactNo,String userId, String password, String sQuestion,
	 String sAnswer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.contactNo = contactNo;
		this.userId = userId;
		this.password = password;
		this.sQuestion = sQuestion;
		this.sAnswer = sAnswer;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getsQuestion() {
		return sQuestion;
	}

	public void setsQuestion(String sQuestion) {
		this.sQuestion = sQuestion;
	}

	public String getsAnswer() {
		return sAnswer;
	}

	public void setsAnswer(String sAnswer) {
		this.sAnswer = sAnswer;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
