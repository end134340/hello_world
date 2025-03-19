package com.yedam.bookApp;

import java.util.List;
import java.util.Scanner;

//도서관리 프로그램(등록, 수정, 삭제, 목록)
public class BookMain {
	// 싱글톤: 프로그램에서 하나의 객체(인스턴스)만 만들도록 하는 방법.
	// 1. 생성자를 private로 생성.
	private BookMain() {

	}

	// 2. 자신의 타입(클래스)으로 정적 필드를 만들고 인스턴스를 할당.
	private static BookMain instance = new BookMain();

	// 3. getInstance() 메소드 제공
	public static BookMain getInstance() {
		// 정적 필드에서 참조하는 자신의 객체 리턴.
		return instance;
	}
	// 4. => BookApp에서 활용

	Scanner scn = new Scanner(System.in);
//	Book[] bookStore = new Book[100];
	boolean check = false;
	User[] users = new User[10];

	BookJdbc dao = new BookJdbc();

	// 책제목으로 조회해서 반환해주는 메소드
	private Book searchBook(String title) {
//		for (int i = 0; i < bookStore.length; i++) {
//			if (bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
//				return bookStore[i];
//			}
//		}
		return null;
	}

	// orderNo의 순번을 가지고와서 +1해서 반환해주는 메소드
//	private int getSequenceNo() {
//		int max = 0;
//		for (int i = 0; i < bookStore.length; i++) {
//			if (bookStore[i] != null && max < bookStore[i].getOrderNo()) {
//				max = bookStore[i].getOrderNo();
//			}
//		}
//		return max + 1;
//	}

	// 등록하는 메소드
	private void add() {
		System.out.println("등록할 도서의 제목을 입력해주세요.");
		System.out.print("  > ");
		String title = scn.nextLine();

		// 중복된 책 체크.
		if (searchBook(title) != null) {
			System.out.println("이미 등록된 책입니다. 다른 책을 등록해 주세요.");
			return;
		}

		System.out.println("등록할 도서의 저자를 입력해주세요.");
		System.out.print("  > ");
		String writer = scn.nextLine();

		System.out.println("등록할 도서의 출판사를 입력해주세요.");
		System.out.print("  > ");
		String company = scn.nextLine();

		System.out.println("등록할 도서의 가격을 입력해주세요.");
		System.out.print("  > ");
		int price = Integer.parseInt(scn.nextLine());

		if (title.isBlank() || writer.isBlank() || company.isBlank() || String.valueOf(price).isBlank()) {
			System.out.println("항목을 입력하여 주세요.");
			return; // 함수 종료
		}

		Book book = new Book(title, writer, company, price);

		if (dao.insert(book)) {
			System.out.println("도서가 정상적으로 등록되었습니다.");
		} else {
			System.out.println("도서가 정상적으로 등록되는데 실패했습니다. 다시 시도해 주세요.");
		}

	}// end of add();

	private void edit() {
		System.out.println("수정하고 싶은 도서의 코드를 입력하세요.");
		System.out.print("  > ");
		String bookCode = scn.nextLine();
		if (bookCode.isBlank()) {// isBlank() => 문자열의 값이 공백이면 true
			System.out.println("도서 코드를 반드시 입력하여 주세요.");
			return;
		}

		System.out.println("수정할 제목을 입력해주세요.");
		System.out.print("  > ");
		String reTitle = scn.nextLine();

		System.out.println("수정할 저자를 입력해주세요.");
		System.out.print("  > ");
		String reWriter = scn.nextLine();

		System.out.println("수정할 금액을 입력해주세요.");
		System.out.print("  > ");
		int rePrice = Integer.parseInt(scn.nextLine());

		Book book = new Book();
		book.setBookCode(bookCode);
		book.setTitle(reTitle);
		book.setWriter(reWriter);
		book.setPrice(rePrice);

		if (dao.update(book)) {
			System.out.println("성공적으로 수정되었습니다.");
		} else {
			System.out.println("도서 정보가 수정되지 못했습니다. 다시 시도해주세요.");
		}
	}

	private void delete() {
		check = false;
		String bookCode;
		while (true) {
			System.out.println("삭제하고 싶은 도서의 코드를 입력해주세요.");
			System.out.print("  > ");
			bookCode = scn.nextLine();

			if (bookCode.isBlank()) {
				System.out.println("도서 코드를 반드시 입력하여 주세요.");
			} else {
				break;
			}
		}

		if (dao.delete(bookCode)) {
			System.out.println("성공적으로 삭제되었습니다.");
		} else {
			System.out.println("도서가 삭제되지 못했습니다. 다시 시도해주세요.");
		}
	}

