package com.bullsandcows;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text.html; charset=UTF-8");
		RequestDispatcher rd;
		PrintWriter out = response.getWriter();
		String hdnParam = request.getParameter("pagename");
		String fname = request.getParameter("fname");
		String password = request.getParameter("password");
		String confirmpass = request.getParameter("confirmpass");

		if (hdnParam.equals("register")) {
			if (password.equals(confirmpass)) {
				GetsSets set = new GetsSets();
				set.setFname(fname);
				set.setPassword(password);
				
				try {
					DBManager.Insert(set);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rd = request.getRequestDispatcher("successful.jsp");
				rd.forward(request, response);
			} else {
				out.println("Password dooesn't match");
				rd = request.getRequestDispatcher("register.jsp");
				rd.include(request, response);
			}
		}
		if (hdnParam.equals("login")) {
			String userName = request.getParameter("LogUser");
			String passWord = request.getParameter("LogPass");
			GetsSets set = new GetsSets();

			set.setFname(userName);
			set.setPassword(passWord);
			try {
				int checkUser = DBManager.checkUser(set);
				System.out.println(checkUser);
				if (checkUser == 1) {
					rd = request.getRequestDispatcher("successful.jsp");
					rd.forward(request, response);
				} else {
					out.print("Sorry, Password and Username Error");
					rd = request.getRequestDispatcher("home.jsp");
					rd.include(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
