package com.jspiders.hibernate_jpa.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.Company;
import com.jspiders.hibernate_jpa.dto.Employee;

public class CompanyEmpRemove {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	
	public static void closeConnection() {
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(entityManager != null )
			entityManager.close();
		if(entityTransaction != null) {
			if(entityTransaction.isActive())
				entityTransaction.rollback();
		}
	}
	
	
	public static void main(String[] args) {
		

		openConnection();
		
		Company company=entityManager.find(Company.class,2);
		if(company != null) {
		List<Employee> employees= company.getEmploayees();
		entityTransaction.begin();
		entityManager.remove(company);
		for (Employee employee : employees) {
			entityManager.remove(employee);
		}
		entityTransaction.commit();
		
		}
		closeConnection();
		
	}


}
