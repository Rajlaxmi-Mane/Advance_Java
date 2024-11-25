package com.jspiders.filehandling;

import java.io.File;

public class FetchPreperties {
	
	public static void main(String[] args) {
		
		File file =new File("demo.txt");
		
		if(file.exists()) {
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getName());
			System.out.println(file.length());
			
			
			// both the method will set file in read only mode
			file.setReadOnly();
			file.setWritable(false);
			
			if(file.canExecute())
				System.out.println("file is executable");
			else
				System.out.println("file is not executable");
			
			if(file.canWrite())
				System.out.println("file is writable");
			else
				System.out.println("file is not writable");
			
			
			if(file.canRead())
				System.out.println("file is readable");
			else
				System.out.println("file is not readable");
			
		}else
			System.out.println("file does not exists");
	}

}
