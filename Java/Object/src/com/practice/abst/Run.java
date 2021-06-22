package com.practice.abst;

public class Run {

	public static void main(String[] args) {
		
		Bank myBank = new MyBank("ȫ�浿","122-343-55533-1",100000);
		
		myBank.in();
		myBank.out();
		myBank.saving();
		myBank.cancel();
		
		System.out.println("----------------------");
		myBank.getInfo();
	}

}

