package com.jspiders.deserialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.stream.FileImageInputStream;

import com.jspiders.entity.Messanger;

public class Receiever {
	
	public static void main(String[] args) {
		
		File file=new File("demo.txt");
		
		FileInputStream fileInputStream=null;
		ObjectInputStream objectInputStream=null;
		
		try {
			fileInputStream =new FileInputStream(file);
			objectInputStream=new ObjectInputStream(fileInputStream);
			
			Messanger messanger=(Messanger) objectInputStream.readObject();
			
			System.out.println(messanger);
		}catch(IOException  | ClassNotFoundException e2) {
			e2.printStackTrace();
		}finally {
			try {
				fileInputStream.close();
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
