package com.javaex.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.author.AuthorVo;

public class BookSelect {

	public static void main(String[] args) {
		
		List<BookVo> bookList = new ArrayList<BookVo>();
		
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
			query += " select 	book_id ";
			query += "		   , title ";
			query += "         , pubs ";
			query += "         ,  pub_date ";
			query += "         , author_id ";
			query += " from book ";
					
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			
			//실행
			rs = pstmt.executeQuery(); 
		 
			// 4.결과처리
			while (rs.next()) {
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				int authorId = rs.getInt("author_id");
				
				
				BookVo bookVo = new BookVo(bookId, title, pubs, pubDate, authorId);	
				bookList.add(bookVo);
				System.out.println(bookVo);						
				
			}
			
			
			
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

				
			// 전체출력
			for(int i= 0; i<bookList.size(); i++) {
					
				BookVo bVo = bookList.get(i);
				
				System.out.print(bVo.getBook_Id() + ".  ");
				System.out.print(bVo.getTitle() + "\t");
				System.out.print(bVo.getPubs() + "\t");
				System.out.print(bVo.getPubDate() + "\t");
				System.out.println(bVo.getAuthor_id());
				
				}
				
			System.out.println("--------------------------------");
				
			for (BookVo vo : bookList) {	// 향상된 for문
				System.out.print(vo.getBook_Id() + ".  ");
				System.out.print(vo.getTitle()+ "\t");
				System.out.println(vo.getPubs());
				System.out.println(vo.getPubDate());
				System.out.println(vo.getAuthor_id());
					
			}
			
	}

}
