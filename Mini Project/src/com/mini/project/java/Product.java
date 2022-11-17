package com.mini.project.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mini.project.java.*;

public class Product {
	
	public static void purHistory() {
		try {
			Connection connection= CommonConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from purchasehistory");			
			ResultSet rs=ps.executeQuery();
			System.out.println("orderid\tuserid\t\tproductid");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t\t" + rs.getInt(3));				
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

	
	public static void prdQuantity() {
		try {
			Connection connection= CommonConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("select ProductId, quantity from products");			
			ResultSet rs=ps.executeQuery();
			System.out.println("ProductId\tQuantity");
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t\t"+rs.getInt(2));
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
