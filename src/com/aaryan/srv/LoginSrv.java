package com.aaryan.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
<<<<<<< HEAD
import org.mindrot.jbcrypt.BCrypt;

=======
>>>>>>> initial1
=======
import org.mindrot.jbcrypt.BCrypt;

>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
import com.aaryan.beans.UserBean;
import com.aaryan.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginSrv
 */
@WebServlet("/LoginSrv")
public class LoginSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginSrv() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
<<<<<<< HEAD
<<<<<<< HEAD
		
=======
>>>>>>> initial1
=======
		
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
		String userType = request.getParameter("usertype");
		response.setContentType("text/html");

		String status = "Login Denied! Invalid Username or password.";

		if (userType.equals("admin")) { // Login as Admin
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc

			
				// valid
				UserServiceImpl udao = new UserServiceImpl();

				status = udao.isValidCredential(userName, password);
//				System.out.println(status);

				if (status.equalsIgnoreCase("valid")) {
					// valid user

					UserBean user = udao.getUserDetails(userName, password);
		

					HttpSession session = request.getSession();

					session.setAttribute("userdata", user);

<<<<<<< HEAD
=======
			

			if (userName.equals("admin@gmail.com")) {
				UserServiceImpl udao = new UserServiceImpl();

				status = udao.isValidCredential(userName, password);

				if (status.equalsIgnoreCase("valid")) {

					RequestDispatcher rd = request.getRequestDispatcher("adminViewProduct.jsp");

					HttpSession session = request.getSession();

>>>>>>> initial1
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
					session.setAttribute("username", userName);
					session.setAttribute("password", password);
					session.setAttribute("usertype", userType);

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
					
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminViewProduct.jsp");


				session.setAttribute("username", userName);
				session.setAttribute("password", password);
				session.setAttribute("usertype", userType);

				requestDispatcher.forward(request, response);

<<<<<<< HEAD
=======
					rd.forward(request, response);
					
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp?message=" + status);
					rd.include(request, response);
				}
				// valid

			} else {
				// Invalid;
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp?message=" + status);
				rd.include(request, response);
>>>>>>> initial1
=======
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc
			}

		} else { // Login as customer

			UserServiceImpl udao = new UserServiceImpl();

			status = udao.isValidCredential(userName, password);
<<<<<<< HEAD
<<<<<<< HEAD
//			System.out.println(status);
=======
>>>>>>> initial1
=======
//			System.out.println(status);
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc

			if (status.equalsIgnoreCase("valid")) {
				// valid user

				UserBean user = udao.getUserDetails(userName, password);
<<<<<<< HEAD
<<<<<<< HEAD
	
=======
>>>>>>> initial1
=======
	
>>>>>>> e5f10af91fa136c90abc052ddb243af30588acbc

				HttpSession session = request.getSession();

				session.setAttribute("userdata", user);

				session.setAttribute("username", userName);
				session.setAttribute("password", password);
				session.setAttribute("usertype", userType);

				RequestDispatcher rd = request.getRequestDispatcher("userHome.jsp");

				rd.forward(request, response);

			} else {
				// invalid user;

				RequestDispatcher rd = request.getRequestDispatcher("login.jsp?message=" + status);

				rd.forward(request, response);

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
