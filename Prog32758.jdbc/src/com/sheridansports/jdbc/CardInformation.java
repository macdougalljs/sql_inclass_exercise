package com.sheridansports.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CardInformation {
	// declare required objects
	
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
		

public static void main(String [] args)  {
	String connURL = "jdbc:mysql://localhost/sheridansports";  // this changes depending on location
	
	System.out.println("Please enter the card type:");
	Scanner sc = new Scanner(System.in);
	String cardtype = sc.next();
	String myQuery = "SELECT cardnumber, cardholder, expirymonth, expiryyear, username"
			+" FROM Card INNER JOIN User on user.userid = card.userid WHERE cardtype = ?";

	
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		conn = DriverManager.getConnection(connURL,"root","root");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		ps = conn.prepareStatement(myQuery);
		ps.setString(1, cardtype);
		rs = ps.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	System.out.println("List of "+cardtype+" card holders:");
	try {
		while(rs.next()) {
			System.out.printf("\n%15s%20s","Card holder:",rs.getString(2));	
			System.out.printf("\n%15s%20s","Card number:",rs.getString(1));
			System.out.printf("\n%15s%20s","Expiry Date:",rs.getString(3)+"/"+rs.getString(4));
			System.out.printf("\n%15s%20s\n","Username:",rs.getString("username"));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sc.close();
	
}
}
