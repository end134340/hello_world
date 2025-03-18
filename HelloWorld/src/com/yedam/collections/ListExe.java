package com.yedam.collections;

import java.util.ArrayList;
import java.util.List;

import com.yedam.bookApp.Book;

public class ListExe {
	public static void main(String[] args) {
		int[] intAry = { 10, 20 };
		int[] intAry2 = new int[5]; // 기본 배열은 크기가 고정되어 있기 때문에 값을 추가할 경우에는 처리가 복잡해짐.(새 배열 선언해 기존 값 복사한 후 추가)
		for (int i = 0; i < intAry.length; i++) {
			intAry2[i] = intAry[i];
		}
		intAry2[2] = 30;

		// 컬렉션: 기본 데이터형 사용 불가. 클래스만 가능
		List<Integer> list = new ArrayList<Integer>(); // 기본 배열과 다르게 크기가 고정되어 있지 않음. null값을 고려하지 않아도 됨.
		list.add(10); // 값 추가
		list.add(20);
		list.add(17);
		list.add(9);

		Integer lt1 = list.get(0); // 값 조회(인덱스 값 기준)

		list.remove(0); // 값 삭제(인덱스 값 기준)

		list.set(0, 30); // 갑 수정(인덱스, 값)

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)); // 값을 가져올 때에는 get(인덱스) 사용.
		}

		// List(인터페이스) ArrayList(구현된 클래스) <제너릭>: 선언하는 시점에 어떠한 값을 담겠다고 미리 지정
		List<String> list2 = new ArrayList<String>();
		list2.add("Hello");
//		list2.add(200);
//		list2.add(new Book());

		for (int i = 0; i < list2.size(); i++) {
			String result = (String) list2.get(i); // Object는 모든 클래스의 상위 클래스이므로 자식 클래스의 값을 담으려면 Casting이 필요.
		}
		
		List<Book> list3 = new ArrayList<Book>();
		list3.add(new Book());
		
		
		

	}// 메인 끝
}
