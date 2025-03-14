package com.yedam.inheritance;

//Friend 클래스를 상속받는 클래스
public class UnivFriend extends Friend {
	// 부모 클래스를 상속받은 자식 클래스는 부모의 모든 걸 물려받음
	private String univName;
	private String major;

	public UnivFriend() {
//		super(); //명시되어 있지는 않지만 기본적으로 부모클래스의 생성자가 존재.
	}

	public UnivFriend(String name, String tel, String univName, String major) {
		super(name, tel); // super() => 부모 클래스가 가진 생성자
		this.univName = univName;
		this.major = major;
	}

	// 부모의 메소드를 자식이 재정의하는 것이 가능(오버라이딩)
	@Override // 부모에게서 상속받은 메소드의 반환 유형, 매개변수 등이 다르면 오류라고 알려줌
	public String getName() {
		// super: 부모
//		return super.getName();
		return super.getName();
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return super.toString() + ", 학교명은 " + getUnivName() + ", 학과는 " + getMajor();
	}

//	@Override
//	public void setName(String name) {
	// 부모 클래스에서 final을 사용한 메소드이기 때문에 자식 클래스에서 재정의되지 않음.
//	}

}
