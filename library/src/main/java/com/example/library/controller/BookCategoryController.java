package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.BookCategoryModel;
import com.example.library.repo.BookCategoryRepo;

@RestController
@RequestMapping("api/book-category")
public class BookCategoryController {
	@Autowired
	BookCategoryRepo bookCategoryRepo;

	// TODO : CREATE API
	@PostMapping
	public BookCategoryModel create(@RequestBody BookCategoryModel bookCategoryModel) {
		return bookCategoryRepo.save(bookCategoryModel);
	}

	// TODO : GET API
	@GetMapping
	public List<BookCategoryModel> read() {
		return bookCategoryRepo.findAll();
	}

	// TODO : UPDATE API
	@PutMapping("/{id}")
	public BookCategoryModel update(@PathVariable Long id, @RequestBody BookCategoryModel bookCategoryModel)
			throws Exception {
		BookCategoryModel bookCategory = bookCategoryRepo.findById(id)
				.orElseThrow(() -> new Exception("Book Category not found"));
		bookCategory.setCategory(bookCategoryModel.getCategory());
		bookCategory.setCategoryCode(bookCategoryModel.getCategoryCode());
		bookCategoryRepo.save(bookCategory);
		return bookCategory;
	}

	// TODO : DELETE API
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		bookCategoryRepo.deleteById(id);
		return "Book Category with id " + id + " has been deleted";
	}

}
