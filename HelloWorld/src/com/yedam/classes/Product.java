package com.yedam.classes;

//상품 코드, 상품명, 가격에 대한 정보를 담고 있는 클래스.
public class Product {
	private String productCode;
	private String productName;
	private int price;

	Product() {
	}

	Product(String code, String name, int price) {
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
	
	//목록 보여주기
	public String showList() {
		return productCode + " " + productName + " " + price;
	}

}// 상품 클래스 끝
