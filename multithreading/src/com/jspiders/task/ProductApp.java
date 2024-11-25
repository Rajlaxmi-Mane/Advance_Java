package com.jspiders.task;

import com.jspiders.resource.Product;
import com.jspiders.thread.Consumer;
import com.jspiders.thread.Manifacture;

public class ProductApp {
	
	public static void main(String[] args) throws InterruptedException {
		Product product=new Product();
		
		new Consumer(product).start();
		Thread.sleep(1000);
		new Manifacture(product).start();
	}

}
