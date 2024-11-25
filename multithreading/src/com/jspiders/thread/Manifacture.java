package com.jspiders.thread;

import com.jspiders.resource.Product;

public class Manifacture extends Thread{

	Product product;

	public Manifacture(Product product) {
		super();
		this.product = product;
	}
	
	@Override
	public void run() {
		product.manifacture();
	}
}
