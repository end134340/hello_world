package com.yedam.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.bookApp.Book;

public class MapExe {
	public static void main(String[] args) {
		// Map: Map<키에 해당되는 객체 타입, 밸류에 해당되는 객체 타입> 변수;
		Map<Integer, String> map = new HashMap<Integer, String>();
		// 객체 추가방식: put(키, 밸류);
		map.put(100, "홍길동");
		map.put(101, "김민수");
		//동일한 키가 들어오면 기존에 있던 값을 새로 들어온 값으로 대체함.
		map.put(102, "김장수");
		map.put(102, "김복수");
		
		//삭제
		map.remove(101); //삭제하고 싶은 객체의 키 값을 넣으면 됨.
		
		Set<Entry<Integer, String>> eset = map.entrySet();
		for(Entry<Integer, String> entry : eset) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}

		boolean run = true;
		if(run) {
			return;
		}
		
		Map<String, Book> books = new HashMap<String, Book>();
		books.put("B001", new Book("가시고기", "조창인", "어쩌고", 14000));
		books.put("B002", new Book("백조왕자", "안데르센", "꿈", 11000));
		books.put("B003", new Book("광마회귀", "유진성", "무협", 50000));

		// 검색(조회) 키 값에 해당되는 value를 반환해주는 메소드.
		Book result = books.get("B001");

		// 전체 요소 출력(순서 없음. 인덱스도 없어서 키를 가져와 조회해야함.)
		// 키 set 반환 메소드. (키 부분에 해당되는 값만 가져와 Set 컬렉션에 넣어줌)
		Set<String> keyset = books.keySet();
		for (String key : keyset) {
			System.out.println("key: " + key + ", value: " + books.get(key).showList());
		}
		
		System.out.println("================================================");

		// 키:값 (키:값형태를 Entry 타입?이라고 함)을 반환해주는 메소드. 사용 방식은 Set 안에 Map 쓰는것과 같은?방식
		Set<Entry<String, Book>> entryset = books.entrySet();
		for(Entry<String, Book> entry : entryset) { 
			                  //entry에서 키를 가져오는 메소드                 값을 가져오는 메소드
			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue().showList());
		}

		// Gson: 자바 객체를 { 키 : 값 } 형식의 문자열로 보기 위한 외부 라이브러리. create()가 객체를 만들어줌.
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); // setPrettyPrinting(): 예쁘게???보여주는 메소드
		String json = gson.toJson(map); // 객체를 문자열로 만들어주는 메소드.
//		System.out.println(json);

		json = gson.toJson(books);
//		System.out.println(json);

	}// 메인 끝
}
