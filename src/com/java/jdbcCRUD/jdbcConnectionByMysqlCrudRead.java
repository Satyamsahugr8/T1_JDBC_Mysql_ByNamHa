package com.java.jdbcCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcConnectionByMysqlCrudRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String databaseURL = "jdbc:mysql://localhost:3306/sampledb?user=root&password=Qwer@1234";
		@SuppressWarnings("unused")
		String sql = "INSERT INTO users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

		Connection con = null;

		try {
			con = DriverManager.getConnection(databaseURL);

			if (con != null) {
				System.out.println("Connected to the database");
			}

			String sql3 = "SELECT * FROM users";
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(sql3);
			int count = 0;
			while (result.next()) {
				String username = result.getString(2);
				String pass = result.getString(3);
				String fullname = result.getString("fullname");
				String email = result.getString("email");
//				String output = "User #%d: %s - %s - %s - %s";
//				System.out.println(String.format(output, ++count, username, pass, fullname, email));
				System.out.println("User #"+(++count)+": "+ username +" - "+ pass+" - "+ fullname +" - "+ email);
			}

		} catch (SQLException ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		} finally {
			if (con != null) {

				try {
					con.close();
				}

				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

	}

}
