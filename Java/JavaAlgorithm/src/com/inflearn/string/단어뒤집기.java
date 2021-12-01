package com.inflearn.string;

import java.util.ArrayList;
import java.util.Scanner;

//N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
//입력: 3 / good / Time / Big
//출력: doog / emiT / giB
public class 단어뒤집기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		String[] arr = new String[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = sc.next();
		}

		for(String x : solution2(num, arr)) {
			System.out.println(x);
		}
	}
	
	//StringBuilder의 reverse 이용
	public static ArrayList<String> solution(int num, String[] arr){
		ArrayList<String> res = new ArrayList<>();
		for(String x : arr) {
			String tmp = new StringBuilder(x).reverse().toString();
			res.add(tmp);
		}
		return res;
	}
	
	//문자를 하나하나 잘라서 뒤집기
	public static ArrayList<String> solution2(int num, String[ ] arr){
		ArrayList<String> res = new ArrayList<>();
		for(String x : arr) {
			char[] s = x.toCharArray();
			int lt = 0, rt= x.length()-1;
			while(lt<rt) {
				char tmp = s[lt];
				s[lt] = s[rt];
				s[rt] = tmp;
				lt++;
				rt--;
			}
			String tmp = String.valueOf(s);
			res.add(tmp);
		
		}
		
		return res;
	}

}
