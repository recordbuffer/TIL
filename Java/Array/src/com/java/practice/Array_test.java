package com.java.practice;

public class Array_test {
	public static void main(String[] args) {
		//Array_test.test01();
		//Array_test.test02();
		//Array_test.test03();
		//Array_test.test04();
		Array_test.test05();
	
	}
	public static void test01() {
		
		/* �迭 : ���� �ڷ����� ���� �������� �ϳ��� �������� ����� 
		 * 		 �ϳ��� �̸����� �ٷ�� ��
		 */	
		
		//5ĭ¥�� ��������� �迭 ����
		int[] arr = new int[5];
		
		//for������ �迭 �Ҵ�
		for (int i=0; i<arr.length; i++) {
			arr[i]=i*10;
			System.out.println("arr["+i+"]="+arr[i]);
		}	
	}
	
	public static void test02() {
		//for-each��  : �������� ������ ó���ϱ� ����
	
		String[] members = {"ȫ�浿","�̼���","�̼���","������"};
		for (String i : members) {
			System.out.println(i+"���� �����߽��ϴ�.");
		}
	
	}
	
	public static void test03() {
		// �迭�� ������ �Է� �̷������� ���
	/*
	      a b c d e f 
	      g h i j k l
	      m n o p q r
	      s t u v w x
	      y z
	 */
		
		//26ĭ¥�� ��������� �迭 ����
		char[] ch = new char[26];
		for(int i=0; i<ch.length; i++) {
			ch[i] = (char)((int)'a'+i);
		}
		
		//for������ �迭 �Ҵ�
		for(int i=0; i<ch.length; i++) {
			System.out.print(ch[i]+" ");
			if(i%6==5) {
				System.out.println();
			}
		}
		
		System.out.println();
				
	}
	
	public static void test04() {
		//�迭 �������� ����ϱ�
		/*
		 * 	z y x w v u 
		 * 	t s r q p o 
		 * 	n m l k j i 
		 * 	h g f e d c 
		 * 	b a
		 */
		
		//26ĭ¥�� ��������� �迭 ����
		char[] ch = new char[26];
		for(int i=0; i<ch.length; i++) {
			ch[i] = (char)((int)'a'+i);
		}
		
		//for������ �迭 �Ҵ�
		int tmp=0;
		
		for(int i=ch.length; i>0; i--) {
			System.out.print(ch[i-1]+" ");
			if(tmp%6==5) {
				System.out.println();
			}
			tmp++;
		}
		
		//�迭 �ϳ� �� ����, �������� ������ �Է�
		tmp=0;
		char re[] = new char[26];
		for (int i=ch.length-1; i>=0; i--) {
			re[tmp]=ch[i];
		}
	}
	
	public static void test05() {
		//�迭 �ҹ��� -> �빮�ڷ� ����ϱ�
		/*
		 * 	A B C D E F 
		 * 	G H I J K L 
		 * M N O P Q R 
		 * S T U V W X 
		 * Y Z 
		 */
		
		//26ĭ¥�� ��������� �迭 ����
		char[] ch = new char[26];
		for(int i=0; i<ch.length; i++) {
			ch[i] = (char)((int)'a'+i);
		}
		
		//toUpperCase
		for (int i=0; i<ch.length; i++) {
			ch[i]=Character.toUpperCase(ch[i]);
		}
		
		for(int i=0; i<ch.length; i++) {
			System.out.print(ch[i]+" ");
			if(i%6==5) {
				System.out.println();
			}
		}
		System.out.println();
	}
}

