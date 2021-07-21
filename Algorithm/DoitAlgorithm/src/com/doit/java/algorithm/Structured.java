package com.doit.java.algorithm;

import java.util.Scanner;

public class Structured {

	public static void main(String[] args) {
		
		//Structured.digits();
		//Structured.multiLoop();
		Structured.triangle();
	}
	
	public static void digits() {
	//2의 자리 정수 입력
		Scanner sc = new Scanner(System.in);
		int no;
		
		System.out.println("2의 자리 정수 입력하세요");
		
		do {
			no = sc.nextInt();
			
		} while(!(no>=10 && no<=99));
		//while(no<10 || no>99);
		
		System.out.println("변수 no의 값은   "+no+" 입니다");
	}
	
	
	public static void multiLoop() {
	//곱셈표 출력
		System.out.println("-----곱셈표 출력-----");
		
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.printf("%3d",i*j);
			}
			System.out.println();
		}
	}
	
	public static void triangle() {
	//이등변 삼각형 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("이등변 삼각형의 단수 입력");
		
		int no;
		
		do {
			no = sc.nextInt();
			
		}while(no<=0);
		
		for(int i=1; i<=no; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
