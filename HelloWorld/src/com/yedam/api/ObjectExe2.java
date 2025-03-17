package com.yedam.api;

import java.text.SimpleDateFormat;
import java.util.Date; //많이 쓰여짐

public class ObjectExe2 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		System.out.println(obj1.toString());

		Date obj2 = new Date();
		System.out.println(obj2.toString());

		// 2025년 03월 17일 17시 09분 02초라는 포맷으로 출력하고 싶으면 Date포맷을 지정해주는 객체를 사용해야함.
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월 dd일 HH시 mm분 ss초"); //객체 생성시의 매개값으로 원하는 포맷을 넣음. HH: 24시간 hh: 12시간
		sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		System.out.println(sdf.format(obj2));

	}//
}
