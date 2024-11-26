package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsertPreparedStmt {
	
	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
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
		System.out.println("enter name");
		String name=scanner.next();
		
		try {
			openConnection();
			query="INSERT INTO users  VALUES(?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			
			int rows=preparedStatement.executeUpdate();
			
			System.out.println(rows+" row(s) affected");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
