package com.practice.abst;


public abstract class Bank {
	
	//�������
	String name;
	String account;
	int balance;
	
	//�⺻ ������	
	public Bank() {
		super();
	}
	
	//�Ű����� ������
	public Bank(String name, String account, int balance) {
		super();
		this.name = name;
		this.account = account;
		this.balance = balance;
	}
	
	//�޼ҵ�
	//�Ա�
	public void in() {
		System.out.println("--money deposit--");
	}
	
	
	//���
	public void out() {
		System.out.println("--money withdraw--");
	}
	
	//�߻�޼ҵ�
	//����
	public abstract void saving();
	
	//���� ����
	public abstract void cancel();
	
	
	
	//�������
	public void getInfo() {
		System.out.printf("name : %s\n", name);
		System.out.printf("account : %s\n", account);
		System.out.printf("balance : %s\n", balance);
	}
	
	
	

}

