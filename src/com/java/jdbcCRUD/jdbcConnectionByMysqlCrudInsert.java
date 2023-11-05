package com.java.jdbcCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbcConnectionByMysqlCrudInsert {

	public static void main(String[] args) {
		
		String databaseURL = "jdbc:mysql://localhost:3306/sampledb?user=root&password=Qwer@1234";
		String sql =  "INSERT INTO users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

		Connection con = null ;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how much data u need to enter to database");
		int a = sc.nextInt();
		for(int j = 0 ; j < a ; j++ ) {
			System.out.println("Enter data of "+ (j+1) + " user");
		try {
			con = DriverManager.getConnection(databaseURL);
			
			if (con != null) {
				System.out.println("Connected to the database");
			}
			
			System.out.println("username = ");
			String r = sc.next();
			System.out.println("password = ");
			String e = sc.next();
			System.out.println("fullname = ");
			String w = sc.next();
			System.out.println("email = ");
			String q = sc.next();
			
			
//			PreparedStatement statement = con.prepareStatement(sql);
//			statement.setString(1, "bill");
//			statement.setString(2, "secretpass");
//			statement.setString(3, "Bill Gates");
//			statement.setString(4, "bill.gates@microsoft.com");
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, r);
			statement.setString(2, e);
			statement.setString(3, w);
			statement.setString(4, q);
			
			int rowsInserted = statement.executeUpdate();
//			System.out.println(rowsInserted);
			if (rowsInserted > 0) {
			System.out.println("A new user was inserted successfully!");
			}
			
			
			// Query to display database data
			
//			String sql2 = "Select * from users";
//			Statement statement2 = con.createStatement();
//			ResultSet rst = statement2.executeQuery(sql2);
//			while(rst.next()) {
//				System.out.println(rst.getInt(1) + " " + rst.getString(2)+" "+rst.getString(3) + " " + rst.getString(4)+ " "+ rst.getString(5));
//			}
			
			
			
			

		}
		
		catch (SQLException ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		} 
		
		finally {
			if (con != null) {
				
				try {
					con.close();
				} 
				
				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		} // for loop end
		
		

//		**** Execute Select Query   ****
		
		
		
//		Connection con2 = null ;
//		try {
//			con2 = DriverManager.getConnection(databaseURL);
//			String sql2 = "Select * from users";
//			Statement statement2 = con2.createStatement();
//			ResultSet rst = statement2.executeQuery(sql2);
//			while(rst.next()) {
//				System.out.println(rst.getInt(1) + " " + rst.getString(2)+" "+rst.getString(3) + " " + rst.getString(4)+ " "+ rst.getString(5));
//			}
//		}
//		
//		catch (SQLException ex) {
//			System.out.println("An error occurred. Maybe user/password is invalid");
//			ex.printStackTrace();
//		} 
//		
//		finally {
//			if (con2 != null) {
//				
//				try {
//					con2.close();
//				} 
//				
//				catch (SQLException ex) {
//					ex.printStackTrace();
//				}
//			}
//		}

		sc.close();
	
	}
}
