package com.yedam.inheritance;

//추상 클래스인 부모 클래스(Aniaml)가 가진 추상 메소드(sound)를 반드시 재정의해야함.
public class Bird extends Animal {

	@Override
	void sound() {
		System.out.println("짹짹");
	}

}
