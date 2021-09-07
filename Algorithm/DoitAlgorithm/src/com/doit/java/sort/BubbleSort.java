package com.doit.java.sort;

import java.util.Scanner;

public class BubbleSort {
	/*
	 * 버블 정렬 : 버블 정렬은 맨 끝단부터 이웃한 두 요소의 비교-교환의 과정을 진행하며 정렬하는 알고리즘
	 * 일반적인 버블 정렬의 시간 복잡도는 O(n²)
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
				
		bubbleSort(arr, n);
						
		System.out.println("정렬 완료");
		
		//정렬 후 출력
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static void bubbleSort(int[] arr, int n) {		
		//n개의 요소 -> n-1번 비교
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[j]<arr[i]) {
					swap(arr, j, i);
				}
			}
		}
	}
	
	//배열의 요소 두개의 위치를 바꿈 
	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1]=arr[idx2];	//idx1 : idx1 -> idx2
		arr[idx2]=tmp;			//idx2 : idx2 -> idx1
	}

}
