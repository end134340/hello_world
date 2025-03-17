package com.yedam.interfaces;

//인터페이스의 상속(?): implements
public class MysqlDao implements Dao {
	@Override
	public void insert() {
		System.out.println("mysql용 등록 기능");
	}

	@Override
	public void update() {
		System.out.println("mysql용 수정 기능");

	}

	@Override
	public void delete() {
		System.out.println("mysql용 삭제 기능");

	}
}//
