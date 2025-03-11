package com.yedam.variable;

public class VarExe8 {
	public static void main(String[] args) {
		int n1 = 10;
		byte b1 = 120;
		byte result = (byte) (b1 + 130); // byte 타입 유형은 -128 ~ 127 사이의 값을 담을 수 있음. 크기 범위를 벗어나면 최소값부터 시작해 연산함
		// 정수끼리의 연산은 따로 명시해주지 않으면 int로 연산하기 때문에 타입이 맞지 않아서 오류가 나므로 형변환(casting)을 해줘야 함.
		System.out.println("더한 결과: " + result);

		// byte => int
		n1 = b1;
		// 자바에서는 왼쪽과 오른쪽의 데이터 유형이 같아야 하지만 작은 값의 유형을 큰 유형에 넣으면 형변환이 없더라도 자동으로 형변환이 이루어져
		// 강제적으로 형변환을 해주지 않아도 됨.
		
		n1 = 200;
		b1 = (byte) n1; //형 변환이 가능하긴 하지만, byte가 담을 수 없는 범위의 값을 담기 때문에 손실이 일어남.(원하는 값을 담아줄 수 없음.)
		
		System.out.println(n1);
		System.out.println(b1);
		
		for (int i = 1; i < 15; i++) {
//			System.out.println(b1++);
		}
	}// end of main
}
