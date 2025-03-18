package com.yedam.api;

import java.util.ArrayList;
import java.util.List;

public class WrapperExe {
	public static void main(String[] args) {
		int[] intAry = { 10, 20 };

		List<Integer> list = new ArrayList<Integer>();

		list.add(10); // int => Integer 박싱 / Integer => int 언박싱
		list.add(new Integer(20));

		int num1 = 10; // 기본 데이터유형이라면 ==로 두 개의 값을 비교 가능.
		Integer num2 = new Integer(20); // 참조변수. 주소값을 비교하기 때문에 ==로 비교하면 false가 나옴.
		System.out.println(num1 = num2.intValue()); // intValue(): Integer클래스의 값을 기본형 데이터유형으로 변환해주는 메소드
	}
}
