package com.java.practice;

public class Hello_World {

	public static void main(String[] args) {
		//Hello World 출력
				System.out.println("[Hello World 출력]");
				System.out.println("Hello World!");
				
				System.out.println();
				
				//실행 단축키는 [Ctrl]+[F11]
				
				//줄 바꿔 출력
				System.out.println("[줄 바꿔 출력]");
				System.out.println("이것이 \n\'자바\'\n다");
				
				/* 여러줄 
				 * 주석
				 * 달기
				 */
				
				System.out.println();
				
			
				//간단계산
				System.out.println("[간단 계산]");
				System.out.println(166/2);
			
				System.out.println();
				
				
				//Operator
				System.out.println("[증감 연산자]");
				int a = 10;
				int b = ++a;
				System.out.println(a+","+b);
				
				System.out.println();

				System.out.println("[논리 연산자]");
				boolean bool1 = true;
				boolean bool2 = !bool1;
				System.out.println(bool2);
				
				System.out.println("a&&b는 a와 b 둘다 true인 경우 true 반환 : AND");
				System.out.println("a||b는 a와 b 둘 중 하나만 true여도 true 반환 : OR");
				
				System.out.println();

				System.out.println("[산술 연산자]");
				int x = 20, y=10;
				System.out.println(x*y);
				System.out.println(x/y);
				System.out.println(x%y);
				
				System.out.println();

				System.out.println("[비교 연산자]");
				System.out.println("a==b는 a와 b가 같다 : true");
				System.out.println("a!=b는 a와 b가 같지 않다 : false");
				
				System.out.println();

				System.out.println("[삼항 연산자]");
				int q = 10, p = 20;
				int result1 = q>p ? q++ :p--;
				System.out.println(result1);
				
				int result2 = q<p ? q++ : p--;
				System.out.println(result2);
	}

}
