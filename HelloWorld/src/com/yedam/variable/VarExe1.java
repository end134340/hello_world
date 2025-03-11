package com.yedam.variable;

//관례: 클래스의 이름은 항상 대문자로 시작해야 함.
public class VarExe1 {
	public static void main(String[] args) {		
		//연산을 할 때에는 두 값의 유형(datatype)이 동일해야함.
		int number1 = 70;
		int number2 = 80;
		
		number1 = 71;
		
		int sum = number1 + number2;
		
		System.out.println("두 점수의 합은 " + sum + "입니다.");
		
		//int: 정수 값만 담음.
		//double: 소수점까지 표현 가능.
		double avg = (double)sum / 2.0;
		             //강제 형 변환. java에서 연산을 하기 위해서는 왼쪽과 오른쪽의 타입이 같아야 함.
		System.out.println("두 점수의 평균은 " + avg + "입니다.");
		
	}
}
