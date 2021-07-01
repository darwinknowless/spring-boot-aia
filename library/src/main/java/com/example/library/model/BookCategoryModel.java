package com.example.library.model;

//import library
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO: create entity
@Entity
@Table(name = "book_category")
public class BookCategoryModel {

	public BookCategoryModel() {
		super();
	}

	// TODO: generate constructor using field
	public BookCategoryModel(Long id, String category, String categoryCode) {
		super();
		this.id = id;
		this.category = category;
		this.categoryCode = categoryCode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// TODO: declare variable fields
	private String category;
	private String categoryCode;

	// TODO: generate getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	// TODO: generate toString
	@Override
	public String toString() {
		return "BookCategory [id=" + id + ", category=" + category + ", categoryCode=" + categoryCode + "]";
	}
}
