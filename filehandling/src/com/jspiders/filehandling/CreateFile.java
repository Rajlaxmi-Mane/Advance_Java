package com.jspiders.filehandling;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	
	public static void main(String[] args) throws IOException {
		
		File file=new File("demo.txt");  // the file will be created in default location 
		
		boolean created = file.createNewFile();
		
		if(created)
			System.out.println("file is created successfully");
		else
			System.out.println("file already exists");
	}

}
