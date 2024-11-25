package com.jspiders.contact_manager;
import com.jspiders.contact_manager.business.*;

import java.util.Scanner;

public class Main {

	private static Business business=new BusinessImpl();
	
	public static void main(String[] args) {

		boolean run=true;
		Scanner scanner =new Scanner(System.in);
		while(run) {
			System.out.println();
			System.out.println("enter 1 to create contact ");
			System.out.println("enter 2 to delete contact ");
			System.out.println("enter 3 to update contact ");
			System.out.println("enter 4 to search by first name contact ");
			System.out.println("enter 5 to search by last name contact ");
			System.out.println("enter 6 to get all contacts");
			System.out.println("enter 7 to search by any pattern");
			System.out.println("enter 8 to exit");
			
			System.out.println("enter your choice");
			int choice = scanner.nextInt();			
			switch(choice) {
			case 1:
				business.addContact();
				break;
			case 2:
				business.deleteContact();
				break;
			case 3:
				business.updateContact();
				break;
			case 4:
				business.searchByFirstName();
				break;
			case 5:
				business.searchByLastName();
				break;
			case 6:
				business.getContacts();
				break;
			case 7:
				business.search();
				break;
			case 8:
				run=false;
				System.out.println("!!!! Thank You, See you soon !!!!!");
				break;
			default:
				System.out.println("!!!!!!!!!!! enter valid choice !!!!!!!!!!!");
			}
		}
		
		scanner.close();
		
	}

}
