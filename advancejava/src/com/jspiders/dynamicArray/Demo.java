package com.jspiders.dynamicArray;

import java.util.*;

public class Demo {

	public static void main(String[] args) {
		String str = "java is a programming language";
		boolean flag=true;

		for (int i = 0; i < str.length(); i++) {
			int cnt = 0;
			char ch = str.charAt(i);
			for(int k=0;k<i;k++) {
				if(ch!=str.charAt(k)) {
					flag=true;
				}else {
					flag=false;
					break;
				}
			}
			if(flag) {
			for (int j = 0; j < str.length(); j++) {
				if (ch == str.charAt(j)) {
					cnt++;
				}
			}
			System.out.println(ch+" "+cnt);
			}

		}

	}

}
