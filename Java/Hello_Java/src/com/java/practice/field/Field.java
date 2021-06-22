package com.java.practice.field;


//변수 선언 위치에 따른 구분
public class Field {//클래스 영역의 시작
	//클래스 영역에 작성하는 변수 -> 필드
	//필드 -> 멤버변수
	
	private int globalNum;
	private static int staticNum;
	
	//초기화블럭
	{globalNum=10;}
	static {staticNum=20;}
	
	public void test01(int num) {//메소드 영역의 시작
		//지역변수
		//메소드 괄호 안의 변수 (매개변수)
		int localNum=0;
		
		System.out.println(num); //매개변수는 초기화 안함
		//System.out.println(localNum); //지역변수는 초기화 필요
	
		System.out.println(globalNum); //전역변수는 어디서나 사용 가능

	}//메소드 영역 끝
	
	
	public void test02() {
		//System.out.println(localNum); //지역변수는 해당 지역에서만 사용가능
		System.out.println(globalNum);
	}

}
