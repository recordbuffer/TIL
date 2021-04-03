package com.bean02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

	public static void main(String[] args) {
		
		//(해당위치)의 xml 파일 읽어와 bean공장에서 정의
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/bean02/Beans.xml");
		
		//정의한대로 bean 가져와 연결하기 (DI)
		AlertBean bean = (AlertBean)factory.getBean("Kor");
		bean.sayHello("세상이여");
		
		bean = (AlertBean)factory.getBean("Eng");
		bean.sayHello("World");
		
	}

}
