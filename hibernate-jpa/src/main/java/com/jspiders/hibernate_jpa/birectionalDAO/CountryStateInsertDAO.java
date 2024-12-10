package com.jspiders.hibernate_jpa.birectionalDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_jpa.dto.Country;
import com.jspiders.hibernate_jpa.dto.State;

public class CountryStateInsertDAO {
	
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
				entityTransaction.commit();
		}
	}
	
	public static void main(String[] args) {
		
		Country country=new Country();
		country.setName("Japan");
		
		State state=new State();
		state.setName("Tokiyo");
		state.setCountry(country);
		
		State state1=new State();
		state1.setName("Shikoku");
		state1.setCountry(country);
		
		List<State> states=new ArrayList<State>();
		states.add(state);
		states.add(state1);
		
		country.setStates(states);
		
		openConnection();
		
		entityTransaction.begin();
		
		entityManager.persist(state);
		entityManager.persist(state1);
		entityManager.persist(country);

		entityTransaction.commit();
		
		closeConnection();
		
	}

}
