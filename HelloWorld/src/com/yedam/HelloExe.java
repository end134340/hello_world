package com.yedam;

public class HelloExe {
	// 기능(함수) = main 메소드( 매개값(배열) )

	String name;
	String phone;
	int age;

	HelloExe(String name, String phone, int age) {
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	public static void main(String[] args) {
		// main이라는 메소드는 기본 메소드이기 때문에 정의하지 않으면 기본 메소드를 정의하라는 오류가 남.

		int num = 32000;

		int[] intAry = { 34, 32, 88, 23 };

		String str = "32";

		int num2 = Integer.parseInt(str);

		String[] strAry = { "Hello", "Nice", "Good" };

		int[] intAry2 = new int[5];

		for (int i = 0; i < intAry2.length; i++) {
			intAry2[i] = (int) ((Math.random() * 41) + 60);
		}

		HelloExe h1 = new HelloExe("홍길동", "010-2434-3454", 19);

		HelloExe[] hAry = new HelloExe[3];

		hAry[0] = new HelloExe("홍길동", "010-1234-1234", 20);
		hAry[1] = new HelloExe("김민식", "010-2222-2222", 22);
		hAry[2] = new HelloExe("최문식", "010-3333-3333", 23);

		int max = hAry[0].age;
		String nm = "";
		for (int i = 0; i < hAry.length; i++) {
			if (max < hAry[i].age) {
				max = hAry[i].age;
				nm = hAry[i].name;
			}
		}
		System.out.println("나이가 가장 많은 사람은 " + nm + "입니다.");

	}// main 끝

	void method1() {
		System.out.println("Hello, World.");

		String name;
		name = "김시인";

		System.out.println("이름은 " + name + "입니다.");

		int score = 100; // 변수 선언하며 값을 넘어줌 = 초기값 할당

		System.out.println("점수는 " + score + "점 입니다.");
		System.out.println("변경된 부분입니다.");
	}

}
