package com.inflearn.string;

import java.util.Scanner;

//대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
//입력 : StuDY
//출력 : sTUdy
public class 대소문자변환 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		solution(str);
	}

	public static void solution(String str) {
		String res="";
		for(char x : str.toCharArray()) {
			if(Character.isLowerCase(x)) res+=Character.toUpperCase(x); 
			else res+=Character.toLowerCase(x);
			 
			
		 /*if(x>=65 && x<=90) res+=(char)(x-32);
			else res+=(char)(x+32);*/
		}

		System.out.println(res);	
	}
}
