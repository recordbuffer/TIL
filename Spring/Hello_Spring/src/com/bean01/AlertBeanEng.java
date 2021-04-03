package com.bean01;

public class AlertBeanEng implements AlertBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello "+name+"!");
	}

	//interface AlertBean을 implements한 English버전의 AlertBeanEng

}
