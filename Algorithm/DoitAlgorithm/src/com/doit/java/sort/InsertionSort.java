package com.doit.java.sort;

import java.util.Scanner;

public class InsertionSort {
	/*
	 * 삽입 정렬 : 선택한 요소를 앞쪽의 알맞은 위치로 삽입해 정렬하는 알고리즘
	 * 일반적인 삽입 정렬의 시간 복잡도는 O(n²)
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
				
		insertionSort(arr, n);
						
		System.out.println("삽입 정렬 완료");
		
		//정렬 후 출력
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static void insertionSort(int[] arr, int n) {
		//두번째 위치한 요소부터 시작
		//n개의 요소 -> n번 수행 -> n+1번이면 반복 종료
		for(int i=1; i<n; i++) {
			int j = i-1;
			int tmp = arr[i];

			//선택한 i 보다 앞쪽에 위치한 요소들 비교
			for(j=i; j>0 && arr[j-1]>tmp; j--) {
				//i보다 작으면 요소의 위치를 하나씩 뒤로 보냄
				arr[j] = arr[j-1];
			}
			arr[j] = tmp;	//앞쪽 자리는 선택된 요소 i가 차지
		}
	}

}
