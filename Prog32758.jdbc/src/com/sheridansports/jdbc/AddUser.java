package com.sheridansports.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddUser {
	
public static void main(String [] args) {
	DBConnect Connection1 = new DBConnect();
	PreparedStatement ps = null;
	
	Scanner inputObj = new Scanner(System.in);
	
	System.out.print("Add User\n\nEnter firstname: ");
	String firstname = inputObj.next();
	System.out.print("Enter the new lastname: ");
	String lastname = inputObj.next();
	System.out.print("Email address: ");
	String email = inputObj.next();
	System.out.print("Username: ");
	String username = inputObj.next();
	System.out.print("Password: ");
	String password =  inputObj.next();
	System.out.print("Role: ");
	String role = inputObj.next();
	
	
	String sqlQuery = "INSERT INTO User(FirstName, LastName, Email, Username, Password, RoleName) Values (?, ?, ?, ?, ?, ? )";
	
	
	try {
		Connection1.createConnection();
		ps = Connection1.conn.prepareStatement(sqlQuery);
		ps.setString(1, firstname);
		ps.setString(2, lastname);
		ps.setString(3, email);
		ps.setString(4, username);
		ps.setString(5, password);
		ps.setString(6, role);
		System.out.println(ps);
		int result = ps.executeUpdate();
		System.out.println("Result: "+result);
		
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
