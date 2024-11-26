package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCFetchPreparedStat {
	
	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	
	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");
	}
	
	private static void closeConnection() throws SQLException {
		if(preparedStatement != null)
			preparedStatement.close();
		if(connection != null)
			connection.close();
		if(driver != null)
			DriverManager.deregisterDriver(driver);
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("enter id");
		int id=scanner.nextInt();
		
		try {
			openConnection();
			query="SELECT id , name FROM users where id=?";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1,id);
			
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				System.out.println("----------------------------------------------------");
				System.out.println("|        id                |          name          |");
				System.out.println("----------------------------------------------------");
				System.out.println("|        "+resultSet.getInt("id")+"               |         "+resultSet.getString("name") +"         |");
				System.out.println("----------------------------------------------------");
				
			}else
				System.out.println("invalid id");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
