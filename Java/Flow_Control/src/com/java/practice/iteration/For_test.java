package com.java.practice.iteration;

public class For_test {
	public static void main(String[] args) {
		//for_Test.test01();
		For_test.test02();
		
		/* for문 : 반복 횟수가 정해저 있는 반복문
		 * for (초기식; 조건식; 증감식) {
		 * 		코드
		 * }
		 */
	}
		
		public static void test01() {
		//구구단 출력
			for (int i =2; i<=9; i++) {
				for (int j=1; j<=9; j++) {
					int result = i*j;
					System.out.println(i+"*"+j+"="+result);
				} System.out.println();
			}	
		}	
			
		public static void test02() {
		//1~100까지 임의의 난수 구하고 1~난수까지 합 출력
			int random = (int)(Math.random()*100)+1;
			int sum=0;
			
			for(int i=1; i<=random; i++) {
				sum+=i;
			} System.out.println("1부터 "+random+"까지의 합은 "+sum+"입니다.");
		}
	}


