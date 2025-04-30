package com.aaryan.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.aaryan.beans.UserBean;
import com.aaryan.constants.IUserConstants;
import com.aaryan.service.UserService;
import com.aaryan.utility.DBUtil;

public class UserServiceImpl implements UserService {

    @Override
    public String registerUser(String userName, String mobileNo, String emailId, String address, int pinCode,
                               String password, String role) {
        UserBean user = new UserBean(userName, mobileNo, emailId, address, pinCode, password, role);
        return registerUser(user);
    }

    @Override
    public String registerUser(UserBean user) {
        String status = "User Registration Failed!";

        boolean isRegtd = isRegistered(user.getEmail());
        if (isRegtd) {
            return "Email Id Already Registered!";
        }

        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO " + IUserConstants.TABLE_USER + 
                " (email, name, mobile, address, pincode, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getName());
            ps.setString(3, user.getMobile());
            ps.setString(4, user.getAddress());
            ps.setInt(5, user.getPinCode());

            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            ps.setString(6, hashedPassword);
            ps.setString(7, user.getRole());

            int k = ps.executeUpdate();
            if (k > 0) {
                status = "User Registered Successfully!";
            }

        } catch (SQLException e) {
            status = "Error: " + e.getMessage();
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(conn);
        }

        return status;
    }

    @Override
    public boolean isRegistered(String emailId) {
        boolean flag = false;
        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT * FROM user WHERE email = ?");
            ps.setString(1, emailId);
            rs = ps.executeQuery();

            if (rs.next()) {
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(rs);
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
        }

        return flag;
    }

    @Override
    public String isValidCredential(String emailId, String password) {
        String status = "Login Denied! Incorrect Username or Password";
        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT password FROM user WHERE email = ?");
            ps.setString(1, emailId);
            rs = ps.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                if (BCrypt.checkpw(password, hashedPassword)) {
                    status = "valid";
                }
            }

        } catch (SQLException e) {
            status = "Error: " + e.getMessage();
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(rs);
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
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
            ps = con.prepareStatement("SELECT * FROM user WHERE email = ?");
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
        } finally {
            DBUtil.closeConnection(rs);
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
        }

        return user;
    }

    @Override
    public String getFName(String emailId) {
        String fname = "";
        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT name FROM user WHERE email = ?");
            ps.setString(1, emailId);
            rs = ps.executeQuery();

            if (rs.next()) {
                fname = rs.getString("name").split(" ")[0];
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(rs);
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
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
            ps = con.prepareStatement("SELECT address FROM user WHERE email = ?");
            ps.setString(1, userId);
            rs = ps.executeQuery();

            if (rs.next()) {
                userAddr = rs.getString("address");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(rs);
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(con);
        }

        return userAddr;
    }

	@Override
	public String registerUser(String userName, Long mobileNo, String emailId, String address, int pinCode,
			String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
