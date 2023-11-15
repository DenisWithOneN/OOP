package com.doors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

	private static Connection conn;
	
// am creat doua metode statice, care sa ne dea conectiunea si sa ne inchida conectiunea
// * aici
	public static Connection getConnection() throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		if (conn == null || conn.isClosed()) {
			Properties connectionProps = new Properties();
			connectionProps.put("user", "root");
			connectionProps.put("password", "");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/woods", connectionProps);
		}
		return conn;
	}

	// * si aici
	public static void closeConnection() {
		try {
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
