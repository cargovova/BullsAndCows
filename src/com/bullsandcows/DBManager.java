package com.bullsandcows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static Connection conn = ConnectionManager.getInstance().getConnection();

	public static void Insert(GetsSets set) throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
	
		String sql = "INSERT INTO register (fname, password) VALUES(?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, set.getFname());
		pstmt.setString(2, set.getPassword());
		pstmt.executeUpdate();
		ConnectionManager.getInstance();
	}

	public static int checkUser(GetsSets get) throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");

		String sql = "SELECT COUNT(*) FROM register WHERE fname = ? AND password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, get.getFname());
		pstmt.setString(2, get.getPassword());
		ResultSet rs = pstmt.executeQuery();
		System.out.println(get);
		int count = 0;
		while (rs.next()) {
			count = rs.getInt(1);
		}
		
		ConnectionManager.getInstance();
		return count;

	}
}
