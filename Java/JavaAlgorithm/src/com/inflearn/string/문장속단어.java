package com.inflearn.string;

import java.util.Scanner;

//한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
//문장속의 각 단어는 공백으로 구분됩니다.
//입력 : it is time to study 
//출력 : study
public class 문장속단어 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		//solution(str);
		solution2(str);
	}
	public static void solution(String str) {
		String res = "";
		int m = Integer.MIN_VALUE;	// 일단 m을 가장 작은 값으로 초기화
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
	public static void solution2(String str) {
		String res = "";
		int m = Integer.MIN_VALUE, pos;
		while((pos=str.indexOf(' '))!=-1) {
			// 더이상 없으면 -1 : 종료
			String tmp = str.substring(0, pos);
			int len=tmp.length();
			if(len>m) {
				m=len;
				res=tmp;
			}
			str=str.substring(pos+1);
		}
		if(str.length()>m) res=str;
		System.out.println(res);
	}
}
