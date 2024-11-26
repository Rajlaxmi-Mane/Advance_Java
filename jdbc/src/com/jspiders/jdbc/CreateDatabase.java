
package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateDatabase {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		// load the drivers 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		// register the driver
		Driver  driver =new Driver();
		
		DriverManager.registerDriver(driver);
		
		// get the connection 
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=root");
		
		// create the statement 
		Statement statement=connection.createStatement();
		
		//execute the statement
		statement.execute("CREATE DATABASE qspiders");
		
		// process the result 
		System.out.println("Database creates");
		
		//close connection
		
		statement.close();
		connection.close();
		
		// de-register the driver
		DriverManager.deregisterDriver(driver);
		
		
	}

}
