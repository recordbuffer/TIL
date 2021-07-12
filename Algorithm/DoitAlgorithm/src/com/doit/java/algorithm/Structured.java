package com.doit.java.algorithm;

import java.util.Scanner;

public class Structured {

	public static void main(String[] args) {
		
		Structured.digits();
	}
	
	public static void digits() {
	//2의 자리 정수 입력
		Scanner sc = new Scanner(System.in);
		int no;
		
		System.out.println("2의 자리 정수 입력하세요");
		
		do {
			no = sc.nextInt();
			
		} while(no< 10 || no>99);
		
		System.out.println("변수 no의 값은   "+no+" 입니다");
	}

}
