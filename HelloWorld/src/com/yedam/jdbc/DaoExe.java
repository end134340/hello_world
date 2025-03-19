package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. 데이터베이스에 연결할 수 있는 라이브러리(ojdbc) 연결.
 * 2. Connection 객체를 통해 데이터베이스에 접속해 섹션을 가져올 수 있는? 작업
 * 3. Statement(PreparedStatement) 객체를 사용해 쿼리 실행.
 * 4. ResultSet(조회 했을때의 결과를 담아옴), int(입력, 수정, 삭제가 반영된 결과의 건수?를 반환) 
 */
public class DaoExe {
	public static void main(String[] args) {
		//Connection 객체도 인터페이스라 DriverManager를 사용해야함.
		//DriverManager: url, 사용자 정보, 패스워드를 가지고 접속할 수 있게?해줌
		
		//oracle db에 접속하기 위한 url 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		String sql = "SELECT empno, \r\n"  
				+ "       ename, \r\n"
				+ "       job, \r\n"
				+ "       mgr, \r\n"
				+ "       hiredate, \r\n"
				+ "       sal\r\n"
				+ "FROM emp\r\n"
				+"ORDER BY empno desc";
		
		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			System.out.println("연결 성공");
			
//			conn.setAutoCommit(false); //자동 커밋 기능을 끄는 옵션. true는 켜는거.
			
			//statement객체 생성은 conn에서 가져?옴?
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate("DELETE FROM emp\r\n" //insert, delete, update인 경우 executeUpdate사용. 반환되는 데이터 타입이 int(반환된 건수)
									+ "WHERE empno = 9999");
			if( r > 0 ) { //삭제된 건수가 하나 이상 있으면 정상 삭제
				System.out.println("정상적으로 삭제되었습니다.");
//				conn.commit(); //커밋해주는 메소드... 근데 자동 커밋됨
			}
			
			ResultSet rs = stmt.executeQuery(sql); //쿼리 작성 => 실행 
			
			while(rs.next()) { //next(): 조회된 결과의 데이터 건수를 가져오는 ResultSet의 메소드. 다음에 가져올 값이 없으면 false를 반환.
				System.out.println(rs.getInt("empno") + ", " + rs.getString("ename") + ", " + rs.getString("job")); 
				//getInt: 해당하는 컬럼의 값을 반환(int타입) getString: 해당하는 컬럼의 값을 으로 반환(String타입)
			}
			System.out.println("데이터의 출력이 종료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
