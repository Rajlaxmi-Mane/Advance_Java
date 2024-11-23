package com.jspiders.dynamicArray;

import java.util.*;

public class Anagram {

	public static boolean check(String s1, String s2) {
		if (s1.length() == s2.length()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Set convert(String s) {
		Set s1=new HashSet();
		for(int i=0;i<s.length();i++) {
			s1.add(s.charAt(i));
		}
		return s1;
	}

	public static void main(String[] args) {

		String str1 = "abc";
		String str2 = "abcc";
		boolean ana=false;

		Set l = convert(str1);
		Set l2=convert(str2);

		boolean flag = check(str1, str2);

		if (flag) {
			ana=l.containsAll(l2);
		}
		System.out.println(ana);
	}
}
