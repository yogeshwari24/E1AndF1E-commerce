package com.mini.project.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mini.project.java.*;

public class List {

	public static void Listing(int userid) {
		System.out.println("\n------------------------------  Products  --------------------------------------- ");
		Scanner sc=new Scanner(System.in);		
		try {
			Connection connection=CommonConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement("select * from products ORDER BY ProductId");
			ResultSet rs=ps.executeQuery();	
			System.out.println("| ID |   Price   |    Quantity     |    ProductName   |    Description   |");
			System.out.println("---------------------------------------------------------------------------------- ");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getString(4) + "\t\t\t" + rs.getString(5));
		     }
			System.out.println("\n\n");
			System.out.println("1.Select Product for Add to Cart");
			System.out.println("2.Select Product to Buy now");
			System.out.println("3.Back");
			int prd=sc.nextInt();
			if (prd == 1) {
				System.out.println("Enter Product Id for Add to cart");
				int proid=sc.nextInt();
				System.out.println("Product Added to cart");
				Product_Cart1.Cart(userid , proid);
			} else if (prd == 2) {
				System.out.println("Enter Product Id To Buy now");
				int add=sc.nextInt();
				Product_Cart1.Buynow(userid , add);
			} else if (prd == 3) {
				Login.Login();
			} else {
				System.out.println("Wrong input selection");
				Listing(userid);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
