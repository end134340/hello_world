package com.yedam.interfaces;

//Dao: Data Access Object
public interface Dao {
	//인터페이스에서는 따로 abstract를 붙이지 않더라도 기본적으로 모두가 추상 메소드로 만들어짐.
	void insert();
	void update();
	void delete();
	
}
