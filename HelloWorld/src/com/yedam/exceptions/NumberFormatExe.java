package com.yedam.exceptions;

import java.util.Scanner;

public class NumberFormatExe {
	public static void main(String[] args) {

		try {
			exceptMethod();
		} catch (NumberFormatException e) {
			System.out.println("예외 떠넘기기 발생");
		} finally {
			System.out.println("예외가 발생했건, 안했건 예외와 관계 없이 반드시 실행 되어야 할 코드");
		}
		System.out.println("프로그램이 종료되었습니다.");
	}//

	// throws => 예외가 발생하면 메소드를 호출한 영역으로 떠넘김
	static void exceptMethod() throws NumberFormatException {
		Scanner scn = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		String strNo = scn.nextLine(); // "Ten";//개발자가 직접 값을 할당 => 리터럴?
		int no = 1;
		no = Integer.parseInt(strNo);
		System.out.println(no);

	}

}//