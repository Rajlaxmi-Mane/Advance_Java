package com.jspiders.filehandling;

import java.io.File;

public class DeleteFile {
	
	public static void main(String[] args) {
		
		File file =new File("demo.txt");
		
		if(file.exists()) {
			if(file.delete())
				System.out.println("file is deleted successfully");
			else
				System.out.println("something went wrong");
		}else {
			System.out.println("file does not exists");
		}
		
	}

}
