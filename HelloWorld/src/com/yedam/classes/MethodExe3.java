package com.yedam.classes;

public class MethodExe3 {

	// 구구단 출력 메소드
	String gugudan(int dan, int toNum) {
		String str = "";
		for (int i = dan; i <= toNum; i++) {
			str += "구구단 " + i + "단\n";
			for (int j = 1; j <= 9; j++) {
				str += i + " X " + j + " = " + i * j + "\n";
			}
		}
		return str;
	}

	// 별찍기
	void printStar(int cnt, String str) {
		for (int i = 1; i <= cnt; i++) {
			String out = "";
			for (int j = 0; j < i; j++) {
				out += str;
			}
			System.out.println(out);
		}

	}

	// 카드번호 보여주기
	void printCard() {
		// 배열 선언
		int[] intAry = new int[16];
		int num = 0;
		// 1 ~ 16까지의 임의수 할당
		for (int i = 0; i < intAry.length; i++) {
			num = (int) (Math.random() * 16) + 1;

			for (int su : intAry) {
				if (su == num) {
					num = (int) (Math.random() * 16) + 1;
					continue;
				} else {
					intAry[i] = num;
				}
			}

		}

		// 출력
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("%3d", intAry[i]);
			if (i % 4 == 3) {
				System.out.println();
			}

		}
	}

}
