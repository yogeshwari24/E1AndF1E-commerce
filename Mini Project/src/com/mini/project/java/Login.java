package com.mini.project.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mini.project.java.*;

public class Login {
	
	public static void Login() {
        System.out.println("Enter Login details");
		try {
			System.out.println("Enter Email:");
			Scanner sc=new Scanner(System.in);
			String email=sc.next();
			System.out.println("Enter Password:");
			String pass=sc.next();
			System.out.println("Enter UserId:");
			int UId=sc.nextInt();
			Connection connection=CommonConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from user where emailID=? and password=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
	            System.out.print("Authentication Successfull:\n ");
	            List.Listing(UId);
			} else {
				System.out.println("Login failed, Enter valid credentils!!");
				Login();
			}
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
