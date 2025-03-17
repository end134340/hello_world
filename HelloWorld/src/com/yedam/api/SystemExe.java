package com.yedam.api;

public class SystemExe {
	public static void main(String[] args) {
//		for (int i = 1; i <= 10; i++) {
//			if (i == 5) {
//				break; //단순 반복문 종료(코드가 끝까지 실행됨.)
//				System.exit(0); // 실행되고 있는 자바 가상 머신 강제종료(코드가 끝까지 실행되지 않음.) 매개값으로는 0혹은 1이 옴.
//			}
//		}
//		System.out.println("프로그램이 종료되었습니다.");

		// 프로그램 실행 소요 시간 구하기.
		long startTime = System.nanoTime();

		int sum = 0;
		for (int i = 1; i <= 1000000; i++) {
			sum += i;
		}

		long endTime = System.nanoTime();

		System.out.println("1부터 1000000까지의 합: " + sum);
		System.out.println("계산에 " + (endTime - startTime) + "나노초가 소요되었습니다.");

	}//
}
