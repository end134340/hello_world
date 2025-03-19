package com.yedam.bookApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//ojdbc를 활용해 추가, 수정, 삭제 기능 구현.
public class BookJdbc {

	// Connection 생성
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
	}

	// 추가
	public boolean insert(Book book) {
		Connection conn = getConnect();
		String sql = "INSERT INTO tbl_book (book_code "//
				+ "                      , book_title "//
				+ "                      , writer "//
				+ "                      , company "//
				+ "                      , price)"//
				+ "VALUES (book_seq.nextval"//
				+ "        , ?"//
				+ "        , ?"//
				+ "        , ?"//
				+ "        , ?)";//

		try {
//			Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getWriter());
			stmt.setString(3, book.getCompany());
			stmt.setInt(4, book.getPrice());
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 수정
	public boolean update(Book book) {
		Connection conn = getConnect();
		String sql = "UPDATE tbl_book "//
				+ "SET    book_title = nvl(?, book_title) "//
				+ "       , price = nvl(?, price) "//
				+ "       , writer = nvl(?, writer) "//
				+ "WHERE  book_code = ?";

		try {
			PreparedStatement prst = conn.prepareStatement(sql);
			prst.setString(1, book.getTitle());
			prst.setInt(2, book.getPrice());
			prst.setString(3, book.getWriter());
			prst.setString(4, book.getBookCode());
			int r = prst.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// 삭제
	public boolean delete(String bookCode) {
		Connection conn = getConnect();
		String sql = "DELETE FROM tbl_book "//
				+ "WHERE  book_code = '" + bookCode + "'";

		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 목록
	public List<Book> list(String company) {
		List<Book> list = new ArrayList<Book>();
		Connection conn = getConnect();
		String sql = "SELECT book_code " //
				+ "      , book_title " //
				+ "      , writer" //
				+ "      , company " //
				+ "      , price " //
				+ "FROM tbl_book " + "WHERE company = nvl( ?, company ) " //
				+ "ORDER BY book_code";

		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, company);
			ResultSet rs = psmt.executeQuery(); // 조회
			while (rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("book_code"));
				book.setTitle(rs.getString("book_title"));
				book.setWriter(rs.getString("writer"));
				book.setCompany(rs.getString("company"));
				book.setPrice(rs.getInt("price"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Book select(String bcode) {

		Connection conn = getConnect();
		String sql = "SELECT book_code " //
				+ "      , book_title " //
				+ "      , writer" //
				+ "      , company " //
				+ "      , price " //
				+ "FROM tbl_book " + "WHERE book_code = ? "; //

		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, bcode);
			ResultSet rs = psmt.executeQuery(); // 조회
			if (rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("book_code"));
				book.setTitle(rs.getString("book_title"));
				book.setWriter(rs.getString("writer"));
				book.setCompany(rs.getString("company"));
				book.setPrice(rs.getInt("price"));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}//
