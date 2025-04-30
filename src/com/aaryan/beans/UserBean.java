package com.aaryan.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable {

	public UserBean() {
	}

	public UserBean(String userName, String mobileNo, String emailId, String address, int pinCode, String password) {
		super();
		this.name = userName;
		this.mobile = mobileNo;
		this.email = emailId;
		this.address = address;
		this.pinCode = pinCode;
		this.password = password;
	}

	public UserBean(String name, String mobile, String email, String address, int pinCode, String password, String role) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.pinCode = pinCode;
		this.password = password;
		this.role = role;
	}


	private String name;
	private String mobile;
	
	private String email;
	private String address;
	private int pinCode;
	private String password;
	private String role;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
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