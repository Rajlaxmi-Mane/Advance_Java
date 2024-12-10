package com.jspiders.hibernate_jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernate_jpa.dto.Employee;

public class CompanyEmpUpdateDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Query query;
	
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
		
		query=entityManager.createQuery("SELECT employees from Employee employees ");
		@SuppressWarnings("unchecked")
		List<Employee> employees= query.getResultList();
		for (Employee employee : employees) {
			entityTransaction.begin();
			employee.setSalary(employee.getSalary()*(20/100));
			entityManager.persist(employee);
			entityTransaction.commit();
		}
		
		closeConnection();
	}

}
