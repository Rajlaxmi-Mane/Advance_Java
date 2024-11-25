package com.jspiders.thread;

import com.jspiders.task.Task;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		long s=System.currentTimeMillis();
		Task t1=new Task();
		Task t2=new Task();
		t1.start();
		t2.start();
		long e=System.currentTimeMillis();
		Thread.sleep(10000);
		System.out.println(e-s);
	}

}
