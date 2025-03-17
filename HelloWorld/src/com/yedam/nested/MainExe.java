package com.yedam.nested;

public class MainExe {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method1();

		// 중첩된 내부 클래스의 객체 생성
		Outer.Inner inner = outer.new Inner();
		inner.innerMethod();
	}
}
