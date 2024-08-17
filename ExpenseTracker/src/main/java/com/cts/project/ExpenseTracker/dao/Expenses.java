package com.cts.project.ExpenseTracker.dao;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Expenses {
	private int expenseId;
	private String userId;
	private String pType;
	private double price;
	private String product;
	@DateTimeFormat(iso = ISO.DATE)
	private Date date;

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + expenseId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expenses other = (Expenses) obj;
		if (expenseId != other.expenseId)
			return false;
		return true;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Expenses [expenseId=" + expenseId + ", userId=" + userId + ", pType=" + pType + ", price=" + price
				+ ", product=" + product + ", date=" + date + "]";
	}

	public Expenses(int expenseId, String userId, String pType, double price, String product, Date date) {
		super();
		this.expenseId = expenseId;
		this.userId = userId;
		this.pType = pType;
		this.price = price;
		this.product = product;
		this.date = date;
	}

	public Expenses() {
		super();
		// TODO Auto-generated constructor stub
	}

}
