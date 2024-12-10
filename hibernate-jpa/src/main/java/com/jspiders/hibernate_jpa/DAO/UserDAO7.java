package com.jspiders.hibernate_jpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernate_jpa.dto.DTO;

public class UserDAO7 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static Query query;
	
	public static void openConnection() {
		entityManagerFactory =Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();

	}
	public static void closeConnection() {
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(entityManager != null)
			entityManager.close();
		
	}
	
	public static void main(String[] args) {
		
		openConnection();
		query=entityManager.createQuery("SELECT users FROM DTO users WHERE name=?1 AND id=?2");
		query.setParameter(1,"sonu");
		query.setParameter(2,1);
		DTO user=(DTO) query.getSingleResult();
		if(user != null)
			System.out.println(user);
		else
			System.out.println("user not found");
		closeConnection();
	}

}
