package com.aaryan.service;

import com.aaryan.beans.UserBean;

public interface UserService {

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc

	public String registerUser(String userName, String mobileNo, String emailId, String address, int pinCode,
			String password, String role);

<<<<<<< HEAD
=======
	/*
	 * private String userName; private Long mobileNo; private String emailId;
	 * private String address; private int pinCode; private String password;
	 */

	public String registerUser(String userName, Long mobileNo, String emailId, String address, int pinCode,
			String password);
>>>>>>> initial1
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc

	public String registerUser(UserBean user);

	public boolean isRegistered(String emailId);

	public String isValidCredential(String emailId, String password);

	public UserBean getUserDetails(String emailId, String password);

	public String getFName(String emailId);

	public String getUserAddr(String userId);

}
