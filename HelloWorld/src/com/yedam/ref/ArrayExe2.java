package com.yedam.ref;

import com.yedam.variable.Member;

public class ArrayExe2 {
	public static void main(String[] args) {
		// 문자열의 배열
		String[] strAry = { "Hello", "World", "20", "23.4" };
		// 확장된 for문.
		// for(배열의 값을 담을 변수 : 배열) => 배열의 크기만큼 반복함.
		for (String str : strAry) {
//			System.out.println(str);
		}

		// 크기 지정
		strAry = new String[10]; // 배열의 크기만 지정하고 값을 할당하지 않으면 크기가 10인 null값(문자 아님)을 가진 배열이 됨.
		strAry[0] = "Nice";
		strAry[1] = new String("Nice");
		for (String str : strAry) {
//			System.out.println(str);
		}

		// Member클래스
		Member[] memAry = new Member[10];
		// 다른 패키지에 있기 때문에? import 해줘야함
		memAry[0] = new Member(); // 여러가지 데이터 타입을 담고 있기 때문에 먼저 인스턴스를 생성해야함.
		memAry[0].setMember("홍길동", 80);
		memAry[0].setScore(90);
//		memAry[0].showInfo();

		memAry[1] = new Member(); // 객체를 참조하고 값을 지정하거나 불러올 때에는 null이 아니어야함
		memAry[1].setMember("김길동", 80);
		memAry[1].setScore(95);
//		memAry[1].showInfo();
		
		memAry[2] = new Member("김솔음", 88);
		//인스턴스를 생성한 다음 메소드를 사용해 값을 채워주는 게 아니라 생성자를 이용해 인스턴스를 생성하는 동시에 값을 채워줌.
		memAry[2].showInfo();

		for (int i = 0; i < memAry.length; i++) {
			if (memAry[i] != null) {
//				memAry[i].showInfo();
			}
		}
		
		
		
		
		

	}// end of main
}
