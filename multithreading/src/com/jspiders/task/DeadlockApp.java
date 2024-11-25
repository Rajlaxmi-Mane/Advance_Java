package com.jspiders.task;

import com.jspiders.resource.ResourceDeadlock;
import com.jspiders.thread.DeadlockThread1;
import com.jspiders.thread.DeadlockThread2;

public class DeadlockApp {
	
	public static void main(String[] args) throws InterruptedException {
		
		ResourceDeadlock rd1=new ResourceDeadlock();
		ResourceDeadlock rd2=new ResourceDeadlock();
		
		DeadlockThread1 dt1=new DeadlockThread1(rd1, rd2);
		DeadlockThread2 dt2= new DeadlockThread2(rd1, rd2);
		
		dt1.start();
		dt2.start();
	}

}
