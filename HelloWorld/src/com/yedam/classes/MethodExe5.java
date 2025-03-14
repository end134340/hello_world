package com.yedam.classes;

public class MethodExe5 {
	public static void main(String[] args) {
		// 상수(final) 선언.
		int num1 = 10;
		num1 = 20;

		final int num2 = 20;
//		num2 = 30; //상수는 변경 불가

		final Product p1 = new Product();
		p1.setProductCode("F001");

		p1.setProductCode("G001");
		// 변수의 값을 바꾸는 게 아니라 필드의 값을 바꾸는 것이기 때문에 상관 없음.

//		p1 = new Product(); //이 경우에는 변수에 새로운 객체를 담는 것이기 때문에 값이 변경되어 오류가 남.
	}
}
