package com.bean01;

public class BeanTest {

	public static void main(String[] args) {
		
		//XML ���� ���� �׳� �о����
		AlertBean bean = new AlertBeanKo();
		bean.sayHello("�����̿�");
		
		bean = new AlertBeanEng();
		bean.sayHello("World");
	}

}
