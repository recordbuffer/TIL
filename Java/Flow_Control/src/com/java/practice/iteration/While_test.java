package com.java.practice.iteration;

public class While_test {
	public static void main(String[] args) {
		//While_test.test01();
		While_test.test02();
	}
	
	public static void test01() {
		
		/* while�� : �ݺ�Ƚ�� �������� ���� �ݺ���
		 * while (���ǽ�) {
		 * 			�ڵ�
		 * }
		 */
		
		int i=1;
		
		while (i<10) {
			System.out.println(i+" ��° �ݺ��� ����");
			i++;
		}
		System.out.println("while ���� �� i�� ��: "+i);
	}

	
	public static void test02() {
		
		/* do-while�� : ������ �ѹ� ��� �׸��� �ݺ���
		 * do {
		 * 		�ڵ�
		 * } whlie (���ǽ�);
		 */
		
		int i=1;
		
		do {
			System.out.println("i:"+i);
			i++;
		} while (i<10);
		
		System.out.println("do while ���� �� ��: "+i);
		
	}
}
