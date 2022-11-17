package com.mini.project.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Product_Cart1 {

	
	public static void Cart(int userid, int productid) {
		try {
			Connection connection = CommonConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement("insert into cart(userid,productid)values(?,?)");
			ps.setInt(1, userid);
			ps.setInt(2, productid);
			ps.executeUpdate();
			
			System.out.println("Press 1 To Generate Bill");

			Scanner sc=new Scanner(System.in);
			int pr=sc.nextInt();
			if (pr == 1) {
				System.out.println("\nEnter product id from above products to buy now:");
				int prodid=sc.nextInt();
				Buynow(userid, prodid);		
			}
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void Buynow(int userid, int productid) {
		try {
			Connection connection=CommonConnection.getConnection();
			PreparedStatement ps=connection.prepareStatement("insert into purchasehistory(userid,productid)values(?,?)");
			ps.setInt(1, userid);
			ps.setInt(2, productid);
			ps.executeUpdate();
			PreparedStatement prst=connection.prepareStatement("select quantity from products where ProductId = ?");
			prst.setInt(1, productid);
			ResultSet prstg=prst.executeQuery();
			if (prstg.next()) {
			    int quan =  prstg.getInt(1) - 1;
				PreparedStatement us=connection.prepareStatement("update products set quantity = ? where productid = ?");
				us.setInt(1, quan);
				us.setInt(2, productid);
				us.executeUpdate();
			}
			Scanner sc=new Scanner(System.in);
			System.out.println("1.See Purchase History Generate Bill");
			System.out.println("2. To Continue Shopping");
			System.out.println("3.Back to Home");
			int pr=sc.nextInt();
			
			if (pr == 1) {
				PreparedStatement ps1=connection.prepareStatement("select * from products p inner join purchasehistory c on p.productid = c.productid");
				ResultSet rs=ps1.executeQuery();
				System.out.println("| ID  |   Price   |    Quantity     |    ProductName   |    Description   |");
				int totalprice = 0;
				while (rs.next()) {
					System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t\t" + rs.getInt(3) + "\t\t\t" + rs.getString(4) + "\t\t\t" + rs.getString(5));
					totalprice = rs.getInt(2);
			     }
				System.out.println("Enter Quantity");
				int Quantity=sc.nextInt();

				 System.out.println("Total order Price: " + totalprice * Quantity); 
				 System.out.println("\t\t\t\t --ThankYou For Shopping With Us--");

			}if (pr == 2){
				List.Listing(userid);
				
			}if (pr == 3) {
				homePage.homepage();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		

	}


