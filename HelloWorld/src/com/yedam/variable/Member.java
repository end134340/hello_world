package com.yedam.variable;

//public: 다른 클래스에서 이 클래스에 접근이 가능하도록 허가함
//private: 다른 클래스에서 이 클래스에 접근하지 못하도록 숨김.
//public <-> private
public class Member {
	// 클래스: 필드(값을 저장)
	//       타입   필드
	private String name;
	private int score;
	//클래스 뿐만 아니라 필드나 메소드 각각에도 접근할 수 있는 범위 지정이 가능함.
	
	//클래스 생성자(실체 생성)
	//생성자를 따로 정의하지 않으면 자바의 컴파일러가 기본 생성자(클래스와 이름이 같으면서 매개값이 없음.)를 생성해줌.
	//메소드처럼 보이지만 메소드는 아니고 반환값도 없음
	public Member() {
		
	}
	//다른 생성자를 정의한 후에는 컴파일러가 기본 생성자를 따로 만들어주지 않음. 필요하다면 직접 정의해야함
	
	//필요하다면 생성자는 여러개 만들어도됨(생성자 재정의 = overloading)
	public Member(String name, int score) { //기본 생성자를 이용해서 다른 메소드로 값을 할당해주어야 하는 걸 생성자를 생성하면서 값을 할당해줘서 한 단계로 줄임
		this.name = name;
		this.score = score;
	}

	// 클래스: 메소드(기능) => 반환 값, 메소드명, 매개값 지정여부 필요
	public void showInfo() { // void => 메소드를 실행했을 경우 반환되는 값이 없음. 만약 문자를 반환하고 싶다면 String 등.
		System.out.println("이름은 " + name + ", 점수는 " + score);
	}
	
	public void setMember(String name, int score) {
		this.name = name; //this는 Member의 필드를 가리킴.
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score) {
		if(score < 0 || score > 100) {
			System.out.println("점수는 1에서 100사이의 값이어야 합니다.");
			return; //메소드 안에서의 return문은 그 코드를 종료한다는 의미.
		}
		this.score = score;
	}
		
	public int getScore() {
		return score;
	}

}// end of member
