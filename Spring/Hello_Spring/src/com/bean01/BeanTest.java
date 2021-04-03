package com.bean01;

public class BeanTest {

	public static void main(String[] args) {
		
		//XML 파일 없이 그냥 읽어오기
		AlertBean bean = new AlertBeanKo();
		bean.sayHello("세상이여");
		
		bean = new AlertBeanEng();
		bean.sayHello("World");
	}

}
