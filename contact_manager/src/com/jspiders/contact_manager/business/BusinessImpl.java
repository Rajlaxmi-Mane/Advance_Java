package com.jspiders.contact_manager.business;
import java.util.*;

import com.jspiders.contact_manager.data.*;
import com.jspiders.contact_manager.entity.Contact;



public class BusinessImpl implements Business{
	
	private int id;
	private Scanner scanner=new Scanner(System.in);
	private static Data data=new DataImpl();
	
	@Override
	public void addContact() {
		System.out.println("enter first name");
		String firstName=scanner.next();
		System.out.println("enter last name");
		String lastName=scanner.next();
		System.out.println("enter mobile");
		long mobile=scanner.nextLong();
		System.out.println("enter work contact");
		long work =scanner.nextLong();
		System.out.println("enter email");
		String email=scanner.next();
		
		if(data.checkExistance(mobile, work, email)) {
			System.out.println("contact is already exist !!!!!!");
		}else {
		Contact contact=new Contact(id(), firstName, lastName, mobile, work, email);
		data.addContact(contact);
		}
	}
	
	

	@Override
	public void deleteContact() {
		System.out.println("Enter id to be deleted......");
		int id=scanner.nextInt();
		data.deleteContact(id);
		
	}

	@Override
	public void updateContact() {
		System.out.println("enter id of contact that to be updated ....");
		int id=scanner.nextInt();	
		Contact[] contacts=data.getAllContacts();
		Contact contact=null;
		boolean flag=false;
		
		for(int i=0;i<contacts.length;i++) {
			if(contacts[i].getId()==id) {
				flag=true;
				contact=contacts[i];
				break;
			}
			
		}
		if(flag) {
			System.out.println("enter  firstname");
			String firstName=scanner.next();
			System.out.println("enter  last name");
			String lastName=scanner.next();
			System.out.println("enter  mobile");
			long mobile=scanner.nextLong();
			System.out.println("enter  work contact");
			long work =scanner.nextLong();
			System.out.println("enter  email");
			String email=scanner.next();
			
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
			contact.setMobile(mobile);
			contact.setWork(work);
			contact.setEmail(email);
			
			System.out.println("....... contact is updated successfully ......");
			
		}else {
			System.out.println("contact not found .....");
		}
		
	}

	@Override
	public void searchByFirstName() {
		System.out.println("enter first name");
		String fName=scanner.next();
		data.searchByfName(fName);
	}

	@Override
	public void searchByLastName() {
		System.out.println("enter last name");
		String lastName=scanner.next();
		data.searchByLastName(lastName);
		
	}

	@Override
	public void getContacts() {
		Contact[] contacts=data.getAllContacts();
		for(int i=0;i<contacts.length;i++) {
			System.out.println(contacts[i]);
		}
	}
	
	@Override
	public void search() {
		System.out.println("enter pattern");
		String template=scanner.next();
		data.search(template);
	}

	private int id() {
		return ++id;
	}





}
