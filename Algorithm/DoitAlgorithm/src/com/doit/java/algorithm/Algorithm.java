package com.doit.java.algorithm;

import java.util.Scanner;

public class Algorithm {

	public static void main(String[] args) {
		// �˰��� : �����ذ��� ���� �ܰ����� ����
		
		//Algorithm.max();
		//Algorithm.center();
		Algorithm.operation();
	}
	
	public static void max() {
	// ���� 3�� �Է¹޾� �ִ� ���
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
				
		int max = a;
				
		if(max<b) max=b;
		if(max<c) max=c;
				
		System.out.println("�ִ��� "+max+"�̴�");
	}
	
	public static void center() {
	// ���� 3�� �Է¹޾� �߾Ӱ� ���
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		
		int center = a;
		
		if(a>=b)
			if(b>=c) 
				center = b;
			else if(a<=c)
				center = a;
			else
				center = c;
		else if(a>c)
			center = a;
		else if(b>c)
			center = c;
		else
			center = b;
			
		System.out.println("�߾Ӱ��� "+center+"�̴�");
	}
	
	public static void operation() {
	// �Է��� ���� ������� �������� 0����
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n>0) System.out.println("����Դϴ�.");
		if(n<0) System.out.println("�����Դϴ�.");
		else
			System.out.println("0�Դϴ�");
		
	}
}
