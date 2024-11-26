package com.jspiders.serialization;

import java.io.IOException;

import com.jspiders.entity.Messanger2;

public class MessangerMain2 {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Messanger2 messanger=new Messanger2();
		
		messanger.send("hiii, how are you");
		
		System.out.println(messanger.receive());
	}

}
