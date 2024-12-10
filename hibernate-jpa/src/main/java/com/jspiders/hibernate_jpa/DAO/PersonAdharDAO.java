package com.jspiders.hibernate_jpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.Aadhar;
import com.jspiders.hibernate_jpa.dto.Person;

public class PersonAdharDAO {
	
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
		
		Aadhar aadhar=new Aadhar();
		aadhar.setAadharNo(332211445566l);
		aadhar.setAddress("Pune");
		Person person=new Person();
		person.setName("Manu");
		person.setEmail("manu@gmail.com");
		person.setAadhar(aadhar);
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(aadhar);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		
		closeConnection();
	}

}
