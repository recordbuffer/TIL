package com.inflearn.string;

import java.util.Scanner;

//영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고, 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
//입력: a#b!GE*T@S
//출력: S#T!EG*b@a
public class 특정문자뒤집기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		char[] arr = s.toCharArray();
	
		String res;
		int lt = 0, rt = s.length()-1;
		
		while(lt<rt) {
			if(!Character.isAlphabetic(arr[lt])) lt++;
			else if(!Character.isAlphabetic(arr[rt])) rt--;
			else {
				char tmp = arr[lt];
				arr[lt]=arr[rt];
				arr[rt]=tmp;
				lt++;
				rt--;
			}
		}
		res = String.valueOf(arr);
		return res;
	}

}
