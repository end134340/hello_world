package com.yedam.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//List 컬렉션
public class ListExe {
	public static void main(String[] args) {
		// 배열: int[], String[], Member[] => 인덱스로 위치를 지정해 값을 담거나 가져올 수 있음
		// List 컬렉션: List<Interger>, List<String>, List<Member> =? intList.get(0),
		// intList.add(30) 클래스이기 때문에 메소드 기반.

		List<Integer> intList = new ArrayList<Integer>(); // 선언방법: 인터페이스<타입(클래스 유형)?> 변수명 = new 구현 클래스? 객체 할당

		intList.add(100);
		intList.add(150);
		intList.add(200);
		intList.add(100);

		for (int i = 0; i < intList.size(); i++) { // List는 인덱스를 사용할 수 있음. 크기가 length가 아니라 size()임.
			// size 자체가 하나씩 추가할 때마다 커지기 때문에 NULL여부를 생각할 필요가 없음.
			System.out.println("List 컬렉션 " + intList.get(i));
		}

		System.out.println("===============================");

		// Set 컬렉션: List컬렉션과 다르게 중복된 값 저장 불가. 순서라는게 없음.
		Set<Integer> intSet = new HashSet<Integer>();

		intSet.add(100);
		intSet.add(150);
		intSet.add(200);
		intSet.add(100);

		for (int num : intSet) { // 순서가 없어서 인덱스가 없기 때문에 확장된 for문을 사용해야함.
			System.out.println("Set 컬렉션 " + num);
			// 중복된 값을 허용하지 않기 때문에 100을 두 번 넣었어도 논리적으로 하나로 취급해 하나만 넣는... 듯?
		}

		System.out.println("===============================");
		
		// 이미 구현된 Integer나 String이 아닌 직접 구현한 멤버 클래스를 이용한 HashSet
		Set<Member> members = new HashSet<Member>();

		members.add(new Member("홍길동", 20));
		members.add(new Member("김길동", 21));
		members.add(new Member("박길동", 24));
		members.add(new Member("홍길동", 20)); //Set컬렉션 안에서 동등한 객체로 인식되지 않음 => Set컬렉션은 hashCode(), equals()가 리턴하는 값이 같으면 동등한 객체라고 인식.
		                                     //     => Member클래스에서 논리적으로 동등한 객체로 인식하도록 hashCode() 오버라이딩.
		
		for(Member mem : members) {
			System.out.println(mem.toString());
		}
		

	}//
}
