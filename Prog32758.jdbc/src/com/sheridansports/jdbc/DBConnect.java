package com.sheridansports.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnect {
	private static final String connURL ="jdbc:mysql://localhost/sheridansports";
	private static final String username = "root";
	private static final String password = "root";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	public static String getConnurl() {
		return connURL;
	}
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	
	public Connection createConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection(connURL, username, password);
		return conn;
		
		
	}
	
	public void closeJDBCObjects() throws SQLException {
		conn.close();
		stmt.close();
		rs.close();
		
	}
}
