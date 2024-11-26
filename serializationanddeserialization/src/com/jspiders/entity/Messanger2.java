package com.jspiders.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Messanger2 {
	
	private File file=new File("demo.txt");
	private FileOutputStream fileOutputStream;
	private FileInputStream fileInputStream;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	
	public void send(String message) throws IOException {
		fileOutputStream=new FileOutputStream(file);
		objectOutputStream=new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(message);
		System.out.println("message send successfully");
	}
	
	public String receive() throws IOException, ClassNotFoundException {
		fileInputStream=new FileInputStream(file);
		objectInputStream=new ObjectInputStream(fileInputStream);
		return (String)objectInputStream.readObject();
	}

}
