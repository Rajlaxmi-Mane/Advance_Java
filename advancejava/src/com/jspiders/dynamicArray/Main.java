package com.jspiders.dynamicArray;

public class Main {
	public static void main(String[] args) {
		DynamicArray arr = new DynamicArray();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
		arr.add(50);
		arr.add(60);
//		System.out.println(arr.remove());
//		System.out.println(arr.remove());
		
		arr.remove(1);
		arr.remove(0);

		arr.print();
		System.out.println(arr.get(0));
		arr.put(2,30);
		arr.print();
		arr.put(0, 10);
		arr.print();
		arr.put(3, 50);
		arr.print();
	}

}
