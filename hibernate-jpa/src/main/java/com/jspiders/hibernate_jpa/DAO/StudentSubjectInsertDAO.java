package com.jspiders.hibernate_jpa.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.Student;
import com.jspiders.hibernate_jpa.dto.Subject;

public class StudentSubjectInsertDAO {
	
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
		Student student=new Student();
		List<Subject> subjects=new ArrayList<>();
		
		Subject subject=new Subject();
		subject.setName("JAVA");
		subject.setFees(20000);
		
		Subject subject1=new Subject();
		subject1.setName("SQL");
		subject1.setFees(10000);
		
		subjects.add(subject);
		subjects.add(subject1);
		
		student.setName("Nilu");
		student.setContact(1122334455);
		student.setSubjects(subjects);
		
		openConnection();
		
		entityTransaction.begin();
		
		entityManager.persist(subject);
		entityManager.persist(subject1);
		entityManager.persist(student);
		
		entityTransaction.commit();
		closeConnection();
	}

}
