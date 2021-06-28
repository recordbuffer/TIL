package com.practice.inherit;

import java.util.Date;

public class Computer extends Product {
	// product �θ� Ŭ���� ��ӹ���
	
	private String cpu;
	private int hdd;
	private int ram;
	private String os;
	
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// �Ű����� ������ >> �θ� Ŭ���� + �ڽ� Ŭ���� 
	public Computer(String brand, String productNo, String productName, int price, Date date, String cpu, int hdd,
			int ram, String os) {
		super(brand, productNo, productName, price, date);
		this.cpu = cpu;
		this.hdd = hdd;
		this.ram = ram;
		this.os = os;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getHdd() {
		return hdd;
	}

	public void setHdd(int hdd) {
		this.hdd = hdd;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", hdd=" + hdd + ", ram=" + ram + ", os=" + os + "]";
	}

	

	
	
}
