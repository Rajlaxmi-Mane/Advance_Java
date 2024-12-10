package com.jspiders.hibernate_jpa.birectionalDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.DNAReport;
import com.jspiders.hibernate_jpa.dto.Patient;

public class PatientDNAReportDeleteDAO {
	
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
		
		Patient patient=  entityManager.find(Patient.class, 1);
		
		if(patient != null) {
			entityTransaction.begin();
			entityManager.remove(patient);
			entityTransaction.commit();
			
			DNAReport dnaReport=patient.getDnaReport();
			entityTransaction.begin();
			entityManager.refresh(dnaReport);
			entityTransaction.commit();
			
		}else
			System.out.println("Patient Does Not Exist.");
		
		closeConnection();
		
	}

}
