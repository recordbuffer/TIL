package com.java.practice.field;


//���� ���� ��ġ�� ���� ����
public class Field {//Ŭ���� ������ ����
	//Ŭ���� ������ �ۼ��ϴ� ���� -> �ʵ�
	//�ʵ� -> �������
	
	private int globalNum;
	private static int staticNum;
	
	//�ʱ�ȭ��
	{globalNum=10;}
	static {staticNum=20;}
	
	public void test01(int num) {//�޼ҵ� ������ ����
		//��������
		//�޼ҵ� ��ȣ ���� ���� (�Ű�����)
		int localNum=0;
		
		System.out.println(num); //�Ű������� �ʱ�ȭ ����
		//System.out.println(localNum); //���������� �ʱ�ȭ �ʿ�
	
		System.out.println(globalNum); //���������� ��𼭳� ��� ����

	}//�޼ҵ� ���� ��
	
	
	public void test02() {
		//System.out.println(localNum); //���������� �ش� ���������� ��밡��
		System.out.println(globalNum);
	}

}
