package com.practice.abst;


public abstract class Bank {
	
	//멤버변수
	String name;
	String account;
	int balance;
	
	//기본 생성자	
	public Bank() {
		super();
	}
	
	//매개변수 생성자
	public Bank(String name, String account, int balance) {
		super();
		this.name = name;
		this.account = account;
		this.balance = balance;
	}
	
	//메소드
	//입금
	public void in() {
		System.out.println("--money deposit--");
	}
	
	
	//출금
	public void out() {
		System.out.println("--money withdraw--");
	}
	
	//추상메소드
	//적금
	public abstract void saving();
	
	//적금 해지
	public abstract void cancel();
	
	
	
	//정보출력
	public void getInfo() {
		System.out.printf("name : %s\n", name);
		System.out.printf("account : %s\n", account);
		System.out.printf("balance : %s\n", balance);
	}
	
	
	

}

