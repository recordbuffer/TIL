package com.doit.java.sort;

import java.util.Scanner;

public class SelectionSort {
	/*
	 * 선택 정렬 : 선택 정렬은 작은 요소부터 순서대로 선택해 앞쪽으로 위치를 옮겨 순서대로 정렬하는 알고리즘
	 * 일반적인 선택 정렬의 시간 복잡도는 O(n²)
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
		sc.close();
						
		System.out.println("정렬 완료");
		
		//정렬 후 출력
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static void selectionSort() {
		
	}

}
