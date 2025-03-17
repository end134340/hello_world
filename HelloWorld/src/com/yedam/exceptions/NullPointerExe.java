package com.yedam.exceptions;

public class NullPointerExe {
	public static void main(String[] args) {
		String str = "Hello";
		int[] intAry = { 10, 20 };

		// 예외처리
		try {
			System.out.println(str.toString());
			intAry[2] = 30; //배열의 크기를 벗어난 값 할당
		} catch (NullPointerException e) {
			// 예외를 대체하는 코드
			System.out.println("NULL값을 참조하고 있습니다.");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 크기를 초과했습니다.");
		}

		System.out.println("프로그램 종료");
	}
}
