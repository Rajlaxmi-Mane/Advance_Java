package com.jspiders.thread;

import com.jspiders.resource.Product;

public class Consumer extends Thread{
	
	Product product;

	public Consumer(Product product) {
		super();
		this.product = product;
	}
	
	@Override
	public void run() {
		try {
			product.order();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
