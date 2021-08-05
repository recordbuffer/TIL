package com.doit.java.dataStructure;

import java.util.Random;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		//Array.intArray();
		//Array.cloneArray();
		//Array.intArrayInit();
		//Array.max();
		Array.enhanFor();
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
	
	public static void max() {
	//최댓값 구하기
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		//배열 크기
		int[] arr = new int[num];
		
		//배열 값 > 랜덤으로 받기
		Random rd = new Random();
		
		for(int i=0; i<num; i++) {
			arr[i]=100+rd.nextInt(100);
			System.out.print(arr[i]);
		}
		
		int max = arr[0];
		
		//최댓값 비교
		for(int i=1; i<num; i++) {
			if(arr[i]>max) max=arr[i];
		}
		System.out.println("배열 arr의 최댓값은 "+max+"이다.");
	}
	
	public static void enhanFor() {
	//향상된 for문
		double[] a = {1.0,2.0,3.0,4.0,5.0};
		
		for(int i=0; i<a.length; i++) {
			System.out.println("a["+i+"] = "+a[i]);
		}
		
		double sum = 0;
		
		for(double i : a) sum+=i;
		
		System.out.println("모든 요소의 합은 "+sum);
	}
	
}
