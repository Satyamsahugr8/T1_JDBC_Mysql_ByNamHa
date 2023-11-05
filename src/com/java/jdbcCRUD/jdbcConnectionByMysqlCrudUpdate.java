package com.java.jdbcCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcConnectionByMysqlCrudUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String databaseURL = "jdbc:mysql://localhost:3306/sampledb?user=root&password=Qwer@1234";
//		String sql = "INSERT INTO users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

		Connection con = null;
		
		try {
			con = DriverManager.getConnection(databaseURL);

			if (con != null) {
				System.out.println("Connected to the database");
			}

			String sql4 = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
			PreparedStatement statement = con.prepareStatement(sql4);
			statement.setString(1, "123456789");                 // updated password
			statement.setString(2, "William Henry Bill Gates");  // updated fullname
			statement.setString(3, "bill.gates@microsoft.com");  // updated email
			statement.setString(4, "bill");                      // which username to update   

			int rowUpdated = statement.executeUpdate();
			if (rowUpdated>0) {
				System.out.println("An existing user was updated successfully!");
			}
			
			
			
			

		} 
		
		
		catch (SQLException ex) {
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
