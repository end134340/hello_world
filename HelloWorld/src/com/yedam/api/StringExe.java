package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str = "Hello, World";
		str = new String("Hello, World");
		byte[] bAry = str.getBytes(); // 문자열을 키보드값으로 바꾸어? 바이트 배열로 반환
		for (int i = 0; i < bAry.length; i++) {
			System.out.println(bAry[i]);
		}

		byte[] bstr = { 72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100 };

		String msg = new String(bstr, 7, 5);
		System.out.println(msg);
		char result = msg.charAt(2); // 지정한 인덱스에 있는 문자열의 값을 정수로 반환.
		System.out.println((int) result);

		// String: "", char: ''
		if (result == 'r') {
			// 비교 구문

		}

		int idx = msg.indexOf("o"); // 있으면 인덱스 위치값, 없으면 -1 반환.
		if (idx != -1) {
			// 처리 코드
		}

		String[] names = { "홍길동", "홍길승", "김민규", "박홍길" };
		int cnt = 0;
		// 배열에서 어떤 문자를 포함하는 이름이 몇 개 존재하는지
		for (int i = 0; i < names.length; i++) {
			if (names[i].indexOf("홍") == 0) {
				cnt++;
			}
		}

		System.out.println("\"홍\"을 성으로 가지는 이름의 갯수: " + cnt);

		System.out.println("Hello, World".substring(3, 7)); // 전체 문자열에서 특정 위치의 값을 잘라냄. 매개값이 두개 주어지는 경우 범위 사이(해당 인덱스 미포함)의 문자열 잘라냄

	}//
}
