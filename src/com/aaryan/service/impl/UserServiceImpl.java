package com.aaryan.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.aaryan.beans.UserBean;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.aaryan.constants.IUserConstants;
>>>>>>> initial1
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
import com.aaryan.service.UserService;
import com.aaryan.utility.DBUtil;
// Removed mailing import

public class UserServiceImpl implements UserService {

	@Override
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
	public String registerUser(String userName,  String mobileNo, String emailId, String address, int pinCode,
			String password,String role) {

		UserBean user = new UserBean(userName, mobileNo, emailId, address, pinCode, password,role);
<<<<<<< HEAD
=======
	public String registerUser(String userName, Long mobileNo, String emailId, String address, int pinCode,
			String password) {

		UserBean user = new UserBean(userName, mobileNo, emailId, address, pinCode, password);
>>>>>>> initial1
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc

		String status = registerUser(user);

		return status;
	}

	@Override
	public String registerUser(UserBean user) {

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
	    String status = "User Registration Failed!";

	    boolean isRegtd = isRegistered(user.getEmail());

	    if (isRegtd) {
	        status = "Email Id Already Registered!";
	        return status;
	    }

	    Connection conn = DBUtil.provideConnection();
	    PreparedStatement ps = null;
	    if (conn != null) {
	        System.out.println("Connected Successfully!");
	    }

	    try {
	        // Include the role in the SQL insert query
	        ps = conn.prepareStatement("insert into user (email, name, mobile, address, pincode, password, role) values(?,?,?,?,?,?,?)");

	        ps.setString(1, user.getEmail());
	        ps.setString(2, user.getName());
	        ps.setString(3, user.getMobile());
	        ps.setString(4, user.getAddress());
	        ps.setInt(5, user.getPinCode());

	        // Hash the password before saving
	        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	        ps.setString(6, hashedPassword);

	        // Set the role (either "user" or "admin")
	        ps.setString(7, user.getRole());

	        int k = ps.executeUpdate();

	        if (k > 0) {
	            status = "User Registered Successfully!";
	        }

	    } catch (SQLException e) {
	        status = "Error: " + e.getMessage();
	        e.printStackTrace();
	    }

	    DBUtil.closeConnection(ps);
	    DBUtil.closeConnection(conn);

	    return status;
	}


<<<<<<< HEAD
=======
		String status = "User Registration Failed!";

		boolean isRegtd = isRegistered(user.getEmail());

		if (isRegtd) {
			status = "Email Id Already Registered!";
			return status;
		}
		Connection conn = DBUtil.provideConnection();
		PreparedStatement ps = null;
		if (conn != null) {
			System.out.println("Connected Successfully!");
		}

		try {

			ps = conn.prepareStatement("insert into " + IUserConstants.TABLE_USER + " values(?,?,?,?,?,?,?)");

			ps.setString(1, user.getEmail());
			ps.setString(2, user.getName());
			ps.setLong(3, user.getMobile());
			ps.setString(4, user.getAddress());
			ps.setInt(5, user.getPinCode());
			String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			ps.setString(6, hashedPassword);
			ps.setString(7, "customer");

			int k = ps.executeUpdate();

			if (k > 0) {
				status = "User Registered Successfully!";
				// Removed mailing functionality
			}

		} catch (SQLException e) {
			status = "Error: " + e.getMessage();
			e.printStackTrace();
		}

		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(ps);

		return status;
	}

>>>>>>> initial1
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
	@Override
	public boolean isRegistered(String emailId) {
		boolean flag = false;

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from user where email=?");

			ps.setString(1, emailId);

			rs = ps.executeQuery();

			if (rs.next())
				flag = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return flag;
	}

	@Override
	public String isValidCredential(String emailId, String password) {
	    String status = "Login Denied! Incorrect Username or Password";

	    Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        ps = con.prepareStatement("select password from user where email=?");
	        ps.setString(1, emailId);
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> initial1
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            String hashedPassword = rs.getString("password");
<<<<<<< HEAD
<<<<<<< HEAD
	           System.out.println(hashedPassword);
	           System.out.println(BCrypt.checkpw(password, hashedPassword));

=======

	            // Check if hashed password matches
>>>>>>> initial1
=======
	           System.out.println(hashedPassword);
	           System.out.println(BCrypt.checkpw(password, hashedPassword));

>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
	            if (BCrypt.checkpw(password, hashedPassword)) {
	                status = "valid";
	            }
	        }

	    } catch (SQLException e) {
	        status = "Error: " + e.getMessage();
	        e.printStackTrace();
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
	    }

	    DBUtil.closeConnection(con);
	    DBUtil.closeConnection(ps);
	    DBUtil.closeConnection(rs);
	    return status;
	}


	@Override
	public UserBean getUserDetails(String emailId, String password) {
	    UserBean user = null;

	    Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        ps = con.prepareStatement("select * from user where email=?");
	        ps.setString(1, emailId);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            String hashedPassword = rs.getString("password");

	            if (BCrypt.checkpw(password, hashedPassword)) {
	                user = new UserBean();
	                user.setName(rs.getString("name"));
	                user.setMobile(rs.getString("mobile"));
	                user.setEmail(rs.getString("email"));
	                user.setAddress(rs.getString("address"));
	                user.setPinCode(rs.getInt("pincode"));
	                user.setPassword(hashedPassword);
	                user.setRole(rs.getString("role"));  
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    DBUtil.closeConnection(con);
	    DBUtil.closeConnection(ps);
	    DBUtil.closeConnection(rs);

	    return user;
	}


<<<<<<< HEAD
=======
	    } finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	        DBUtil.closeConnection(rs);
	    }

	    return status;
	}

	@Override
	public UserBean getUserDetails(String emailId, String password) {

		UserBean user = null;

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, emailId);
			ps.setString(2, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new UserBean();
				user.setName(rs.getString("name"));
				user.setMobile(rs.getLong("mobile"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setPinCode(rs.getInt("pincode"));
				user.setPassword(rs.getString("password"));

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return user;
	}
>>>>>>> initial1
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc

	@Override
	public String getFName(String emailId) {
		String fname = "";

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select name from user where email=?");
			ps.setString(1, emailId);

			rs = ps.executeQuery();

			if (rs.next()) {
				fname = rs.getString(1);

				fname = fname.split(" ")[0];

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return fname;
	}

	@Override
	public String getUserAddr(String userId) {
		String userAddr = "";

		Connection con = DBUtil.provideConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select address from user where email=?");

			ps.setString(1, userId);

			rs = ps.executeQuery();

			if (rs.next())
				userAddr = rs.getString(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return userAddr;
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	
	
=======
>>>>>>> initial1
=======
	
	
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc

}
