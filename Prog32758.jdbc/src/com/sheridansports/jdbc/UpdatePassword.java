package com.sheridansports.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePassword {
	
public static void main(String [] args) {
	DBConnect Connection1 = new DBConnect();
	PreparedStatement ps = null;
	
	Scanner inputObj = new Scanner(System.in);
	System.out.print("Password Changer\n\nEnter username: ");
	String username = inputObj.next();
	System.out.print("Enter the new password: ");
	String password = inputObj.next();
	String sqlQuery = "UPDATE User SET Password = ? WHERE Username = ?";
	
	
	try {
		Connection1.createConnection();
		ps = Connection1.conn.prepareStatement(sqlQuery);
		ps.setString(1, password);
		ps.setString(2, username);
		System.out.println(ps);
		int result = ps.executeUpdate();
		System.out.println("result is: "+result);
		
		// Connection1.closeJDBCObjects();
		
		
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	inputObj.close();
}
	
}
