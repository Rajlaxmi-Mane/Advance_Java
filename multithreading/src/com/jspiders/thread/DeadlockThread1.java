package com.jspiders.thread;

import com.jspiders.resource.ResourceDeadlock;

public class DeadlockThread1 extends Thread {
	
	ResourceDeadlock res1;
	ResourceDeadlock res2;
	
	public DeadlockThread1(ResourceDeadlock res1, ResourceDeadlock res2) {
		super();
		this.res1 = res1;
		this.res2 = res2;
	}

	@Override
	public void run() {
		synchronized (res1) {
			System.out.println("thread 1 apllied lock on resource 1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (res2) {
				System.out.println("thread1 trying to apllly lock on resource 2");
			}
		}
	}

}
