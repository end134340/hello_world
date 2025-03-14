package com.yedam.inheritance;

/* 상속
 * 친구의 정보를 관리하는 프로그램.
 * 친구1: 이름, 연락처
 * 친구2: 이름, 연락처, 학교, 학과
 * 친구3: 이름, 연락처, 회사, 부서
 */
public class FriendExe {
	public static void main(String[] args) {
		Friend[] friends = new Friend[10];

		Friend f1 = new Friend();
		f1.setName("김솔음");
		f1.setTel("010-4444-4444");
//		System.out.println(f1.toString());
		// 인스턴스 생성
//		UnivFriend f2 = new UnivFriend();
		// 두 클래스는 타입이 다른데도 UnivFriend는 Friend 클래스를 상속받았기 때문에 대입 가능
		UnivFriend f2 = new UnivFriend();

		f2.setName("김자식");
		f2.setTel("010-1111-1111");
		f2.setUnivName("우리학교");
		f2.setMajor("역사학과");
//		System.out.println(f2.toString());

		CompanyFriend f3 = new CompanyFriend("박자녀", "010-2222-3333", "우리회사", "개발부서");
//		System.out.println(f3.toString());

		friends[0] = f1;
		// 부모 타입의 값을 담는 배열에 자식 클래스의 인스턴스를 담을 수 있음.
		friends[1] = f2;
		friends[2] = f3;

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());
				// 부모 타입을 담는 배열인데 배열에 담긴 인스턴스 클래스에 있는 toString을 호출.
			}
		}

		int num = 20;
		double num2 = num; // 내부적으로 자동 형변환이 일어남 (promotion)
		num = (int) num2; // 강제 형변환(casting)

		Friend f4 = new CompanyFriend("김출근", "010-2434-2434", "자회사", "마케팅");
		CompanyFriend cf = (CompanyFriend) f4; // 부모 클래스의 타입을 자식 클래스에 대입시 캐스팅을 할 수 있음.
//		cf = (CompanyFriend) new Friend("정퇴근", "010-9999-9999"); //문법상의 오류는 아니지만 형변환 예외가 발생함. 아무렇게나 바꿀 수는 없음
		Friend f5 = new Friend("정퇴근", "010-9999-9999");
		if (f5 instanceof CompanyFriend) {
			// f5가 참조하고 있는 값이 바꾸려는 유형이 맞으면 캐스팅을 하고, 아니면 캐스팅 하지 말...
			cf = (CompanyFriend) f5;
			System.out.println(cf.getCompany());
		} else {
			System.out.println("Casting할 수 없습니다.");
		}

	}// 메인 끝
}
