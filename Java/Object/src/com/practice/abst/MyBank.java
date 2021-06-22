package com.practice.abst;

public class MyBank extends Bank{

	public MyBank(String name, String account, int balance) {
		super(name, account, balance);
	}

	@Override
	public void saving() {
		System.out.println("--money saving--");
	}

	@Override
	public void cancel() {
		System.out.println("--money saving cancel--");		
	}

	
}

