package com.yedam.inheritance;

public class AnimalExe {
	public static void main(String[] args) {
//		Animal animal = new Animal(); //추상클래스는 직접 인스턴스를 생성할 수 없음.
		Animal animal = new Bird();
		animal.sound();
		animal.eat();
	}
}
