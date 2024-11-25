package com.jspiders.resource;

public class Product {
	
	private boolean available;
	
	synchronized public void order() throws InterruptedException {
		if(available) {
			System.out.println("product is available");
			System.out.println("order is placed");
		}else {
			System.out.println("product is currently unavailable");
			wait();
			if(available) {
				System.out.println("product is available now ");
				System.out.println("You can place your order");
			}
		}
	}
	
	synchronized public void manifacture() {
		available=true;
		notifyAll();
	}

}
