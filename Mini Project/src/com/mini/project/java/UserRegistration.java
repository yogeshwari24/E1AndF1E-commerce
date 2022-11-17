package com.mini.project.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mini.project.java.*;
import com.mini.project.java.*;


public class UserRegistration {
	
	public static void insertUserData(String name,String password,String MobileNumber,String emailID,String userId ) {
		//Connection rs=null;
		Connection connection=null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=utf8","root","admin123");
			PreparedStatement ps=connection.prepareStatement("insert into user(name,password,MobileNumber,emailID,userId)values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, MobileNumber);
			ps.setString(4, emailID);
			ps.setString(5, userId);

			ps.executeUpdate();
			System.out.println("User Is Registere Successfully");
           
			homePage.homepage();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void regUser() {
		try {
			Connection connection= CommonConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from user");			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println("Name: " + rs.getString(1));
				System.out.println("Password: " + rs.getString(2));
				System.out.println("Mobile No: " + rs.getLong(3));
				System.out.println("EmailID: " + rs.getString(4));
				System.out.println("UserID: " + rs.getInt(5));
		     }
			System.out.println("1.Back");
			Scanner sc=new Scanner(System.in);
			int val = sc.nextInt();
			if (val == 1) {
				Admin.backfn();
			} else {
				homePage.homepage();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}