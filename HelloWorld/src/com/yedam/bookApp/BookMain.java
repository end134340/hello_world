package com.yedam.bookApp;

import java.util.Scanner;

//도서관리 프로그램(등록, 수정, 삭제, 목록)
public class BookMain {

	static Scanner scn = new Scanner(System.in);
	static Book[] bookStore = new Book[100];
	static boolean check = false;

	// 책제목으로 조회해서 반환해주는 메소드
	public static Book searchBook(String title) {
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				return bookStore[i];
			}
		}
		return null;
	}

	// orderNo의 순번을 가지고와서 +1해서 반환해주는 메소드
	public static int getSequenceNo() {
		int max = 0;
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null && max < bookStore[i].getOrderNo()) {
				max = bookStore[i].getOrderNo();
			}
		}
		return max + 1;
	}

	// 등록하는 메소드
	public static void add() {
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

		Book book = new Book(title, writer, company, price, getSequenceNo());

		for (int i = 0; i < bookStore.length; i++) {
			// 배열의 빈 값에 입력받은 정보를 넣어줌
			if (bookStore[i] == null) {
				bookStore[i] = book;
				System.out.println("도서가 정상적으로 등록되었습니다.");
				break;
			}
		}
	}// end of add();

	public static void edit() {
		System.out.println("수정하고 싶은 도서의 제목을 입력하세요.");
		System.out.print("  > ");
		String title = scn.nextLine();
		check = false;
		if (title.isBlank()) {// isBlank() => 문자열의 값이 공백이면 true
			System.out.println("책 제목을 반드시 입력하여 주세요.");
			return;
		}

		for (int i = 0; i < bookStore.length; i++) {
			if (searchBook(title) != null) {
				System.out.println(title + "의 수정할 제목을 입력해주세요. 현재 제목: " + bookStore[i].getTitle());
				System.out.print("  > ");
				String reTitle = scn.nextLine();

				System.out.println(title + "의 수정할 저자를 입력해주세요. 현재 저자: " + bookStore[i].getWriter());
				System.out.print("  > ");
				String reWriter = scn.nextLine();

				System.out.println(title + "의 수정할 출판사를 입력해주세요. 현재 출판사: " + bookStore[i].getCompany());
				System.out.print("  > ");
				String reCompany = scn.nextLine();

				System.out.println(title + "의 수정할 금액을 입력해주세요. 현재 금액: " + bookStore[i].getPrice());
				System.out.print("  > ");
				int rePrice = Integer.parseInt(scn.nextLine());

				if (reTitle.isBlank()) {
					reTitle = bookStore[i].getTitle();
				}
				if (reWriter.isBlank()) {
					reWriter = bookStore[i].getWriter();
				}
				if (reCompany.isBlank()) {
					reCompany = bookStore[i].getCompany();
				}
				if (String.valueOf(rePrice).isBlank()) {
					rePrice = bookStore[i].getPrice();
				}
				bookStore[i].setBooks(reTitle, reWriter, reCompany, rePrice);
				System.out.println("성공적으로 수정되었습니다.");
				check = true;
				break;
			} else {
				check = false;
			}
		}
		if (!check) {
			System.out.println("수정하려는 도서가 목록에 없습니다. 도서명을 올바르게 입력하였는지 확인하여 주세요.");
			return;
		}
	}

	public static void delete() {
		check = false;
		String title;
		while (true) {
			System.out.println("삭제하고 싶은 도서의 제목을 입력해주세요.");
			System.out.print("  > ");
			title = scn.nextLine();

			if (title.isBlank()) {
				System.out.println("책 제목을 반드시 입력하여 주세요.");
			} else {
				break;
			}
		}
		for (int i = 0; i < bookStore.length; i++) {
			if (searchBook(title) != null) {
				bookStore[i] = null;
				System.out.println("성공적으로 삭제되었습니다.");
				check = true;
				break;
			} else {
				check = false;
			}
		}
		if (!check) {
			System.out.println("삭제하려는 도서가 목록에 없습니다. 도서명을 올바르게 입력하였는지 확인하여 주세요.");
			return;
		}
	}

	public static void list() {
		// 순번을 기준으로 정렬
		// 오름차순. j가 null이면 바꾸지 않고, j+1이 null인 경우에는 바꿈.
		Book temp = null;
		for (int i = 0; i < bookStore.length - 1; i++) {
			for (int j = 0; j < bookStore.length - 1; j++) {
				if (bookStore[j + 1] == null) {
					continue; // 아무것도 하지 않고 다시 반복문 실행.
				}
				if (bookStore[j] == null || bookStore[j].getOrderNo() > bookStore[j + 1].getOrderNo()) {
					temp = bookStore[j + 1];
					bookStore[j + 1] = bookStore[j];
					bookStore[j] = temp;
				}
			}
		}

		int seqNo = 1;

		System.out.println("순번 |   제목   |   저자   |   가격   ");
		System.out.println("=================================");

		for (Book books : bookStore) {
			if (books != null) {
				System.out.println(seqNo++ + " " + books.showList());
			}
		}
	}

	public static void selectOne() {
		String title = null;
		check = false;
		while (true) {
			System.out.println("상세 조회하실 책의 제목을 입력하여 주세요.");
			System.out.print("  > ");
			title = scn.nextLine();

			if (title.isBlank()) {
				System.out.println("책 제목을 다시 입력해주세요.");
			} else {
				break;
			}
		} // 책제목 미입력시 나오는 while문 끝

		for (int i = 0; i < bookStore.length; i++) {
			if (searchBook(title) != null) {
				System.out.println(bookStore[i].showBookInfo());
				check = true;
				break;
			} else {
				check = false;
			}
		}
		if (!check) {
			System.out.println("찾으시려는 도서가 목록에 없습니다. 도서명을 올바르게 입력하였는지 확인하여 주세요.");
			return;
		}
	}

	public static void selectComp() {
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

		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null && bookStore[i].getCompany().equals(company)) {
				System.out.println(bookStore[i].showListCompany());
			}
		}

	}

	public static void main(String[] args) {
		// static: 따로 인스턴스를 안 만들고 바로 실행할 수 있도록 클래스를 읽어들이는 시점에 메모리에 등록해줌
		init();
		boolean run = true;

		while (run) {
			System.out.println("===============================================================================");
			System.out.println(" 1. 도서등록 | 2. 도서수정 | 3. 도서삭제 | 4. 목록출력 | 5. 상세조회 | 6. 조건조회 |  9. 종료  ");
			System.out.println("===============================================================================");
			System.out.print("메뉴를 선택해 주세요 > ");
			int menu = Integer.parseInt(scn.nextLine()); // nextInt()로는 숫자 입력과 함께 들어오는 엔터값 처리가 불가능하므로 parseInt를 사용해
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
				selectComp();
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

	public static void init() {
		bookStore[0] = new Book("감자도리", "감자", "밭", 13000, 1);
		bookStore[1] = new Book("고구마요리", "고구마", "밭", 20000, 2);
		bookStore[2] = new Book("어린왕자", "생텍쥐페리", "꿈", 17000, 3);
		bookStore[3] = new Book("행복한왕자", "오스카 와일드", "꿈", 17000, 4);
		bookStore[4] = new Book("백조 왕자", "안데르센", "꿈", 17000, 5);
		bookStore[5] = new Book("이것이 자바다", "신용권", "한빛출", 17000, 6);
	}

}
