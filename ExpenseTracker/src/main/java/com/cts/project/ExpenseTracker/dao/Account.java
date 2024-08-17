package com.cts.project.ExpenseTracker.dao;

public class Account {
	private String userId;
	private String accountNo;
	private String name;
	private String accType;
	private String IFSC;
	private String currType;// currency type

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public String getCurrType() {
		return currType;
	}

	public void setCurrType(String currType) {
		this.currType = currType;
	}

	public Account(String userId, String accountNo, String name, String accType, String iFSC, String currType) {
		super();
		this.userId = userId;
		this.accountNo = accountNo;
		this.name = name;
		this.accType = accType;
		IFSC = iFSC;
		this.currType = currType;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [userId=" + userId + ", accountNo=" + accountNo + ", name=" + name + ", accType=" + accType
				+ ", IFSC=" + IFSC + ", currType=" + currType + "]";
	}

}
