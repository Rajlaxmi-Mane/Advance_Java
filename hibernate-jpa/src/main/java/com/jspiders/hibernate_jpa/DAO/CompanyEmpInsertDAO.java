package com.jspiders.hibernate_jpa.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.Company;
import com.jspiders.hibernate_jpa.dto.Employee;

public class CompanyEmpInsertDAO {
	
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
		
		Employee employee=new Employee();
		employee.setName("Vira");
		employee.setEmail("vira@gmail.com");
		employee.setMobile(1122334455l);
		employee.setSalary(450000.25f);
		
		Employee employee1=new Employee();
		employee1.setName("Sonu");
		employee1.setEmail("sonu@gmail.com");
		employee1.setMobile(1122334456l);
		employee1.setSalary(450000.25f);
		
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(employee);
		employees.add(employee1);
		
		Company company=new Company();
		company.setName("TCS");
		company.setLocation("Pune");
		company.setEmploayees(employees);
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityManager.persist(employee1);
		entityTransaction.commit();
		
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
		
		closeConnection();
	}

}
