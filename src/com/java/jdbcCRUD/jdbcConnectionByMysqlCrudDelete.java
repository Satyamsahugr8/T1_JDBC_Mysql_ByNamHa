package com.java.jdbcCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class jdbcConnectionByMysqlCrudDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String databaseURL = "jdbc:mysql://localhost:3306/sampledb?user=root&password=Qwer@1234";

		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(databaseURL);
			if (conn != null) {
				System.out.println("Connected to the database");
			}
			
			String sql = "DELETE FROM users WHERE username=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "bill");

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			System.out.println("A user was deleted successfully!");
			}
			
		} 
		
		catch (SQLException ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		} 
		
		finally {
			if (conn != null) {
				
				try {
					conn.close();
				} 
				
				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}


	}

}
