package com.yedam;

public class HelloExe {
	//기능(함수) = main 메소드(  매개값(배열)  )
  public static void main(String[] args) {
	                //main이라는 메소드는 기본 메소드이기 때문에 정의하지 않으면 기본 메소드를 정의하라는 오류가 남.
	  System.out.println("Hello, World.");
	  
	  String name;
	  name = "김시인";
	  
	  System.out.println("이름은 " + name + "입니다.");
	  
	  int score = 100; //변수 선언하며 값을 넘어줌 = 초기값 할당
	  
	  System.out.println("점수는 " + score + "점 입니다.");
	  
	  
  }
}
