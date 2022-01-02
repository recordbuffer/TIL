package com.inflearn.string;

import java.util.Scanner;

//앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
//문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
//입력: found7, time: study; Yduts; emit, 7Dnuof
//출력: YES
public class 유효한팰린드롬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		System.out.println(solution(s));
	}
	public static String solution(String s) {
		String res = "NO";
		s=s.toUpperCase().replaceAll("[^A-Z]", "");
		
		String tmp = new StringBuilder(s).reverse().toString();
		
		if(s.equals(tmp)) res="YES";
		
		return res;
	}

}
