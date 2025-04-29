package com.aaryan.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable {

	public UserBean() {
	}

<<<<<<< HEAD
	public UserBean(String userName, String mobileNo, String emailId, String address, int pinCode, String password) {
=======
	public UserBean(String userName, Long mobileNo, String emailId, String address, int pinCode, String password) {
>>>>>>> initial1
		super();
		this.name = userName;
		this.mobile = mobileNo;
		this.email = emailId;
		this.address = address;
		this.pinCode = pinCode;
		this.password = password;
	}
<<<<<<< HEAD
	

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
=======

	private String name;
	private Long mobile;
>>>>>>> initial1
	private String email;
	private String address;
	private int pinCode;
	private String password;
<<<<<<< HEAD
	private String role;
=======

>>>>>>> initial1
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

<<<<<<< HEAD
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
=======
	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
>>>>>>> initial1
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

<<<<<<< HEAD
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	} 



}
=======
}
>>>>>>> initial1
