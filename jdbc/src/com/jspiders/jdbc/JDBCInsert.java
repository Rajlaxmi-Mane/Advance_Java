package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCInsert {
	
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders?user=root&password=root");
	}
	
	public static void closeConnection() throws SQLException {
		if(statement != null)
			statement.close();
		if(connection != null)
			connection.close();
		if(driver != null)
			DriverManager.deregisterDriver(driver);
	}
	
	
	public static void main(String[] args) throws SQLException {
		try {
			openConnection();
			statement=connection.createStatement();
			query="INSERT INTO users VALUES(11,'aradhya')";
			statement.execute(query);
			System.out.println("record is inserted");
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}

}
