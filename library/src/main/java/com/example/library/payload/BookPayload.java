package com.example.library.payload;

public class BookPayload {
	// TODO : declare fields variable
	private String bookName;
	private String bookCode;
	private String author;
	private String years;
	private String bookCategory;

	public BookPayload() {
		super();
	}

	// TODO : generate constructor using fields
	public BookPayload(String bookName, String bookCode, String author, String years, String bookCategory) {
		super();
		this.bookName = bookName;
		this.bookCode = bookCode;
		this.author = author;
		this.years = years;
		this.bookCategory = bookCategory;
	}

	// TODO : generate getters & setters
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
}
