package com.yedam.classes;

import java.util.ArrayList;
import java.util.List;

public class MethodExe2 {
	// 기능이 구현되는 클래스에서는 System.out.println을 쓰면 안됨(아마)
	private List<Product> store; // 필드

	MethodExe2() { // 생성자
		store = new ArrayList<Product>();
		store.add(new Product("A001", "지우개", 500));
		store.add(new Product("B001", "샤프", 2000));
		store.add(new Product("C001", "연필", 700));
		store.add(new Product("D001", "샤프심", 300));
		store.add(new Product("E001", "만년필", 50000));
	}

	boolean add(Product prd) {// 메소드 (매개변수의 타입으로 객체도 올 수 있음)
		boolean result = store.add(prd); // true false값을 반환함
		return result;
	}// add 끝

	List<Product> productList(Product prd) {
		List<Product> list = new ArrayList<Product>();
		for (int i = 0; i < store.size(); i++) {
			if (prd.getProductName().equals("ALL") || store.get(i).getProductName().equals(prd.getProductName())) {
				if (store.get(i).getPrice() >= prd.getPrice()) {
					list.add(store.get(i));
				}
			}
		}
		return list;
	}

	// 삭제
	boolean remove(String code) {
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i).getProductCode().equals(code)) {
				store.remove(i);
				return true;
			}
		}
		return false;
	}

	// 수정
	boolean modify(Product prod) {
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i).getProductCode().equals(prod.getProductCode())) {
				// 상품명이 있으면 상품명도 바꿔줌
				if (prod.getProductName() != null) {
					store.get(i).setProductName(prod.getProductName());
				}
				// 가격이 있으면 가격도 바꿔줌
				if (prod.getPrice() != 0) { // int타입의 초기값은 0이라 null이 아니라 0으로 비교해줘야함
					store.get(i).setPrice(prod.getPrice());
				}
				return true;
			}
		}
		return false;
	}

}
