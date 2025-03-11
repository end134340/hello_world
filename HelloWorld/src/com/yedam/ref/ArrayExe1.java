package com.yedam.ref;

public class ArrayExe1 {
	public static void main(String[] args) {
		int[] intAry = { 10, 20, 30 }; // 초기값 할당

		for (int i = 0; i < intAry.length; i++) {
//			System.out.println(intAry[i]);
		}

		intAry = new int[] { 40, 50, 60 }; // 재할당하고 싶으면 초기값 할당처럼 하면 안되고 이런 방식으로...

		intAry = new int[10]; // 배열의 크기만 정해주면 초기값인 0이 들어간 배열이 생성.
		intAry[3] = 30;
		intAry[9] = 90;

//		intAry[10] = 100; //예외 발생(크기가 정해진 배열에 범위 밖의 index에 값을 할당하려고 하면 오류가 남)

		intAry[0] = (int) (Math.random() * 100) + 1;

		for (int i = 0; i < intAry.length; i++) {
			if (intAry[i] == 0) {
				intAry[i] += (int) (Math.random() * 100) + 1;
			}
		}

		// 홀수값의 합 구하기
		// "홀수값의 합은 n입니다.
		int odd = 0;
		for (int i = 0; i < intAry.length; i++) {
			System.out.println(i + "번째 값은 " + intAry[i]);
			if (intAry[i] % 2 != 0) {
				odd += intAry[i];
			}
		}
		System.out.println("홀수값의 합은 " + odd + "입니다.");

	}// end of main
}
