package com.yedam.classes;

//정적(static) 멤버의 사용
//static: new 키워드 없이 클래스명.클래스멤버 의 형태로 접근해 사용 가능하게 만들어줌
public class MethodExe4 {

	static void test() {
		System.out.println("인스턴스 메소드");
	}

	static void main() {
		// 같은 인스턴스 메소드에서는 괜찮지만, static 메소드에서 인스턴스 메소드를 그냥 호출하려고 하면 오류가 남.
		// 그래서 호출하려는 메소드도 같은 정적 메소드로 만들어주어야 함.
		// 하지만 반대로 정적 메소드에서 인스턴스 메소드를 호출하는 것은 가능.
		test();
	}
}
