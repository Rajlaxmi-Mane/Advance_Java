package com.jspiders.hibernate_jpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.DTO;

public class UserDAO2 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void openConnection() {
		entityManagerFactory =Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
	}
	
	public static void closeConnecton() {
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(entityManager != null)
			entityManager.close();
	}
	
	public static void main(String[] args) {
		
		openConnection();
		
		DTO users=entityManager.find(DTO.class, 3);
		
		if(users != null)
			System.out.println(users);
		else
			System.out.println("user not found");
		
		closeConnecton();
	}

}
