package com.yedam.classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MethodExe2 {
	// 기능이 구현되는 클래스에서는 System.out.println을 쓰면 안됨(아마)
	private List<Product> store; // 필드

	MethodExe2() { // 생성자
		init();

	}

	void init() {
		store = new ArrayList<Product>();
//		try {
//			Scanner scn = new Scanner(new FileInputStream("c:/temp/message.txt"));
//			while (true) {
//				String msg = scn.nextLine();
//				String[] msgAry = msg.split(" ");
//				store.add(new Product(msgAry[0], msgAry[1], Integer.parseInt(msgAry[2])));
//
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (NoSuchElementException e) {
//
//		}

		try {
			FileInputStream fis = new FileInputStream("c:/temp/product.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			store = (List<Product>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 종료시점에 store의 정보를 message.txt에 저장. => 다시 시작하면 이전에 저장된 데이터를 기반으로 프로그램 실행.
	void save() {
//		try {
//			Writer writer = new FileWriter("c:/temp/message.txt");
//
//			while (true) {
//				for (int i = 0; i < store.size(); i++) {
//					String msg = store.get(i).getProductCode() + " "//
//							+ store.get(i).getProductName() + " " //
//							+ store.get(i).getPrice() + "\n";
//					writer.write(msg);
//					writer.flush();
//				}
//				break;
//			}
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/product.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(store);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
