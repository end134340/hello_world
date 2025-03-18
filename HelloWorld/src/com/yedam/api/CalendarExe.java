package com.yedam.api;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		// 원하는 날짜로 변경하기
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DATE, 17);
		cal.set(2023, 2, 17);

		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 요일
		System.out.println(cal.getActualMaximum(Calendar.DATE));// 월의 마지막 날

		// 년, 월을 입력하면 그 달의 1일의 요일, 말일을 반환하는 메소드.
		System.out.println("1일의 요일은 " + getDay(2025, 7));
		System.out.println("말일은 " + getLastDate(2025, 7));

	}// 메인 끝

	static String getDay(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		int day = cal.get(Calendar.DAY_OF_WEEK);

		switch (day) {
		case 1:
			return "일요일";
		case 2:
			return "월요일";
		case 3:
			return "화요일";
		case 4:
			return "수요일";
		case 5:
			return "목요일";
		case 6:
			return "금요일";
		case 7:
			return "토요일";
		}
		return "";
	}

	static int getLastDate(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		
		return cal.getActualMaximum(Calendar.DATE);
	}

}//
