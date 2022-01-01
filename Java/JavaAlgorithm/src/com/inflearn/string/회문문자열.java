package com.inflearn.string;

import java.util.Scanner;

//문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
//단 회문을 검사할 때 대소문자를 구분하지 않습니다.
//입력: gooG
//출력: YES
public class 회문문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		//System.out.println(solution(s));
		System.out.println(solution2(s));

	}
	public static String solution(String s) {
		String res = "YES";

		s = s.toUpperCase();
		int len = s.length();
		
		for(int i=0; i<len/2; i++) {
			if(s.charAt(i)!=s.charAt(len-i-1)) res="NO";
		}

		return res;
	}
	
	public static String solution2(String s) {
		String res = "NO";
		
		String tmp = new StringBuilder(s).reverse().toString();
		
		if(s.equalsIgnoreCase(tmp)) res="YES";
		
		return res;
	}

}
