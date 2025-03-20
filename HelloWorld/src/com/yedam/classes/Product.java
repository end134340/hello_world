package com.yedam.classes;

import java.io.Serializable;

//상품 코드, 상품명, 가격에 대한 정보를 담고 있는 클래스.
public class Product implements Serializable { //Serializable: 객체를 직렬화, 역직렬화 하기 위해 필요한 인터페이스
	private String productCode;
	private String productName;
	private int price;

	Product() {
	}

	public Product(String code, String name, int price) {
		productCode = code;
		productName = name;
		this.price = price;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	// 목록 보여주기
	public String showList() {
		return productCode + " " + productName + " " + price;
	}

}// 상품 클래스 끝
