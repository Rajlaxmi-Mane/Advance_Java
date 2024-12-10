package com.jspiders.hibernate_jpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.DTO;

public class UserDAO4 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	//OPEN CONNECTION : INITIALIZING THE OBJECTS
	
	public static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	
	//CLOSING THE CONNECTIONS
	
	public static void closeConnection() {
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(entityManager != null)
			entityManager.close();
		if(entityTransaction != null) {
			if(entityTransaction.isActive())
				entityTransaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		
		
		openConnection();
		DTO user=entityManager.find(DTO.class,2);
		if(user != null) {
			user.setName("Arvi");
			entityTransaction.begin();
			entityManager.persist(user);
			entityTransaction.commit();
		}else
			System.out.println("user not found");
		
		closeConnection();
	}

}
