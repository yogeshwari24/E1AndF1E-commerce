package com.mini.project.java;

import java.sql.SQLException;
import java.util.Scanner;

public class homePage {
	
	public static void homepage() {
		System.out.println("Press 1 For : Register");
		System.out.println("Press 2 For : Login");
		System.out.println("Press 3 For : Admin Login");
		
		Scanner sc=new Scanner(System.in);
		int id = sc.nextInt();
		if (id == 1) {
			System.out.println("Enter Name:");
			String name=sc.next();

			System.out.println("Enter Email id: ");
			String emailID=sc.next();

			System.out.println("Enter Mobile Number: ");
			String MobileNumber=sc.next();

			System.out.println("Enter Password:");
			String password=sc.next();
			
			System.out.println("Enter UserId:");
			String UserId=sc.next();

		
		if (id == 1) {
				UserRegistration.insertUserData(name, password, MobileNumber, emailID, UserId);
			}
		} else if (id == 2) {
			Login.Login();
		} else if (id == 3) {
			Admin.adminlogin();
		} else {
			System.out.println("Wrong Choice Redirect to HOMEPAGE");
			homepage();
		}
	}
	
	public static void main(String[] args) throws SQLException{
		System.out.println("     \t\t\t\t\t\t         *****||SHOPPINGADDA||***** "
	    		+ ""
	    		+ ""
	    		+ "" 
	    		+ "\n\n *--WELCOME TO SHOPPINGADDA--*");

		homepage();
		}
	}


