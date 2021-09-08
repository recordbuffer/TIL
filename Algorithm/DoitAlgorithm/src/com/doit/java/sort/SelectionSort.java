package com.doit.java.sort;

import java.util.Scanner;

public class SelectionSort {
	/*
	 * 선택 정렬 : 선택 정렬은 작은 요소부터 순서대로 선택해 앞쪽으로 위치를 옮겨 순서대로 정렬하는 알고리즘
	 * 일반적인 선택 정렬의 시간 복잡도는 O(n²)
	 * n개의 배열 n-1번 비교함 : 총 n(n-1)/2 번 수행
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
				
		selectionSort(arr, n);
						
		System.out.println("선택 정렬 완료");
		
		//정렬 후 출력
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static void selectionSort(int[] arr, int n) {
		//n개의 요소 -> n-1번 비교
		for(int i=0; i<n-1; i++) {
			//정렬되지 않은 요소 중 최솟값 찾기
			int min = i;
			
			for(int j=i+1; j<n; j++) {
				if(arr[j]<arr[min]) {
					min = j;	//최솟값 찾아
				}
			}
			swap(arr, i, min);	//정렬되지 않은 요소 중 첫요소와 자리 바꿈
		}
	}
	
	//배열의 요소 두개의 위치를 바꿈 
	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1]=arr[idx2];	//idx1 : idx1 -> idx2
		arr[idx2]=tmp;			//idx2 : idx2 -> idx1
	}

}
