package com.mini.project.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mini.project.java.*;

public class Admin {
	
	public static void adminlogin() {
		System.out.println("Enter Admin Login details");
		try {
			System.out.println("Enter Username:");
			Scanner sc=new Scanner(System.in);
			String username=sc.next();
			System.out.println("Enter Password:");
			String pass=sc.next();
			Connection connection=CommonConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from admin where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				backfn();
			} else {
				System.out.println("Admin Login failed, Enter valid credentils!!");
				adminlogin();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public static void backfn() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Authentication Successfull Welcome to Admin Panel");
        System.out.println("1.Show Register users");
        System.out.println("2.Show users purchase history");
        System.out.println("3.Show Products quantity");
        int id= sc.nextInt();
        if (id == 1) {
        	UserRegistration.regUser();
        } else if (id == 2) {
        	Product.purHistory();
        } else if (id == 3) {
        	Product.prdQuantity();
        } else {
        	adminlogin();
        }
	}

}
