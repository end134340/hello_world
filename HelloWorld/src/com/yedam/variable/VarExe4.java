package com.yedam.variable;

import java.util.Scanner;

public class VarExe4 {
	public static void main(String[] args) {
		int[] scores = new int[3]; //배열의 크기만 정의. 정수 숫자 3개를 담을 수 있는 공간 생성. {0, 0, 0}
		
		//사용자에게 점수 입력받음
		Scanner scn = new Scanner(System.in);
		
		//입력받은 값을 누적
		for(int i = 0; i < scores.length; i++) {
			System.out.print("값을 입력해 주세요. > ");
			int num = scn.nextInt();
			
			scores[i] += num;
		}
		
		//입력된 값의 합 구하기.(콘솔에 출력)
		int sum = 0;
		double avg = 0.0;
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		avg = (double)sum / scores.length;
		
		System.out.println("합은 " + sum + ", 평균은 " + avg + "입니다.");
		
		scn.close();
	}
}
