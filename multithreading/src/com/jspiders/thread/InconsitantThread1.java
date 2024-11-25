package com.jspiders.thread;

import com.jspiders.resource.Resource1;

public class InconsitantThread1 extends Thread{
	
	Resource1 res;

	public InconsitantThread1(Resource1 res) {
		super();
		this.res = res;
	}
	

	@Override
	public void run() {
		for(int i=1;i<=100000;i++) {
			res.increment();
		}
	}

}
