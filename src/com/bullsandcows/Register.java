package com.bullsandcows;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	Connection con = null;
	Statement stmt = null;

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String confirm_pass = request.getParameter("confirm");
		try {
			PrintWriter out = response.getWriter();
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:mem:MyDB", "SA", "");
			stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO register VALUES (name, pass)");
			if (pass.equals(confirm_pass)) {
				
				out.println("Sign Up Successful");
				RequestDispatcher rd = request.getRequestDispatcher("game.jsp");
				rd.forward(request, response);
			}

			else {
				out.println("Password dooesn't match");
				RequestDispatcher rd = request.getRequestDispatcher("game.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}