package com.javaex.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorInsert {

	public static void main(String[] args) {
		
		System.out.println("작가등록예제");
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");	
			
			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/book_db";
			conn = DriverManager.getConnection(url, "book", "book");
			
			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문 준비 (insert 문을 자바의 문자열로 만든다) (딱딱한문장)
			// 쿼리문을 자바에서 직접 짜지 않는다
			// -> 아무리 간단해도 워크벤치에서 짜고 충분히 테스트하고 옮겨온다
			// String query = "insert into author values (null, '기안84', '웹툰작가')";
			String query = "insert into author values (null, ?, ?)";	// 물음표엔 '' 넣지않기
		 
			/*
			String query = "";						--   query +=
			query += " insert into author ";			-- = query = query +
			query += " values (null, ?, ?) ";	-- " "에 적는걸 앞뒤로 한칸씩 띄워주는게 좋음
												-- 더해지면서 글자가 합쳐져서 오류 뜰수있기 때문
												-- " " 안에는 ; 빼주기
			*/
			
			// 바인딩 (말랑말랑하게 해주기)
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "기안84");		// 첫번째 물음표
			pstmt.setString(2, "웹툰작가");	// 두번째 물음표
			
			// 실행
			int count = pstmt.executeUpdate();
			
			// 4.결과처리
			System.out.println(count + "건 등록되었습니다.");
			
			
		} catch (ClassNotFoundException e) {
		 System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		System.out.println("error:" + e);
		} finally {
		 
		// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				} 
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			  }
		
			}

	}

}
