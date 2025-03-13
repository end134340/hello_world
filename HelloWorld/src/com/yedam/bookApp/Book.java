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

	//매개값을 달리 하는 생성자를 여러개 선언(재정의)하는 것을 오버로딩이라고 함
	//오버로딩을 할 때 매개변수명이 아닌 데이터 타입을 기준으로 구분하기 때문에 오버로딩을 할 때에는 이미 있는 생성자와 다른 데이터타입의 매개변수들을 받아야 함.
	public Book(String title, String writer, String company, int price, int orderNo) {
//		this.title = title;
//		this.writer = writer;
//		this.company = company;
//		this.price = price;
		//this라는 키워드는 만들어진(생성된) 인스턴스를 기리킴.
		this(title, writer, company, price); //의 식으로 자기 자신이 가지고 있는 자원들 중 생성자도 this로 가리킬 수 있음.
		//이 경우에는 위의 title, writer, company, price를 매개값으로 가지는 생성자를 뜻함.
		//생성자 안에서 this를 사용하기 위해서는 생성자의 첫 줄에 위치해야함
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