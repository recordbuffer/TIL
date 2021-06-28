package com.practice.inherit;

import java.util.Date;

public class Product {
	//부모클래스 >> 모든 상품에 대한 공통 요소 추출
	
	private String brand;
	private String productNo;
	private String productName;
	private int price;
	private Date date;
	
	public Product() {
		super();
	}

	public Product(String brand, String productNo, String productName, int price, Date date) {
		super();
		this.brand = brand;
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.date = date;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Product [brand=" + brand + ", productNo=" + productNo + ", productName=" + productName + ", price="
				+ price + ", date=" + date + "]";
	}
	
}
