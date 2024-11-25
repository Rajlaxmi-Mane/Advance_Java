package com.jspiders.contact_manager.data;

import com.jspiders.contact_manager.entity.Contact;

public interface Data {
	
	void addContact(Contact contact);
	
	void deleteContact(int id);
	
	Contact[] getAllContacts();
	
	void searchByfName(String fname);
	
	void searchByLastName(String LastName);
	
	boolean checkExistance(long mobile,long work,String email);
	
	void search(String data);
}
