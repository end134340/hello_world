package com.yedam.variable;

import java.util.Scanner;

public class VarExe6 {
	// 클래스 안에 메소드가 여러 개 올 수 있음.
	public static void test() {
		// 1부터 50사이의 임의의 정수 생성.
		// System.out.println((int)(Math.random() * 50) + 1); // 0보다 크거나 같으면서 1보다는 작은 실수
		// 생성

		// 학생의 점수 (30 ~ 100 사이의 임의의 값)
		// 정수(int) 5개 저장
		// 홀수의 값을 출력

		int[] scores = new int[5];

		for (int i = 0; i < scores.length; i++) {
			scores[i] += (int) (Math.random() * 71) + 30;
		}

		for (int i = 0; i < scores.length; i++) {
			if (scores[i] % 2 == 1) {
				System.out.println(scores[i]);
			}
		}
	} // end of test

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// test(); //test 메소드 호출.

		// 학생의 이름과 점수를 한 번에 담고 싶음
		// 학생의 이름과 점수를 담을 수 있는 클래스 선언 후 인스턴스 생성.
		Member m1 = new Member();
		m1.setName("홍길동");

		Member m2 = new Member();
		m2.setName("김말자");

		Member m3 = new Member();
		m3.setName("장미");

		Member m4 = new Member();
		m4.setName("강창호");

		// 배열
		Member[] members = { m1, m2, m3, m4 };

		// 70 ~ 100 사이의 임의의 값 생성해 점수 지정
		for (int i = 0; i < members.length; i++) {
			members[i].setScore((int) (Math.random() * 31) + 70);
//			System.out.println(members[i].name + ", " + members[i].score);
		}

		// 조회하고 싶은 이름을 입력하면 그 사람의 점수 출력
		System.out.println("조회할 이름을 입력하세요.");
		String search = scn.nextLine();

		for (int i = 0; i < members.length; i++) {
			if (members[i].getName().equals(search)) { // 문자열인 경우의 비교 구문 배열[].문자열키.equals(비교할 문자열); 일치하면 true를 반환.
				System.out.println(members[i].getName() + "의 점수는 " + members[i].getScore() + "점 입니다.");
			}
		}

		// 점수가 가장 높은 사람의 이름 출력.
//		int max = members[0].score;
//		String name = members[0].name;
//		for(int i = 0; i < members.length; i++) {
//			if(max < members[i].score) {
//				max = members[i].score;
//				name = members[i].name;
//			}
//		}
//		System.out.println("점수가 가장 높은 사람은 " + name + "이고 점수는 " + max + "점 입니다.");

	} // end of main
}
