package com.yedam.interfaces;

public class OracleDao implements Dao {
	@Override
	public void insert() {
		System.out.println("Oracle용 등록 기능.");
	}

	@Override
	public void update() {
		System.out.println("Oracle용 수정 기능.");
	}

	@Override
	public void delete() {
		System.out.println("Oracle용 삭제 기능.");
	}

}//
