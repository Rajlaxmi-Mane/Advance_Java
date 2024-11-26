package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class JDBCCall {
	private static Driver driver;
	private static Connection connection;
	private static java.sql.CallableStatement callableStatement;
	private static ResultSet resultSet;
	private static String query;
	
	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");
	}
	
	private static void closeConnection() throws SQLException {
		if(callableStatement != null)
			callableStatement.close();
		if(connection != null)
			connection.close();
		if(driver != null)
			DriverManager.deregisterDriver(driver);
	}
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			query="CALL sort";
			callableStatement=connection.prepareCall(query);
			callableStatement.execute();
			resultSet=callableStatement.getResultSet();
			
			while(resultSet.next())
				System.out.println(resultSet.getString("name"));
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}


}
