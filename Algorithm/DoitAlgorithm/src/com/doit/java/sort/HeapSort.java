package com.doit.java.sort;

import java.util.Scanner;

public class HeapSort {
	/*
	 * 힙 정렬 : 힙 정렬은 힙(heap)을 사용해 정렬하는 선택 정렬 응용 알고리즘
	 * 최대 힙 특성 Max-heap : 루트 노드 값이  가장 큼
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
		//힙구조로 구성 (Build Max-heap) 
		heapify(arr, n);
		
		//루트 제거하고 마지막 요소를 루트로 옮김 (Extract-Max)
		for(int i=n-1; i>=0; i--) {
			swap(arr, 0, i);
			
			heapify(arr, i);
		}
		
	}
	
	//Build Max-heap 
	static void heapify(int[] arr, int last) {	//last변수는 가장 마지막 인덱스를 뜻함
		for(int i=1; i<last; i++) {
			int child = i;
			
			while(child>0) {
				int parent = (child - 1)/2;
				
				if(arr[child] > arr[parent]) {
					swap(arr, child, parent);
				}
				child = parent;
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
