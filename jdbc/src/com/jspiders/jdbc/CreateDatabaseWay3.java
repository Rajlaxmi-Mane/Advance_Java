package com.jspiders.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreateDatabaseWay3 {
	
	private static Driver driver;
	private static Statement statement;
	private static Connection connection;
	private static String query;
	
	public static void openConnection() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		File file=new File("db_props.txt");
		FileReader fileReader=new FileReader(file);
		Properties properties=new Properties();
		properties.load(fileReader);
		
		connection=DriverManager.getConnection(properties.getProperty("url"), properties);
		
	}
	
	public static void closeConnection() throws SQLException {
		
		if(statement != null)
			statement.close();
		if(connection != null)
			connection.close();
		if(driver != null)
			DriverManager.deregisterDriver(driver);
	}
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			statement=connection.createStatement();
			query="CREATE DATABASE DEMO2";
			statement.execute(query);
			System.out.println("database is created");
		} catch (ClassNotFoundException | SQLException | IOException e) {
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
