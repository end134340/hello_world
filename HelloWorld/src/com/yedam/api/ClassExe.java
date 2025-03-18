package com.yedam.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExe {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("com.yedam.bookApp.Book"); // ClassNotFoundException는 반드시 예외처리가 들어가야함.

			// 클래스의 메소드 반환
			Method[] methods = cls.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				System.out.println(methods[i].getName());
			}

			// 클래스의 필드 반환
			Field[] fields = cls.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				System.out.println(fields[i].getName());
			}

			//클래스의 생성자 반환
			Constructor[] fcon = cls.getDeclaredConstructors();
			for (int i = 0; i < fcon.length; i++) {
				System.out.println(fcon[i].getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}// main끝
}
