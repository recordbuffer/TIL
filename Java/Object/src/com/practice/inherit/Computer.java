package com.practice.inherit;

import java.util.Date;

public class Computer extends Product {
	// product �θ� Ŭ���� ��ӹ���
	
	private String cpu;
	private int ssd;
	private int ram;
	private String os;
	
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// �Ű����� ������ >> �θ� Ŭ���� + �ڽ� Ŭ���� 
	public Computer(String brand, String productNo, String productName, int price, Date date, String cpu, int ssd,
			int ram, String os) {
		super(brand, productNo, productName, price, date);
		this.cpu = cpu;
		this.ssd = ssd;
		this.ram = ram;
		this.os = os;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getSsd() {
		return ssd;
	}

	public void setSsd(int ssd) {
		this.ssd = ssd;
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
		return super.toString()+"\n"+"Computer [cpu=" + cpu + ", ssd=" + ssd + ", ram=" + ram + ", os=" + os + "]";
	}
	
	
	
}
