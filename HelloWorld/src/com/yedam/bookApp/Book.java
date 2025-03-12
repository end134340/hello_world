package com.yedam.bookApp;

//도서 관리 프로그램을 만들기 위한 클래스
public class Book {
	// 필드.
	private String title; // 책 제목
	private String writer; // 저자
	private String company; // 출판사
	private int price; // 가격
	private int orderNo; //등록번호??

	// 생성자

	// 매개값이 없는 기본 생성자
	public Book() {
	}

	// 매개값이 있는 생성자
	public Book(String title, String writer, String company, int price) {
		this.title = title;
		this.writer = writer;
		this.company = company;
		this.price = price;
	}

	public Book(String title, String writer, String company, int price, int orderNo) {
		this.title = title;
		this.writer = writer;
		this.company = company;
		this.price = price;
		this.orderNo = orderNo;
	}

	// 메소드.
	// set으로 값을 넣어줄 수 있게 만드는 메소드를 setter라고 함
	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public void setBooks(String title, String writer, String company, int price) {
		this.title = title;
		this.writer = writer;
		this.company = company;
		this.price = price;
	}

	// getter
	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getCompany() {
		return company;
	}

	public int getPrice() {
		return price;
	}
	
	public int getOrderNo() {
		return orderNo;
	}

	public String showBookInfo() {
		String msg = "제목은 " + title + ", 저자는 " + writer + "\n출판사는 " + company + ", 가격은 " + price + "원 입니다.";
		return msg;
	}

	public String showList() {
		return "  " + title + "     " + writer + "      " + price;
	}
	
	public String showListCompany() {
		return " " + title + "    " + writer + "     " + company + "    " + price;
	}
	
	public String showListWithNo() {
		return orderNo + "  " + title + "     " + writer + "      " + price;
	}

}// end of class