package com.bean01;

public class AlertBeanEng implements AlertBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello "+name+"!");
	}

	//interface AlertBean�� implements�� English������ AlertBeanEng

}
