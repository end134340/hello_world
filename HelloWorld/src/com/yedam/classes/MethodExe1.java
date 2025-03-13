package com.yedam.classes;

public class MethodExe1 {
	// 메소드에는 리턴타입 메소드명 (매개변수(필요한 경우)){}이 필요.

	void printString(int times, String str) {
		for (int i = 1; i <= times; i++) {

			System.out.println(str);
		}
	}

	int sum(int n1, int n2) {
		int result = 0;
		result = n1 + n2;
		return result;
	}

	// 메소드 오버로딩(같은 이름으로 재정의)
	double sum(double n1, double n2) {
		return (n1 + n2);
	}

	// 배열의 합
	int sum(int[] ary) {
		int result = 0;
		for (int i = 0; i < ary.length; i++) {
			result += ary[i];
		}
		return result;
	}

	// double타입의 배열을 매개변수로 받아서 반환도 double
	double sum(double[] ary) {
		double result = 0.0;
		for (int i = 0; i < ary.length; i++) {
			result += ary[i];
		}
		return result;
	}

}
