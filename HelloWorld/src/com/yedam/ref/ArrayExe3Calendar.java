package com.yedam.ref;

public class ArrayExe3Calendar {
	// 2025년 기준으로 월 정보 => 1일의 위치를 반환
	public static int getFirstDay(int month) {
		switch (month) {
		case 1:
			return 3;
		case 2:
			return 6;
		case 3:
			return 6;
		case 4:
			return 2;

		default:
			return 1;
		}
	}

	// 월의 마지막 날 반환해주는 메소드
	public static int getLastDay(int month) {
		switch (month) {
		case 2:
			return 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 31;
		}
	}

	public static void main(String[] args) {
		// 1 ~ 31까지 콘솔에 출력. 7의 배수가 되면 println을 사용해서 줄바꿈을 시킬 수 있도록.
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		for (String day : days) {
			System.out.print(" " + day);
		}
		System.out.println();
		int month = 3;
		int space = getFirstDay(month); // 공백이 몇인지 알려주는 변수(1일이 언제부터 시작하는지 알려줌)
		int lastDate = getLastDay(month); // 마지막 날
		for (int i = 0; i < space; i++) {
			System.out.print("    ");
		}
		for (int i = 1; i <= lastDate; i++) {
			// 정수를 문자열로 변환해주는 메소드
			if (String.valueOf(i).length() == 1) {
				// String.valueOf(문자열).length() 10 이상의 두자릿수를 판별하기 위해 문자가 몇 자인지 알려주는...
				if ((space + i) % 7 == 1) {
					System.out.print("\u001B[31m" + "   " + i + "\u001B[0m");
				} else {
					System.out.print("   " + i);
				}
			} else if (String.valueOf(i).length() == 2) {
				if ((space + i) % 7 == 1) {
					System.out.print("\u001B[31m" + "  " + i + "\u001B[0m");
				} else {
					if (month == 3 && i == 21) {
						System.out.print("  " + "평가");
					} else {
						System.out.print("  " + i);
					}
				}
			}
			//
			if ((space + i) % 7 == 0) {
				System.out.println();
			}
		}
	}
}
