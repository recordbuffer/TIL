package com.bean02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

	public static void main(String[] args) {
		
		//(�ش���ġ)�� xml ���� �о�� bean���忡�� ����
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/bean02/Beans.xml");
		
		//�����Ѵ�� bean ������ �����ϱ� (DI)
		AlertBean bean = (AlertBean)factory.getBean("Kor");
		bean.sayHello("�����̿�");
		
		bean = (AlertBean)factory.getBean("Eng");
		bean.sayHello("World");
		
	}

}
