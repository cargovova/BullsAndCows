package com.bullsandcows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	private static ConnectionManager instance = null;

	private final String USERNAME = "SA";
	private final String PASSWORD = "root";
	private final String CONN_STRING = "jdbc:hsqldb:file:${workspace_loc}";

	private Connection conn = null;

	private ConnectionManager() {
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	private boolean openConnection() {
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS register (fname VARCHAR(20) NOT NULL, password VARCHAR(20) NOT NULL);");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public Connection getConnection() {
		if (conn == null) {
			if (openConnection()) {
				System.out.println("Connection Opened");
				return conn;
			} else {
				return null;
			}
		}
		return conn;
	}

	public void close() {
		System.out.println("Closing Connection");
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = null;
	}
}
