package com.bean01;

public class AlertBeanKo implements AlertBean {

	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요 "+name+"!");
	}

	//interface AlertBean을 implements한 korean버전의 AlertBeanKo
}
