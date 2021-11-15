package com.inflearn.string;

import java.util.Scanner;

//한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
//문장속의 각 단어는 공백으로 구분됩니다.
public class 문장속단어 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		solution(str);
	}
	public static void solution(String str) {
		String res = "";
		int m = Integer.MIN_VALUE;
		String[] arr = str.split(" ");
		
		for(String x : arr) {
			int len=x.length();
			if(len>m) {
				m=len;
				res=x;
			}
		}
		System.out.println(res);
	}
}
