package com.doit.java.sort;

import java.util.Scanner;

public class HeapSort {
	/*
	 * 힙 정렬 : 힙 정렬은 힙(heap)을 사용해 정렬하는 선택 정렬 응용 알고리즘
	 * 일반적인 힙 정렬의 시간 복잡도는 O(n log n)
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
		
		heapSort(arr, n);
				
		System.out.println("정렬 완료");
		
		//정렬 후 출력
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	static void heapSort(int[] arr, int n) {
		
	}

}
