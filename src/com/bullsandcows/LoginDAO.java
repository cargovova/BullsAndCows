package com.bullsandcows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public static boolean validate(String name, String pass) {
		boolean status = false;

		Connection conn = null;
		PreparedStatement pst = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "SA", "");
			stmt = conn.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE register (id INT NOT NULL, name VARCHAR(50) NOT NULL, pass VARCHAR(50) NOT NULL, PRIMARY KEY (name) );");
			pst = conn.prepareStatement("INSERT INTO register VALUES (1, 'admin', 'admin')");
			pst = conn.prepareStatement("SELECT id, name, pass FROM register");
			pst.setString(1, name);
			pst.setString(2, pass);

			rs = pst.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}
}