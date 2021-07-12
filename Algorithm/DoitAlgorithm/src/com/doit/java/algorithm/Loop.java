package com.doit.java.algorithm;

import java.util.Scanner;

public class Loop {

	public static void main(String[] args) {
		
		//Loop.whilesum();
		//Loop.forsum();
	}
	
	public static void whilesum() {
		// 1부터 입력받은 n 까지 합
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int sum = 0;
		int i = 1;
		
		while(i<=n) {
			sum += i;
			i++;
		}
		System.out.println("1부터 "+n+"까지의 합계 : "+sum);
	}
	
	
	public static void forsum() {
		// 1부터 입력받은 n 까지 합
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int sum = 0;
		
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		System.out.println("1부터 "+n+"까지의 합계 : "+sum);
	}
	
	
	
	
}
