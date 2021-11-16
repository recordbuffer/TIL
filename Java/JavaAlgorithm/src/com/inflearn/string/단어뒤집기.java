package com.inflearn.string;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		String[] arr = new String[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = sc.next();
		}

		for(String x : solution(num, arr)) {
			System.out.println(x);
		}
	}
	
	public ArrayList<String> solution(int num, String[] arr){
		ArrayList<String> res = new ArrayList<>();
		for(String x : arr) {
			String tmp = new StringBuilder(x).reverse().toString();
			res.add(tmp);
		}
			
		return res;
	}

}
