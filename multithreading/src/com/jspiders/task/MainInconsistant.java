package com.jspiders.task;

import com.jspiders.resource.Resource1;
import com.jspiders.thread.InconsitantThread1;

public class MainInconsistant {
	
	public static void main(String[] args) throws InterruptedException {
		Resource1 re=new Resource1();
		
		
	InconsitantThread1 t1=	new InconsitantThread1(re);
	InconsitantThread1 t2=	new InconsitantThread1(re);
	t1.start();
	t2.start();
	
	Thread.sleep(1000);
		
		System.out.println(re.getCount());
		
	}

}
