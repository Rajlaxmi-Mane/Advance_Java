package com.jspiders.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jspiders.entity.Messanger;

public class Sender {
	
	public static void main(String[] args) {
		Messanger messanger=new Messanger("hiii How are you");
		
		File file=new File("demo.txt");
		
		FileOutputStream fileOutputStream=null;
		ObjectOutputStream objectOutputStream=null;
		
		try {
			fileOutputStream=new FileOutputStream(file);
			objectOutputStream=new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(messanger);
			System.out.println("data is serialized");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileOutputStream.close();
				objectOutputStream.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
