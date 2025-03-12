package com.yedam.ref;

public class ArrayExe4 {
	public static void main(String[] args) {
		// 배열의 위치 바꾸기
		int[] intAry = { 8, 7, 6, 5, 4, 3, 2, 1 };
		int temp = intAry[0];

		// 배열의 위치를 오름차순으로 만들기 위한 공식
		// temp = intAry[0];
		// intAry[0] = intAry[1];
		// intAry[1] = temp;
		for (int j = 0; j < intAry.length - 1; j++) {
			// 배열의 크기보다 1 작은 수만큼 배열의 크기보다 1 작은 수 반복해줘야 하기 때문에 for문이 두개 돌아감
			for (int i = 0; i < intAry.length - 1; i++) {
				// i와 i+1번째의 값을 비교해 오름차순으로 변경
				if (intAry[i] > intAry[i + 1]) {
					temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}
			}
		}

		for (int ele : intAry) {
			System.out.print(ele + ", ");
		}
	}// 메인 끝
}
