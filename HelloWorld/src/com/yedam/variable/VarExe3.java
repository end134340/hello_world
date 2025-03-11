package com.yedam.variable;

import java.util.Scanner;

//사용자의 입력값을 읽어들이는 방식
//Scanner 클래스.
public class VarExe3 {
	public static void main(String[] args) {
		//java.util.Scanner scn = new java.util.Scanner(System.in); //어디에 있는지 명시해주는 방식
		Scanner scn = new Scanner(System.in); //간단하게??? import로 반환하는 방식
		
		System.out.print("이름을 입력하세요. >   ");
		String name = scn.nextLine(); //메소드(함수)???
		
		System.out.print("점수를 입력하세요. >   ");
		int score = scn.nextInt(); //메소드(함수)???
		
		System.out.print("키를 입력하세요. >   ");
		double height = scn.nextDouble(); //메소드(함수)???
		
		System.out.println("입력한 값: " + name + ", 점수: " + score + ", 키: " + height);
		
		scn.close();
	}
}
