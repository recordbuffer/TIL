package com.doit.java.algorithm;

import java.util.Scanner;

public class Algorithm {

	public static void main(String[] args) {
		// 알고리즘 : 문제해결을 위한 단계적인 절차
		
		//Algorithm.max();
		//Algorithm.center();
		Algorithm.operation();
	}
	
	public static void max() {
		// 정수 3개 입력받아 최댓값 출력
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
				
		int max = a;
				
		if(max<b) max=b;
		if(max<c) max=c;
				
		System.out.println("최댓값은 "+max+"이다");
	}
	
	public static void center() {
		// 정수 3개 입력받아 중앙값 출력
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		
		int center = a;
		
		if(a>=b)
			if(b>=c) 
				center = b;
			else if(a<=c)
				center = a;
			else
				center = c;
		else if(a>c)
			center = a;
		else if(b>c)
			center = c;
		else
			center = b;
			
		System.out.println("중앙값은 "+center+"이다");
	}
	
	public static void operation() {
		// 입력한 정수 양수인지 음수인지 0인지
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n>0) System.out.println("양수입니다.");
		if(n<0) System.out.println("음수입니다.");
		else
			System.out.println("0입니다.");
		
	}
}
