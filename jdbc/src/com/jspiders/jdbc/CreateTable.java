package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class CreateTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Driver driver=new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders?user=root&password=root");
		
		java.sql.Statement statement=connection.createStatement();
		
		
		statement.execute("CREATE TABLE users (id int primary key,name varchar(20))");
		
		System.out.println("table craeted");
		
		statement.close();
		connection.close();
		
	}

}
