package com.java.jdbcCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcConnectionByMysql {

	public static void main(String[] args) {

		String databaseURL = "jdbc:mysql://localhost:3306/userdb?user=root&password=Qwer@1234";

		Connection conn = null;

		try {

			conn = DriverManager.getConnection(databaseURL);
			if (conn != null) {
				System.out.println("Connected to the database");
			}

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			stmt.setCursorName(databaseURL);

			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2));

		} catch (SQLException ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		}

		finally {

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
