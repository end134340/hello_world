package com.yedam.bookApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberJdbc {

	// 커넥션 반환.
	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";

		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}//

	// 회원 목록을 가지고 오는 메소드.
	public List<Map<String, String>> memberList() {
		// [{userId: "user01"}, {password: "1111"}, {userName: "홍길동"}] 형태로 담을거기 때문에
		// Map컬렉션 사용.
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Connection conn = getConnect();// 쿼리를 하기 위한 db 세션을 받아오는 코드
		String sql = "SELECT user_id " //
				+ "          , password " //
				+ "          , user_name " //
				+ "   FROM   tbl_member";

		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				// userId, password, userName을 저장할 Map 컬렉션
				Map<String, String> map = new HashMap<String, String>();
				map.put("userId", rs.getString("user_id"));
				map.put("password", rs.getString("password"));
				map.put("userName", rs.getString("user_name"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public Map<String, String> login(String id, String pw) {
		Connection conn = getConnect();
		String sql = "SELECT user_id "//
				+ "          , password"//
				+ "          , user_name "//
				+ "   FROM   tbl_member "//
				+ "   WHERE  user_id = ? "//
				+ "   AND    password = ?";
		Map<String, String> map = new HashMap<String, String>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				map.put("userName", rs.getString("user_name"));
				return map;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}//
