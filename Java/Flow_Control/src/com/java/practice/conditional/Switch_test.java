package com.java.practice.conditional;

import java.util.Scanner;

public class Switch_test {
	public static void main(String[] args) {
		
		/* switch�� : ���� ���� ���� �� ���, ������ ���� ������ default�ڵ� ���
		 * switch (����ǥ����) {
		 * case ����1 : �ڵ�
		 * 			   break;
		 * case ����2 : �ڵ�
		 *			   break;
		 * case ����3 : �ڵ�
		 * 			   break;
		 * default :�ڵ�
		 *  }
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1~5 �� ���� �ϳ� �Է�: ");
		int i = sc.nextInt();
		
		switch (i) {
		case 1:
			System.out.println("1�Դϴ�.");
			break;
		case 2: 
			System.out.println("2�Դϴ�.");
			break;
		case 3:
			System.out.println("3�Դϴ�.");
			break;
		default:
			System.out.println("�ٸ� �����Դϴ�.");
		}
	}

}
