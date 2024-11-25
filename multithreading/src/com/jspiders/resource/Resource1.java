package com.jspiders.resource;

public class Resource1 {
	private int cnt=0;
	synchronized public void increment() {
		cnt++;
	}
	public int getCount() {
		return cnt;
	}

}
