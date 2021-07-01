package com.example.library.model;

//import library
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//TODO: create entity
@Entity
@Table(name = "book")
public class BookModel {

	public BookModel() {
		super();
	}

	// TODO: generate constructor using fields
	public BookModel(String bookName, String bookCode, String author, String years,
			// import model BookCategory
			BookCategoryModel bookCategory) {
		super();
		this.bookName = bookName; // => Book name
		this.bookCode = bookCode;
		this.author = author;
		this.years = years;
		this.bookCategory = bookCategory;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// TODO: declare variable fields
	private String bookName; // => book_name
	private String bookCode;
	private String author;
	private String years;

	@JoinColumn(name = "book_category_id")
	@ManyToOne(targetEntity = BookCategoryModel.class, fetch = FetchType.LAZY)
	private BookCategoryModel bookCategory;

	// TODO: generate getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public BookCategoryModel getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategoryModel bookCategory) {
		this.bookCategory = bookCategory;
	}
}
