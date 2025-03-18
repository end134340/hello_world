package com.yedam.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.yedam.variable.Member;

public class SetExe {
	public static void main(String[] args) {
		// 인덱스로 관리되지 않아서 순서 지정x 중복값 불가.
		Set<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
//		set.add((100);
		set.add("Hello");

		// 반복자
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) { // hasNext() 다음으로 가져올 요소가 있는지 확인하는 메소드
			String result = iter.next(); // next(): 다음 요소를 가져오는 메소드
			System.out.println(result);
		}

		// Set<Member>
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 80));
		members.add(new Member("김민규", 85));
		members.add(new Member("홍길동", 80));
		// 새 객체를 만든 것이기 때문에 중복값을 허용하지 않는 Set컬렉션을 이용하더라도 다른 값으로 인식됨.

		Iterator<Member> miter = members.iterator();
		while (miter.hasNext()) {
			Member result = miter.next();
			System.out.println(result.toString());
		}

		int[] intAry = { 10, 20, 30, 40, 20, 10 };
		// 중복된 값 제거(Set컬렉션에 담음) 후 List컬렉션에 담고 출력

		Set<Integer> iSet = new HashSet<Integer>();
		List<Integer> iList = new ArrayList<Integer>();

		for (int i = 0; i < intAry.length; i++) {
			iSet.add(intAry[i]);
		}

		Iterator<Integer> iIter = iSet.iterator();
		while (iIter.hasNext()) {
			iList.add(iIter.next());
		}

//		iList.forEach(num -> System.out.println(num)); forEach문 사용 가능.
		
		for (int i = 0; i < iList.size(); i++) {
			System.out.println(iList.get(i));
		}

	}// 메인 끝
}
