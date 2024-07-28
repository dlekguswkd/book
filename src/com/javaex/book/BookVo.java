package com.javaex.book;

public class BookVo {
	
	private int book_Id;
	private String title;
	private String pubs;
	private String pubDate;
	private int authorid;
	
	
	public BookVo() {
		super();
	}
	public BookVo(int book_Id, String title, String pubs, String pubDate, int author_id) {
		super();
		this.book_Id = book_Id;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorid = author_id;
	}
	
	
	public int getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPubs() {
		return pubs;
	}
	public void setPubs(String pubs) {
		this.pubs = pubs;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public int getAuthor_id() {
		return authorid;
	}
	public void setAuthor_id(int author_id) {
		this.authorid = author_id;
	}
	
	
	@Override
	public String toString() {
		return "BookVo [book_Id=" + book_Id + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate
				+ ", author_id=" + authorid + "]";
	}
	
	
	
}
