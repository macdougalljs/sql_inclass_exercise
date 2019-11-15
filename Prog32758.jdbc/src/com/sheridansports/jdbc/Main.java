package com.sheridansports.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		// Statement  stmt = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		System.out.println("This program will display user information based on the username "
				+ "and password entered:");
		
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
	    String password = sc.nextLine();
		
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver).newInstance();
		
		String connURL="jdbc:mysql://localhost/sheridansports";
		
		try {
			 conn = DriverManager.getConnection(connURL, "root", "root");
			//System.out.println("Connection to the DB was established successfully!");
		//	String sqlQuery1 ="select * from user where username ='" + username + "' and password='" + password +"'";
			String sqlQuery1 ="select * from user where username = ? and password = ?" ;
			// String sqlQuery2="select * from user where rolename ='sales'";
			// stmt = conn.createStatement();
			ps = conn.prepareStatement(sqlQuery1);
			ps.setString(1, username);
			ps.setString(2, password);
			// rs = stmt.executeQuery(sqlQuery1);
			rs = ps.executeQuery();
			while (rs.next()) {
			   System.out.println(rs.getInt(1) + " " + rs.getString("firstname") + " " + rs.getString(3) );
		} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		finally {
			conn.close();
			// stmt.close();
			ps.close();
			rs.close();
		}
				


	}

}
