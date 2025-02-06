package com.example.BooksManagementSystem;

import org.springframework.data.annotation.Id;

public class Book {
	@Id
	String id;
	
	public Book(String id, String bookName, String authorName) {
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	String bookName;
	String authorName;

}
