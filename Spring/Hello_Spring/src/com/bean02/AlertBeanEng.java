package com.bean02;

public class AlertBeanEng implements AlertBean {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello "+name+"!");
	}

	//interface AlertBean�� implements�� English������ AlertBeanEng

}
