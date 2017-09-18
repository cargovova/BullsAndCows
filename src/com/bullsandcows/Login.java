package com.bullsandcows;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		HttpSession session = request.getSession(false);
		if (session != null)
			session.setAttribute("name", name);

		if (LoginDAO.validate(name, pass)) {
			RequestDispatcher rd = request.getRequestDispatcher("game.jsp");
			rd.forward(request, response);
		} else {
			out.print("Sorry, Password and Username Error");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
		}
		out.close();
	}
}
