package com.bullsandcows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {

	public static boolean validate(String name, String pass) {
		boolean status = false;
		
		Connection con;
		Statement stmt;
		ResultSet res;
		
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:mem:MyDB", "SA", "");
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE register (id INT NOT NULL, name VARCHAR(50) NOT NULL, pass VARCHAR(50) NOT NULL, PRIMARY KEY (id) );");
			String logq = "SELECT name, pass FROM register";
			
			PreparedStatement ps = con.prepareStatement(logq);
			ps.setString(1, name);
			ps.setString(2, pass);

			res = ps.executeQuery();
			status = res.next();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;

	}
}