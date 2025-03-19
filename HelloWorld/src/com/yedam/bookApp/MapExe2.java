package com.yedam.bookApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.yedam.variable.Member;

public class MapExe2 {
	public static void main(String[] args) {
		Map<Member, Double> map = new HashMap<Member, Double>();
		map.put(new Member("홍길동", 80), 174.8);
		map.put(new Member("김길동", 82), 179.4);
		map.put(new Member("박길동", 78), 184.1);

		//Member클래스에서 equals와 hashcode가 오버라이딩 되어 있기 때문에 같은 객체로 판별되어 지울 수 있음.
		map.remove(new Member("박길동", 78));

		Set<Entry<Member, Double>> entryset = map.entrySet();
		for (Entry<Member, Double> entry : entryset) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}

	}
}
