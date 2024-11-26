package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect {
	
	private static Driver driver;
	private static Statement statement;
	private static Connection connection;
	private static ResultSet resultSet;
	private static String query;
	
	public static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&&password=root");
		}
	
	public static void closeConnection () throws SQLException {
		if(statement != null)
			statement.close();
		if(connection != null)
			connection.close();
		if(driver != null)
			DriverManager.deregisterDriver(driver);
			
	}

}
