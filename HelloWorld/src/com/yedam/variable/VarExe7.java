package com.yedam.variable;

import java.util.Scanner;

//추가, 수정, 삭제, 목록 출력. 
public class VarExe7 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Member[] storage = new Member[100];
		storage[0] = new Member("홍길동", 83);
		storage[1] = new Member("강창호", 100);
		storage[2] = new Member("차유진", 99);

		while (run) {
			System.out.println("====================================================");
			System.out.println(" 1. 등록 | 2. 수정 | 3. 삭제 | 4. 출력 | 5. 평균 | 6. 종료 ");
			System.out.println("====================================================");
			System.out.print("메뉴를 선택하세요 > ");

//			int menu = scn.nextInt();
			// nextInt = 입력했던 값 (번호, 엔터) 중에서 정수만 취득하고 엔터는 처리 안해줌. 이 다음에 nextLine이 엔터를 처리해줘서
			// 입력을 제대로 못함.
			int menu = Integer.parseInt(scn.nextLine());
			// Integer.parseInt() = ()안에 있는 문자열을 정수로 변환해줌.

			switch (menu) {
			case 1: // 등록
				System.out.print("이름을 입력해 주세요. > ");
				String name = scn.nextLine();

				System.out.print("점수를 입력해 주세요. > ");
				int score = Integer.parseInt(scn.nextLine());

				Member member = new Member(); // 인스턴스 생성.
				// Member클래스의 필드 접근 범위를 private로 바꿨기 때문에 직접 접근해서 값 할당하는게 불가함.
				member.setMember(name, score);
//			    	member.name = name;
//			    	member.score = score;
				// 배열의 빈 공간에 값을 할당.

				System.out.println("성공적으로 입력되었습니다.");
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] == null) {
						storage[i] = member;
						break;
					}
				}
				break;
			case 2: // 수정
				System.out.println("수정할 사람의 이름을 입력하세요.");
				String rename = scn.nextLine();
				boolean check = false;
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null && storage[i].getName().equals(rename)) {
						System.out.println(
								"현재 이름은 " + storage[i].getName() + ", 점수는 " + storage[i].getScore() + "점 입니다.");
						System.out.println("변경할 이름을 입력하세요.");
						rename = scn.nextLine();
						System.out.println("변경하실 점수를 입력하세요.");
						int reScore = Integer.parseInt(scn.nextLine());

						storage[i].setMember(rename, reScore);

						System.out.println("성공적으로 수정되었습니다.");
						check = true;
						break;
					}
				}
				if (!check) {
					System.out.println(rename + "이라는 이름의 학생은 존재하지 않습니다.");
				}
				break;
			case 3: // 삭제 (이름을 입력받아 그 위치의 것을 삭제)
				System.out.println("삭제할 사람의 이름을 입력하세요.");
				String delname = scn.nextLine();
				check = false;
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null && storage[i].getName().equals(delname)) {
						storage[i] = null;
						System.out.println("성공적으로 삭제되었습니다.");
						check = true;
						break;
					}
				}
				if (!check) {
					System.out.println(delname + "이라는 이름의 학생은 존재하지 않습니다.");
				}
				break;
			case 4: // 목록 출력
				System.out.println(" 이름 점수  ");
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						System.out.println(storage[i].getName() + " " + storage[i].getScore());
					}
				}
				break;
			case 5: // 평균
				int sum = 0;
				int count = 0;
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						sum += storage[i].getScore();
						count++;
					}
				}
				double avg = sum * 1.0 / (double) count;
				System.out.println("현재 등록된 학생들의 평균은 " + avg + "점 입니다.");
				break;
			case 6:
				run = false;
			}
		}
		System.out.println("프로그램이 종료되었습니다.");

	}// end of main
}
