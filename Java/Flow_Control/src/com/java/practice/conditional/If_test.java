package com.java.practice.conditional;

import java.util.Scanner;

public class If_test {
	public static void main(String[] args) {
		
		If_test.if_test01();
		//If_test.if_test02();
		//If_test.if_test03();

	}
	
	public static void if_test01() {
		
		//if문 : 만약 (조건식)이 true라면 코드 출력하라
		/*	if (조건식) {
		 * 		코드
		 * } 
		 */
		
		//값을 입력받는 함수 Scanner
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나를 입력하세요 : ");
		//변수 i에 Scanner로 받아온 정수값 저장
		int i = sc.nextInt();
		
		//i가 짝수인지 알아내는 if 조건문
		if(i%2==0) {
			System.out.println("입력하신 숫자는 '짝수' 입니다.");
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
	public static void if_test02() {
		
		/* if-else문 : 만약 (조건식)이 true면 코드1 출력, false라면 코드2 출력
		 * if (조건식) {
		 * 		코드1
		 *} else {
		 * 		코드2
		 * } 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나를 입력하세요: ");
		int i = sc.nextInt();
		
		//i가 짝수인지 홀수인지 알아내는 if-eles 조건문
		if (i%2==0) {
			System.out.println("입력하신 숫자는 '짝수' 입니다.");
		} else {
			System.out.println("입력하신 숫자는 '홀수' 입니다.");
		} 
		System.out.println("프로그램을 종료합니다.");
		
	}
	
	public static void if_test03() {
		
		/* if-else-if문 :  만약 (조건식1)이 true면 코드1 출력,
		 * 				  false고 만약 (조건식2)이 true라면 코드2 출력,
		 * 				   또 false면 코드3 출력
		 * if (조건식1) {
		 * 		코드1
		 * } else if (조건식2) {
		 * 		코드2
		 * } else {
		 * 		코드3
		 * }
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수1을 입력하세요: ");
		int i = sc.nextInt();
		
		System.out.print("정수2를 입력하세요: ");
		int j = sc.nextInt();
		
		//i와 j의 값 비교하는 if-else-if 조건문
		if (i<j) {
			System.out.println(i+"이 "+j+"보다 작습니다.");
		} else if (i>j) {
			System.out.println(i+"이 "+j+"보다 큽니다.");
		} else {
			System.out.println(i+"와 "+j+"가 같습니다.");
		}
	}
}
