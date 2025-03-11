package com.yedam.variable;

//클래스도 데이터 유형(data type)임
class Student{
	String name;
	int score;
	double height;
}

public class varExe2 {
	public static void main(String[] args) {
		String name = "홍길동";
		int score = 100;
		
		Student s1 = new Student(); //인스턴스 생성
		s1.name = "김민수";
		s1.score = 90;
		s1.height = 178.9;
		
		Student s2 = new Student(); //인스턴스 생성
		s2.name = "최민수";
		s2.score = 92;
		s2.height = 174.6;
		
		//==========자바의 배열 변수[] = {} 의 형식. 값을 중괄호에 담음================
		int[] scores = {89, 77, 60, score}; //정수를 담을 수 있는 배열
		int sum = 0;
		
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println(sum);
		
		String[] names = {"박승호", "김주승", name}; //문자열을 담을 수 있는 배열
		
		for(int i = 0; i < names.length; i++) {
			System.out.println("이름은 " + names[i]);
		}
		
		Student[] students = {s1, s2}; //클래스를 담을 수 있는 배열?
	
		for(int i = 0; i < students.length; i++) {
			System.out.println("이름: " + students[i].name + ", 점수: " + students[i].score + ", 키: " + students[i].height);
		}
		
		
	}
}
