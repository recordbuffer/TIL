package com.doit.java.sort;

import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정렬할 요소의 수: ");
	
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		//요소 입력받음
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		//피벗값 : 위치상 가운데 일 경우
		middlePv(arr, 0, n-1);
		
		System.out.println("정렬 완료");
		
		//정렬 후 출력
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	//피벗값은 가운데 위치한 값으로 정함
	static void middlePv(int[] arr, int first, int last) {
		int pointF = first;  //배열의 가장 왼쪽 (첫번째 요소)
		int pointL = last;	 //배열의 가장 오른쪽 (마지막 요소)
		
		int pv = arr[(pointF + pointL)/2];	//피벗 (기준점)
		
		do {												//파티셔닝 과정
			while(arr[pointF] < pv) pointF++;				//피벗보다 작은 그룹
			while(arr[pointL] > pv) pointL--;				//피벗보다 큰 그룹
			
			if(pointF <= pointL) {					//양쪽이 만나면 파티셔닝 완료...하기전에
				swap(arr, pointF++, pointL--);		//동일한 요소를 교차시킴
			}
		} while (pointF <= pointL);		//양쪽이 만나면 파티셔닝 완료
		
		if(first < pointL) middlePv(arr, first, pointL);	//배열 반복해서 나눔(작은그룹도 퀵정렬 배열, 큰 그룹도 퀵정렬 배열시킴)
		if(pointF < last) middlePv(arr, pointF, last);
	}
	
	//배열의 요소 두개의 위치를 바꿈 
	static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1]=arr[idx2];	//idx1 : idx1 -> idx2
		arr[idx2]=tmp;			//idx2 : idx2 -> idx1
	}

}
