package com.java.practice.iteration;

public class For_test {
	public static void main(String[] args) {
		//for_Test.test01();
		For_test.test02();
		
		/* for�� : �ݺ� Ƚ���� ������ �ִ� �ݺ���
		 * for (�ʱ��; ���ǽ�; ������) {
		 * 		�ڵ�
		 * }
		 */
	}
		
		public static void test01() {
		//������ ���
			for (int i =2; i<=9; i++) {
				for (int j=1; j<=9; j++) {
					int result = i*j;
					System.out.println(i+"*"+j+"="+result);
				} System.out.println();
			}	
		}	
			
		public static void test02() {
		//1~100���� ������ ���� ���ϰ� 1~�������� �� ���
			int random = (int)(Math.random()*100)+1;
			int sum=0;
			
			for(int i=1; i<=random; i++) {
				sum+=i;
			} System.out.println("1���� "+random+"������ ���� "+sum+"�Դϴ�.");
		}
	}


