package com.yedam.classes;

public class MethodExe2 {
	// 기능이 구현되는 클래스에서는 System.out.println을 쓰면 안됨(아마)
	private Product[] store; // 필드

	MethodExe2() { // 생성자
		store = new Product[10];
		store[0] = new Product("A001", "지우개", 500);
		store[1] = new Product("B001", "샤프", 2000);
		store[2] = new Product("C001", "연필", 700);
		store[3] = new Product("D001", "샤프심", 300);
		store[4] = new Product("E001", "만년필", 50000);
	}

	boolean add(Product prd) {// 메소드 (매개변수의 타입으로 객체도 올 수 있음)
		for (int i = 0; i < store.length; i++) {
			if (store[i] == null) {
				store[i] = prd;
				return true;
			}
		}
		return false;
	}// add 끝

	Product[] productList(Product prd) {
		Product[] list = new Product[10];
		int idx = 0;
		for (int i = 0; i < store.length; i++) {
			if (store[i] != null) {
				if (prd.getProductName().equals("ALL") || store[i].getProductName().equals(prd.getProductName())) {
					if (store[i].getPrice() >= prd.getPrice()) {
						list[idx++] = store[i];
					}
				}
			}
		}
		return list;
	}

	// 삭제
	boolean remove(String code) {
		for (int i = 0; i < store.length; i++) {
			if (store[i] != null && store[i].getProductCode().equals(code)) {
				store[i] = null;
				return true;
			}
		}
		return false;
	}

	// 수정
	boolean modify(Product prod) {
		for (int i = 0; i < store.length; i++) {
			if (store[i] != null && store[i].getProductCode().equals(prod.getProductCode())) {
				// 상품명이 있으면 상품명도 바꿔줌
				if (prod.getProductName() != null) {
					store[i].setProductName(prod.getProductName());
				}
				// 가격이 있으면 가격도 바꿔줌
				if (prod.getPrice() != 0) { // int타입의 초기값은 0이라 null이 아니라 0으로 비교해줘야함
					store[i].setPrice(prod.getPrice());
				}
				return true;
			}
		}
		return false;
	}

}
