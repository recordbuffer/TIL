package com.bean01;

public class AlertBeanKo implements AlertBean {

	@Override
	public void sayHello(String name) {
		System.out.println("�ȳ��ϼ��� "+name+"!");
	}

	//interface AlertBean�� implements�� korean������ AlertBeanKo
}
