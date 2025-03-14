package com.yedam.bookApp;

//실행 클래스(main 메소드를 담고 있어 실행하는 클래스)
public class BookApp {
	public static void main(String[] args) {
//		BookMain mainApp1 = new BookMain();
//		mainApp1.main(args);

//		BookMain mainApp2 = new BookMain();

		// mainApp1과 mainApp2는 서로 다른 객체(인스턴스)
//		mainApp1.add(); //1번에 등록
//		mainApp1.list();

//		mainApp2.list();

		// BookMain의 인스턴스를 하나만 만들 수 있도록 싱글톤 방식?을 사용했기 때문에 생성자로 새 인스턴스를 만들지 못하고 만들어진
		// 인스턴스를 하나 가져와(getInstance) 사용.
		// mainApp1과 mainApp2는 같은 객체를 참조하고 있기 때문에 위와는 다르게 같은 결과(mainApp1에 등록한 책이
		// mainApp2의 목록에도 나옴)가 나옴
		BookMain mainApp1 = BookMain.getInstance();

		BookMain mainApp2 = BookMain.getInstance();

//		mainApp1.add(); // 1번에 등록
//		mainApp1.list();
//
//		mainApp2.list();

		// 숙제:
		// 1번) BookMain의 main메소드를 통해서만 기능활용하도록 하세요.
		// User 클래스를 생성하고
		// BookMain에 User[]을 선언해서 회원을 3명 등록하기.
		// BookMain에 login메소드를 선언하고 매개값으로 아이디와 비밀번호를 입력받도록 한다.
		// login메소드는 User[]에 등록된 회원중에서 입력받은 아이디와 비밀번호가 있으면 로그인성공 아니면 실패.
		// login성공 했을 경우에만 1번) main메소드를 실행하도록 한다
		
		mainApp1.main(args);

	}// 메인 끝
}
