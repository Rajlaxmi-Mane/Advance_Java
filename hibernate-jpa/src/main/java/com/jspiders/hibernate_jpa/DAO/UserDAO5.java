package com.jspiders.hibernate_jpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernate_jpa.dto.DTO;

public class UserDAO5 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	// Query is an interface
	private static Query query;
	
	public static void openConnection() {
		
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();	
	}
	
	public static void closeConnection() {
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(entityManager != null)
			entityManager.close();
	}
	
	// JPQL is used to execute custom queries
	
	public static void main(String[] args) {
		
		openConnection();
		query=entityManager.createQuery("SELECT users FROM DTO users");
		
		@SuppressWarnings("unchecked")
		java.util.List<DTO> users=query.getResultList();
		if(users.size() > 0)
			System.out.println(users);
		else
			System.out.println("users not found");
		closeConnection();
	}

}
