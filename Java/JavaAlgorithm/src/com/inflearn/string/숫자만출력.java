package com.inflearn.string;

import java.util.Scanner;

//문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
//입력: g0en2T0s8eSoft
//출력: 208
public class 숫자만출력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		System.out.println(solution(s));
	}
	public static int solution(String s) {		
		return Integer.valueOf(s.replaceAll("[^0-9]", ""));
	}
}
