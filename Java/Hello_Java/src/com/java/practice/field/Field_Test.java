package com.java.practice.field;

public class Field_Test {
	public static int staticNum;
	
	public static final int STATIC_NUM1=1;
	//상수필드 : 반드시 선언과 동시에 초기화
	
	public final static int STATIC_NUM2=2;
	
	public void test() {
		//지역변수에서는 static 키워드를 통한 변수 선언 안됨
		//static int localStaticNum;
	}
}
