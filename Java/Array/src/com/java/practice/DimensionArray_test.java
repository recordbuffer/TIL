package com.java.practice;

public class DimensionArray_test {
	public static void main(String[] args) {

			//2차원 배열
			//int[][] 배열명;
			
			int[][] iarr1;
			int[][] iarr2;
			
			iarr1=new int[3][5];
			
			iarr2=new int[3][];
			iarr2[0]=new int[5];
			iarr2[1]=new int[5];
			iarr2[2]=new int[3];
			
			for(int i=0; i<iarr2.length; i++) {
				for(int j=0; j<iarr2[i].length; j++) {
					System.out.print(iarr2[i][j]+" ");
				}
				System.out.println();
			}
			
			int val=1;
			for (int i=0; i<iarr1.length; i++) {
				for (int j=0; j<iarr1[i].length; j++) {
					iarr1[i][j]=val++;
				}
			}
		}
}