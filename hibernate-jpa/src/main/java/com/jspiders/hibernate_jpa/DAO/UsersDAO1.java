package com.jspiders.hibernate_jpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.DTO;

public class UsersDAO1 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		
	}
	
	private static void closeConnection() {
		
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		
		if(entityManager != null)
			entityManager.close();
		
		if(entityTransaction.isActive()) {
			if(entityTransaction != null)
				entityTransaction.rollback();
		}
			
		
		
	}
	
	public static void main(String[] args) {
		DTO dto=new DTO();
		dto.setName("mahi");
		dto.setEmail("mahi@gmail.com");
		dto.setPassword("mahi@1234");
		openConnection();
	
		entityTransaction.begin();
		entityManager.persist(dto);
		entityTransaction.commit();
		
		closeConnection();
		
	}

}
