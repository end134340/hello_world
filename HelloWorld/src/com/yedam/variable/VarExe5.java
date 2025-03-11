package com.yedam.variable;

import java.util.Scanner;

//예금과 출금, 잔고 확인이 가능한 프로그램
public class VarExe5 {
	public static void main(String[] args) {
		//while 반복문
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		int balance = 0; //예금액을 저장하는 변수
		
		while(run) {
			//true인 경우 반복. false인 경우 반복을 종료하고 while문을 빠져나감.
			System.out.println("  1. 예금    |   2. 출금   |  3. 잔고 확인  |   4. 종료   ");
			System.out.println("====================================================");
			int menu = scn.nextInt(); //사용자의 입력을 받아 메뉴 선택
			int amount = 0;
			
			switch(menu) {
			case 1: 
				System.out.print("입금하실 금액을 입력하세요. >");
				amount = scn.nextInt();
				if((balance + amount) > 100000) {
					System.out.println("예금액이 10만원을 초과합니다.");
				} else {
					balance += amount;
				}
				break; //case 1에 대한 종료 구문	
			case 2:
				System.out.print("출금하실 금액을 입력하세요. >");
				amount = scn.nextInt();
				
				if(amount > balance) {
					System.out.println("잔고가 부족합니다.");
				} else {
					balance -= amount;					
				}
				break; //case 2에 대한 종료 구문
				
			case 3:
				System.out.println("현재 잔고는 " + balance + "원 입니다.");
				break; //case 3에 대한 종료 구문	
			case 4: 
				run = false;
			}
			
		}
		System.out.println("end of program");
		scn.close();
		
	}//main끝
}
