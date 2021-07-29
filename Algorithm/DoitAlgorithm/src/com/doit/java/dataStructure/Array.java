package com.doit.java.dataStructure;

public class Array {

	public static void main(String[] args) {
		//Array.intArray();
		//Array.cloneArray();
		Array.intArrayInit();
	}

	public static void intArray() {
	//구성요소 5개짜리 int배열 출력
		int[] a = new int[5];
		
		a[1]=37;
		a[2]=51;
		a[4]=a[1]*2;
		
		for(int i=0; i<a.length; i++) {
			System.out.println("a["+i+"] ="+a[i]);
		}
	}
	public static void intArrayInit() {
	//배열 초기화하며 선언
		int[] a = {1,2,3,4,5};
		
		for(int i=0; i<a.length; i++) {
			System.out.println("a["+i+"] = "+a[i]);
		}
	}
	
	public static void cloneArray() {
	//배열 복제 출력
		int[] a = {1,2,3,4,5};
		int[] b = a.clone();
		
		b[3] = 0;
		
		System.out.print("a =");
		for(int i=0; i<a.length; i++) {
			System.out.print(" "+a[i]);
		}
		
		System.out.print("\nb =");
		for(int j=0; j<b.length; j++) {
			System.out.print(" "+b[j]);
		}
	}
	

}
