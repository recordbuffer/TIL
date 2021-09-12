package com.doit.java.sort;

import java.util.Scanner;

public class treeSort {
	/*
	 * 트리 정렬 : 이진 탐색 트리를 만들어 정렬하는 알고리즘
	 * 일반적인 병합 정렬의 시간 복잡도는 O(n log n)
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정렬할 요소의 수: ");
	
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		//요소 입력받음
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
				
		System.out.println("정렬 완료");
		
		//정렬 후 출력
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
