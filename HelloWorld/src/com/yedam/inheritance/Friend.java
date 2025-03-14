package com.yedam.inheritance;

//이름, 연락처만 담는 클래스
public class Friend {
	// 필드 선언
	private String name;
	private String tel;

	// 생성자
	public Friend() {

	}

	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	@Override // 모든 클래스는 Object라는 클래스를 상속받고 있기 때문에 Friend클래스가 상속받는 부모가 없어 보여도 재정의를 할 수 있음
	public String toString() {
//		return super.toString();
		return "이름은 " + getName() + ", 연락처는 " + getTel();
	}

	public String getName() {
		return name;
	}

	//부모 클래스의 메소드에서 final을 사용하면 오버라이딩 할 수 없음
	public final void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
