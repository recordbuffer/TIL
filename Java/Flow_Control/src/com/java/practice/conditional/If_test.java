package com.java.practice.conditional;

import java.util.Scanner;

public class If_test {
	public static void main(String[] args) {
		
		If_test.if_test01();
		//If_test.if_test02();
		//If_test.if_test03();

	}
	
	public static void if_test01() {
		
		//if�� : ���� (���ǽ�)�� true��� �ڵ� ����϶�
		/*	if (���ǽ�) {
		 * 		�ڵ�
		 * } 
		 */
		
		//���� �Է¹޴� �Լ� Scanner
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ϳ��� �Է��ϼ��� : ");
		//���� i�� Scanner�� �޾ƿ� ������ ����
		int i = sc.nextInt();
		
		//i�� ¦������ �˾Ƴ��� if ���ǹ�
		if(i%2==0) {
			System.out.println("�Է��Ͻ� ���ڴ� '¦��' �Դϴ�.");
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
	
	public static void if_test02() {
		
		/* if-else�� : ���� (���ǽ�)�� true�� �ڵ�1 ���, false��� �ڵ�2 ���
		 * if (���ǽ�) {
		 * 		�ڵ�1
		 *} else {
		 * 		�ڵ�2
		 * } 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ϳ��� �Է��ϼ���: ");
		int i = sc.nextInt();
		
		//i�� ¦������ Ȧ������ �˾Ƴ��� if-eles ���ǹ�
		if (i%2==0) {
			System.out.println("�Է��Ͻ� ���ڴ� '¦��' �Դϴ�.");
		} else {
			System.out.println("�Է��Ͻ� ���ڴ� 'Ȧ��' �Դϴ�.");
		} 
		System.out.println("���α׷��� �����մϴ�.");
		
	}
	
	public static void if_test03() {
		
		/* if-else-if�� :  ���� (���ǽ�1)�� true�� �ڵ�1 ���,
		 * 				  false�� ���� (���ǽ�2)�� true��� �ڵ�2 ���,
		 * 				   �� false�� �ڵ�3 ���
		 * if (���ǽ�1) {
		 * 		�ڵ�1
		 * } else if (���ǽ�2) {
		 * 		�ڵ�2
		 * } else {
		 * 		�ڵ�3
		 * }
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("����1�� �Է��ϼ���: ");
		int i = sc.nextInt();
		
		System.out.print("����2�� �Է��ϼ���: ");
		int j = sc.nextInt();
		
		//i�� j�� �� ���ϴ� if-else-if ���ǹ�
		if (i<j) {
			System.out.println(i+"�� "+j+"���� �۽��ϴ�.");
		} else if (i>j) {
			System.out.println(i+"�� "+j+"���� Ů�ϴ�.");
		} else {
			System.out.println(i+"�� "+j+"�� �����ϴ�.");
		}
	}
}
