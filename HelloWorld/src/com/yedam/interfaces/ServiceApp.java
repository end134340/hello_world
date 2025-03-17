package com.yedam.interfaces;

public class ServiceApp {
	public static void main(String[] args) {
//		MysqlDao dao = new MysqlDao();
//		OracleDao dao = new OracleDao();
		// 인터페이스의 변수에 구현 클래스의 객체를 할당함
		Dao dao = new MysqlDao();
		// 등록
		dao.insert();
//		insert();
		// 수정
		dao.update();
		// 삭제
		dao.delete();
//		remove();

	}// 메인 끝

}
