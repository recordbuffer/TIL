package com.java.practice.iteration;

public class While_test {
	public static void main(String[] args) {
		//While_test.test01();
		While_test.test02();
	}
	
	public static void test01() {
		
		/* while문 : 반복횟수 정해지지 않은 반복문
		 * while (조건식) {
		 * 			코드
		 * }
		 */
		
		int i=1;
		
		while (i<10) {
			System.out.println(i+" 번째 반복문 수행");
			i++;
		}
		System.out.println("while 종료 후 i의 값: "+i);
	}

	
	public static void test02() {
		
		/* do-while문 : 무조건 한번 출력 그리고 반복문
		 * do {
		 * 		코드
		 * } whlie (조건식);
		 */
		
		int i=1;
		
		do {
			System.out.println("i:"+i);
			i++;
		} while (i<10);
		
		System.out.println("do while 종료 후 값: "+i);
		
	}
}
