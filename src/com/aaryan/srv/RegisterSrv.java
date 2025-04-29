package com.aaryan.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaryan.beans.UserBean;
import com.aaryan.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterSrv
 */
@WebServlet("/RegisterSrv")
public class RegisterSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String userName = request.getParameter("username");
<<<<<<< HEAD
<<<<<<< HEAD
		String mobileNo = request.getParameter("mobile");
=======
		Long mobileNo = Long.parseLong(request.getParameter("mobile"));
>>>>>>> initial1
=======
		String mobileNo = request.getParameter("mobile");
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
		String emailId = request.getParameter("email");
		String address = request.getParameter("address");
		int pinCode = Integer.parseInt(request.getParameter("pincode"));
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
		String role = request.getParameter("role");
		String status = "";
		if (password != null && password.equals(confirmPassword)) {
			UserBean user = new UserBean(userName, mobileNo, emailId, address, pinCode, password,role);
<<<<<<< HEAD
=======
		String status = "";
		if (password != null && password.equals(confirmPassword)) {
			UserBean user = new UserBean(userName, mobileNo, emailId, address, pinCode, password);
>>>>>>> initial1
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc

			UserServiceImpl dao = new UserServiceImpl();

			status = dao.registerUser(user);
		} else {
			status = "Password not matching!";
		}

		RequestDispatcher rd = request.getRequestDispatcher("register.jsp?message=" + status);

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
