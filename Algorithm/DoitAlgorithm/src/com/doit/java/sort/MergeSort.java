package com.doit.java.sort;

import java.util.Scanner;

public class MergeSort {
	/*
	 * 병합 정렬 : 정렬을 앞그룹, 뒷그룹으로 나눠 정렬하고 병합하는 정렬
	 * 분할 정복법 (Divide and Conquer)
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
		sc.close();
		
		mergeSort(arr, n);
				
		System.out.println("병합 정렬 완료");
		
		//정렬 후 출력
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	//병합 정렬 
	static void mergeSort(int[] arr, int n) {
		int[] tmp = new int[n];		//작업용 임시 저장공간
		underMergeSort(arr, tmp, 0, n-1);
		
		tmp = null;
	}
	
	//재귀적으로 병합 정렬
	static void underMergeSort(int[] arr, int[] tmp, int first, int last) {
		if(first<last) {		//첫번째 요소가 마지막 요소보다 작을때 동안 반복
			int center = (first + last)/2;
			
			underMergeSort(arr, tmp, first, center);	//앞 그룹을 병합 정렬함
			underMergeSort(arr, tmp, center+1, last);	//뒷 그룹을 병합 정렬함
			
			merge(arr, tmp, first, center, last); //병합
		}
	}
	
	static void merge(int[] arr, int[] tmp, int first, int center, int last) {
		//작업용 tmp 배열에 복사해옴
		for(int i=first; i<=last; i++) {
			tmp[i]=arr[i];
		}
		
		int pointF = first;		//앞그룹의 첫요소
		int pointL = center+1; //뒷그룹의 첫요소
		int idx = first;	    //새로 넣을 배열 인덱스
		
		//두 그룹 정렬 진행(진행방향은 ->)
		while(pointF <= center && pointL <= last) {
			//요소끼리 비교
			//앞그룹 요소가 작으면 
			if(tmp[pointF] <= tmp[pointL]) {
				arr[idx] = tmp[pointF];		//앞그룹 요소로 저장
				pointF++;
			} else {
				arr[idx] = tmp[pointL];		//뒷그룹 요소로 저장
				pointL++;
			}
			idx++;
		}
		
		//앞 그룹의 요소가 남아있을 경우 (tmp에 앞 그룹 요소가 아직 다 안들어간 경우)
		for(int i=0; i<=center-pointF; i++) {
			arr[idx + i] = tmp[pointF + i];
		}
	}
}