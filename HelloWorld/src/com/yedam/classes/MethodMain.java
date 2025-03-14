package com.yedam.classes;

import java.util.Scanner;

public class MethodMain {
	public static void main(String[] args) {
		officeApp();

	}// 메인 끝

	static void officeApp() {
		MethodExe2 m2 = new MethodExe2(); // 기능 정의

		// 사용자의 입력을 받아 기능 구현
		// 1.목록 2.추가 3.수정 4.삭제 9.종료

		boolean run = true;
		Scanner scn = new Scanner(System.in);

		while (run) {
			System.out.println("===========================================");
			System.out.println(" 1. 목록 | 2. 추가 | 3. 수정 | 4. 삭제 | 9. 종료 ");
			System.out.println("===========================================");
			System.out.print("  > ");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 목록 출력
				Product prd = new Product();
				prd.setProductName("ALL");
				Product[] list = m2.productList(prd);
				for (int i = 0; i < list.length; i++) {
					if (list[i] != null) {
						System.out.println(list[i].showList());
					}
				}
				break;
			case 2: // 추가
				System.out.println("추가하실 상품의 코드를 입력하여 주세요.");
				System.out.print("  > ");
				String code = scn.nextLine();

				System.out.println("추가하실 상품의 이름을 입력하여 주세요.");
				System.out.print("  > ");
				String name = scn.nextLine();

				System.out.println("추가하실 상품의 가격을 입력하여 주세요.");
				System.out.print("  > ");
				String price = scn.nextLine();

				if (code.isBlank() || name.isBlank() || price.isBlank()) {
					System.out.println("상품을 등록할 때에는 빈 값을 등록할 수 없습니다.");
					break;
				}
				prd = new Product(code, name, Integer.parseInt(price));

				if (m2.add(prd)) {
					System.out.println("상품이 정상적으로 등록되었습니다.");
				} else {
					System.out.println("상품이 등록되지 못했습니다. 다시 시도해주세요.");
				}

				break;
			case 3: // 수정
				while (true) {
					System.out.println("수정하실 상품의 코드를 입력하여 주세요.");
					System.out.print("  > ");
					code = scn.nextLine();

					if (code.isBlank()) {
						System.out.println("상품 코드는 비워둘 수 없습니다.");
					} else {
						break;
					}

				}

				System.out.println("수정하실 상품의 이름을 입력하여 주세요. (수정하지 않고 스킵: 엔터)");
				System.out.print("  > ");
				name = scn.nextLine();

				System.out.println("수정하실 상품의 가격을 입력하여 주세요. (수정하지 않고 스킵: 엔터)");
				System.out.print("  > ");
				price = scn.nextLine();

				if (name.isBlank()) {
					name = null;
				}
				if (price.isBlank()) {
					price = "0";
				}

				prd = new Product(code, name, Integer.parseInt(price));

				if (m2.modify(prd)) {
					System.out.println("상품이 정상적으로 수정되었습니다.");
				} else {
					System.out.println("상품이 수정되지 않았습니다. 다시 시도해주세요.");
				}
				break;
			case 4: // 삭제
				while (true) {
					System.out.println("삭제하실 상품의 코드를 입력하여 주세요.");
					System.out.print("  > ");
					code = scn.nextLine();

					if (code.isBlank()) {
						System.out.println("상품 코드는 비워둘 수 없습니다.");
					} else {
						break;
					}
				}

				if (m2.remove(code)) {
					System.out.println("상품이 정상적으로 삭제되었습니다.");
				} else {
					System.out.println("상품이 삭제되지 않았습니다. 다시 시도해 주세요.");
				}

				break;
			case 9: // 종료
				run = false;
				break;
			default:
				System.out.println("올바른 메뉴를 선택하여 주세요.");
			}
		}
		System.out.println("프로그램이 종료되었습니다.");

	}// officeApp 종료.

	void method1() {
		MethodExe1 m1 = new MethodExe1(); // 클래스의 생성자를 호출
//		System.out.println(m1);
		// 메소드 호출(실제 값이 들어가야함)
		int n = 5;
		m1.printString(n, "★");
		// return 타입이 void인 경우 결과를 변수에 담을 수 없음(반환되는 값이 없으므로)

		double result = m1.sum(n, 9.5);
		// return 타입이 void가 아닌 반환되는 값이 있는 메소드의 경우 같은 타입의 변수에 담아줄 수 있음.
		System.out.println(result);

		int sum = m1.sum(new int[] { 10, 20, 30 });
		System.out.println(sum);

		double sum2 = m1.sum(new double[] { 4.5, 7.3, 6.8 });
		System.out.println(sum2);
	}

	void method2() {
		// 상품 코드: M001, 상품명: 만년필, 가격: 10000원

		MethodExe2 m2 = new MethodExe2();
		if (m2.add(new Product("M001", "만년필", 10000))) {
			System.out.println("상품 등록이 완료되었습니다");
		} else {
			System.out.println("상품 등록에 실패했습니다");
		}

		if (m2.remove("A001")) {
			System.out.println("상품을 성공적으로 삭제했습니다.");
		} else {
			System.out.println("상품을 삭제하지 못했습니다. 다시 시도해주세요.");
		}
		Product prod = new Product("M001", null, 200000);
		if (m2.modify(prod)) {
			System.out.println("상품이 성공적으로 수정되었습니다.");
		}

		Product search = new Product();
		search.setProductName("만년필");
//				search.setPrice(700); //숫자 이상인 가격만 검색해서 출력하도록

		Product[] list = m2.productList(search);

		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				System.out.println(list[i].showList());
			}
		}
	}

	void method3() {
		MethodExe3 m3 = new MethodExe3();
//		System.out.println(m3.gugudan(3, 5));
//		m3.printStar(5, "◈");
//		m3.printCard();
	}

	void method4() {
		MethodExe4 m4 = new MethodExe4();
		MethodExe4.main();
	}
}
