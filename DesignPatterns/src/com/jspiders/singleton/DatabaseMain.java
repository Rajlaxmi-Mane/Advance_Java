package com.jspiders.singleton;

public class DatabaseMain {

	
	public static void main(String[] args) {
		DatabaseConnection connection=DatabaseConnection.getConnection();
		DatabaseConnection connection2=DatabaseConnection.getConnection();
		DatabaseConnection connection3=DatabaseConnection.getConnection();
		
		System.out.println(connection);
		System.out.println(connection2);
		System.out.println(connection);
	}
}
