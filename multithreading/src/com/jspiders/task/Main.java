package com.jspiders.task;

import com.jspiders.thread.Thread2;

public class Main {
	
	public static void main(String[] args) {
		new Thread(new Thread2()).start();
	}

}
