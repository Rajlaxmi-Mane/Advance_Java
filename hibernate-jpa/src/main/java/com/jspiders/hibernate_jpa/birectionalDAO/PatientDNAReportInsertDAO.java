package com.jspiders.hibernate_jpa.birectionalDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.DNAReport;
import com.jspiders.hibernate_jpa.dto.Patient;

public class PatientDNAReportInsertDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
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
		
		Patient patient=new Patient();
		patient.setName("sonu");
		patient.setContact(1122334455l);
		
		DNAReport dnaReport=new DNAReport();
		dnaReport.setContent("FIT");
		dnaReport.setPatient(patient);
		
		patient.setDnaReport(dnaReport);
		
		openConnection();
		
		entityTransaction.begin();
		entityManager.persist(dnaReport);
		entityManager.persist(patient);
		entityTransaction.commit();
		
		closeConnection();
	}

}
