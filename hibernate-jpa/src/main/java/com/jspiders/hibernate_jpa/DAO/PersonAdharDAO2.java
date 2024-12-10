package com.jspiders.hibernate_jpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.Person;

public class PersonAdharDAO2 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
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
	
	public static void main(String[] args) {
		openConnection();

		Person person=entityManager.find(Person.class, 1);
		
		if(person != null)
			System.out.println(person);
		else
			System.out.println("user not found");
		closeConnection();
	}

}