	private void list() {
		// 순번을 기준으로 정렬
		// 오름차순. j가 null이면 바꾸지 않고, j+1이 null인 경우에는 바꿈.

		System.out.println("순번 |   제목   |   저자   |   가격   ");
		System.out.println("=================================");

		List<Book> list = dao.list(null);

		for (Book books : list) {
			System.out.println(books.showList());
		}
	}

	private void selectOne() {
		System.out.println("조회하실 책의 코드를 입력해주세요.");
		System.out.print("  > ");
		String bcode = scn.nextLine();

		System.out.println("순번 |   제목   |   저자   |   가격   ");
		System.out.println("=================================");
		System.out.println(dao.select(bcode).showList());
	}

	private void listCompany() {
		String company;

		while (true) {
			System.out.println("조회하실 출판사를 입력해주세요.");
			System.out.print("  > ");
			company = scn.nextLine();

			if (company.isBlank()) {
				System.out.println("출판사를 다시 입력하여 주세요.");
			} else {
				break;
			}

		}

		System.out.println("   제목   |   저자   |  출판사  |   가격   ");
		System.out.println("======================================");
		List<Book> list = dao.list(company);

		for (Book books : list) {
			System.out.println(books.showListCompany());
		}
	}

	// list와 listCompany에서 활용할 공통 메소드
	private Book[] searchList(String keyword) {
		Book[] list = new Book[100];
//		int idx = 0;
//		for (int i = 0; i < bookStore.length; i++) {
//			if (bookStore[i] != null) {
//				if (keyword == null || bookStore[i].getCompany().equals(keyword)) {
//					list[idx++] = bookStore[i];
//				}
//			}
//		}
		return list;
	}

	private boolean login(String id, String pw) {
		for (int i = 0; i < users.length; i++) {
			if (users[i] != null && users[i].getUserId().equals(id) && users[i].getPassword().equals(pw)) {
				return true;
			}
		}
		return false;
	}

	public void main(String[] args) {
		// : 따로 인스턴스를 안 만들고 바로 실행할 수 있도록 클래스를 읽어들이는 시점에 메모리에 등록해줌
		init();
		boolean run = true;

		while (true) {
			System.out.println("로그인할 아이디와 비밀번호를 입력해주세요.");
			System.out.print(" 아이디: ");
			String uid = scn.nextLine();
			System.out.print("비밀번호: ");
			String upw = scn.nextLine();

			if (!login(uid, upw)) {
				System.out.println("아이디 혹은 비밀번호가 틀립니다. 다시 입력해주세요.");
				continue;
			}
			break;
		}

		while (run) {

			System.out.println("===============================================================================");
			System.out.println(" 1. 도서등록 | 2. 도서수정 | 3. 도서삭제 | 4. 목록출력 | 5. 상세조회 | 6. 조건조회 |  9. 종료  ");
			System.out.println("===============================================================================");
			int menu = 1;
			while (true) {
				try {
					System.out.print("메뉴를 선택해 주세요 > ");
					menu = Integer.parseInt(scn.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("메뉴는 숫자 정수 값을 입력해 주세요.");
				}
			}
			// nextInt()로는 숫자 입력과 함께 들어오는 엔터값 처리가 불가능하므로 parseInt를 사용해
			// 엔터 처리가 가능하지만 문자열인 nextLine() 감싸 사용
			switch (menu) {
			case 1: // 도서 등록
				add();
				break;
			case 2: // 도서 수정: 도서명 입력받아 금액 수정
				edit();
				break;
			case 3: // 도서 삭제: 도서명 입력받아 삭제
				// 반드시 값을 입력받도록
				delete();
				break;
			case 4: // 도서 목록 출력
				list();
				break;
			case 5: // 책 제목 입력받아 상세 조회
				selectOne();
				break;
			case 6: // 출판사 정보 입력받아 출력
				listCompany();
				break;
			case 9:
				run = false;
				break;
			default: // 메뉴에 없는 번호를 입력했을 시의 처리.
				System.out.println("메뉴를 다시 선택해 주세요.");
			}

		} // 프로그램 끝

		System.out.println("프로그램이 종료되었습니다.");

	}// 메인 끝

	public void init() {
//		bookStore[0] = new Book("감자도리", "감자", "밭", 13000, 1);
//		bookStore[1] = new Book("고구마요리", "고구마", "밭", 20000, 2);
//		bookStore[2] = new Book("어린왕자", "생텍쥐페리", "꿈", 17000, 3);
//		bookStore[3] = new Book("행복한왕자", "오스카 와일드", "꿈", 17000, 4);
//		bookStore[4] = new Book("백조 왕자", "안데르센", "꿈", 17000, 5);
//		bookStore[5] = new Book("이것이 자바다", "신용권", "한빛출", 17000, 6);

		users[0] = new User("userid", "user1", "userpw");
		users[1] = new User("thisid", "user2", "userpw");
		users[2] = new User("imuser", "user3", "userpw");
	}

}
