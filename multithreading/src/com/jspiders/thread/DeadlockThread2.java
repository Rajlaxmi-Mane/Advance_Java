package com.jspiders.thread;

import com.jspiders.resource.ResourceDeadlock;

public class DeadlockThread2  extends Thread{
	
	ResourceDeadlock res1;
	ResourceDeadlock res2;
	
	public DeadlockThread2(ResourceDeadlock res1, ResourceDeadlock res2) {
		super();
		this.res1 = res1;
		this.res2 = res2;
	}

	@Override
	public void run() {
		synchronized (res2) {
			System.out.println("thread 2 apllied lock on resource 2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (res1) {
				System.out.println("thread 2 trying to apllly lock on resource 1");
			}
		}
	}

}
