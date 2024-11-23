package com.jspiders.dynamicArray;

import java.util.Arrays;

public class DynamicArray {
	private int[] arr = new int[5];
	private int index;
	private int cap = arr.length;

	public void add(int num) {
		if (index == (cap-1)) {
			int[] temp = new int[cap * 2];
			for (int i = 0; i < index; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}

		arr[index++] = num;
	}

//	public int[] delete(int num) {
//		for (int i = 0; i < index; i++) {
//			if (arr[i] == num) {
//				for (int j = i; j < index; j++) {
//					arr[j] = arr[j + 1];
//				}
//			}
//		}
//		index--;
//		return arr;
//	}
	
	public  void remove(int i) {
		if(i>=0 && i<index) {
			for(int in=i;in<index-1;in++) {
				arr[in]=arr[in+1];
			}
			arr[index-1]=0;
			index--;
		}else {
			System.out.println("invalid index");
		}
		
	}

	public int remove() {
		int last = arr[index - 1];
		arr[index-1] = 0;
		index--;
		return last;
	}
	
	public void set(int in,int num) {
		if(in>=0 && in<index) {
			arr[in]=num;
		}
		else{
			System.out.println("invalid index");
		}
	}
	
	public void put(int i,int num) {
		if(i>=0 && i<index) {
			for(int j=index;j>=i;j--) {
				arr[j+1]=arr[j];
			}
			arr[i]=num;
			index++;
		}
		
		
	}
	
	public int get(int i) {
		if(i>=0&&i<index) {
			return arr[i];
		}else {
			return -1;
		}

	}

	public void print() {
		for (int i = 0; i < index; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
