package com.model;

public class StaffPojo {

	private String email;
	private String name;
	private int contact;

	public StaffPojo(String email, String name, int contact) {
		super();
		this.email = email;
		this.name = name;
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "StaffPojo [email=" + email + ", name=" + name + ", contact=" + contact + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

}
