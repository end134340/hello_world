package com.yedam.api;

public class StringTest {
	public static void main(String[] args) {

		// 주민등록번호 입력받아 성별 출력
		String[] ssn = { "9503061234567", "990603 2345678", "030502-3456789" };
		for (int i = 0; i < ssn.length; i++) {
			String gender = StringUtil.getGender(ssn[i]);
			System.out.println(gender);
		}

		// 파일 주소 입력받아 파일명, 확장자 출력
		String[] files = { "c:/temp/orange.jpg", "d:/storage/test/grape.jpeg", "d:/img/melon.png" };
		for (int i = 0; i < files.length; i++) {
			System.out.println("파일의 이름은 " + StringUtil.getFileName(files[i]));
			System.out.println("파일의 확장자는 " + StringUtil.getExtName(files[i]));
		}

	}//
}
