package com.javaex.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelectOne {

	public static void main(String[] args) {
		
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
			// sql문 준비
			String query = "";
			query += " select b.book_id ";
			query += "		, b.title ";
			query += "		, b.pubs ";
			query += "		, b.pub_date ";
			query += "		, b.author_id ";
			query += "	 	, a.author_name ";
			query += "      , a.author_desc ";
			query += " from book b ";
			query += " left join author a ";
			query += " on b.author_id = a.author_id ";
			query += " where b.book_id = ? ";
					
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 2);
			
			//실행
			rs = pstmt.executeQuery();
		 
			// 4.결과처리
			rs.next();
			int bookId = rs.getInt("book_id");
			String title = rs.getString("title");
			String pubs = rs.getString("pubs");
			String pdate = rs.getString("pub_date");
			int authorId = rs.getInt("b.author_id");
			String name = rs.getString("author_name");
			String desc = rs.getString("author_desc");

			Book2Vo book2Vo = new Book2Vo(bookId, title, pubs, pdate, authorId, name, desc);
			System.out.println(book2Vo);
			
			
			
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
