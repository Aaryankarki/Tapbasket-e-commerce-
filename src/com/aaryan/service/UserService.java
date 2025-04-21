package com.aaryan.service;

import com.aaryan.beans.UserBean;

public interface UserService {


	public String registerUser(String userName, String mobileNo, String emailId, String address, int pinCode,
			String password, String role);


	public String registerUser(UserBean user);

	public boolean isRegistered(String emailId);

	public String isValidCredential(String emailId, String password);

	public UserBean getUserDetails(String emailId, String password);

	public String getFName(String emailId);

	public String getUserAddr(String userId);

}
