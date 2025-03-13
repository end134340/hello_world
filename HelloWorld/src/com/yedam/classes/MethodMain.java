package com.yedam.classes;

public class MethodMain {
	public static void main(String[] args) {
		MethodExe3 m3 = new MethodExe3();
//		System.out.println(m3.gugudan(3, 5));
//		m3.printStar(5, "★");
		m3.printCard();

	}// 메인 끝

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
}
