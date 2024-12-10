package com.jspiders.hibernate_jpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.Aadhar;
import com.jspiders.hibernate_jpa.dto.Person;

public class PersonAadharUpdateDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
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
		
		Person person= entityManager.find(Person.class,2);
		if(person != null) {
			Aadhar aadhar=person.getAadhar();
			person.setName("mansvi");
			aadhar.setAddress("Maharashtra");
			entityTransaction.begin();
			entityManager.persist(person);
			entityManager.persist(aadhar);
			entityTransaction.commit();
		}else
			System.out.println("person not found");
		
		closeConnection();
	}


}
