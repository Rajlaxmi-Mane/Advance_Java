package com.jspiders.contact_manager.data;

import com.jspiders.contact_manager.entity.Contact;

public class DataImpl implements Data {

	private Contact[] contacts = new Contact[10];
	private int capacity = contacts.length;
	private int index = 0;

	@Override
	public void addContact(Contact contact) {

		if (index == capacity - 1) {
			Contact[] temp = new Contact[capacity * 2];
			for (int i = 0; i < index; i++) {
				temp[i] = contacts[i];
			}
			contacts = temp;
			capacity = contacts.length;
		}

		contacts[index++] = contact;
		System.out.println("!!!!!!!!! Contact added successfullyy !!!!!!!!");

	}

	@Override
	public void deleteContact(int id) {
		boolean flag = false;
		for (int i = 0; i < index; i++) {
			if (contacts[i].getId() == id) {
				flag = true;
				normalize(i);
				break;
			}
		}

		if (flag)
			System.out.println("!!!!!!! Contact deleted successfully !!!!!!");
		else {
			System.out.println("contact not found");
		}

	}

	@Override
	public Contact[] getAllContacts() {
		Contact[] temp = new Contact[index];
		for (int i = 0; i < index; i++) {
			temp[i] = contacts[i];
		}
		return temp;

	}

	@Override
	public void searchByfName(String fName) {
		boolean flag = false;
		for (int i = 0; i < index; i++) {
			if (contacts[i].getFirstName().equals(fName)) {
				flag = true;
				System.out.println(contacts[i]);
			}
		}
		if (!flag)
			System.out.println("contact not found");

	}

	@Override
	public void searchByLastName(String lastName) {
		boolean flag = false;
		for (int i = 0; i < index; i++) {
			if (contacts[i].getLastName().equals(lastName)) {
				flag = true;
				System.out.println(contacts[i]);
			}
		}
		if (!flag)
			System.out.println("contact not found");

	}

	public void normalize(int i) {
		if (i == index - 1) {
			contacts[i] = null;
			index--;
		} else {
			for (int j = i; j < index - 1; j++) {
				contacts[i] = contacts[i + 1];
			}
			contacts[index - 1] = null;
			index--;
		}
	}

	@Override
	public boolean checkExistance(long mobile, long work, String email) {
		for (int i = 0; i < index; i++) {
			if (contacts[i].getMobile() == mobile || contacts[i].getWork() == work
					|| contacts[i].getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void search(String data) {
		boolean flag = false;
		for (int i = 0; i < index; i++) {
			if (contacts[i].getEmail().contains(data) || contacts[i].getFirstName().contains(data)
					|| contacts[i].getLastName().contains(data)
					|| String.valueOf(contacts[i].getMobile()).contains(data)
					|| String.valueOf(contacts[i].getWork()).contains(data)) {
				flag = true;
				System.out.println(contacts[i]);
			}
		}
		if (!flag) {
			System.out.println("contact not found for given pattern ....");
		}
	}

}
