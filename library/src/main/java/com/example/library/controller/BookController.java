package com.example.library.controller;

import java.util.List;

//import library
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
import com.example.library.model.BookModel;
import com.example.library.payload.BookPayload;
import com.example.library.repo.BookCategoryRepo;
import com.example.library.repo.BookRepo;

@RestController
@RequestMapping("api/book")
// block class
public class BookController {
	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private BookCategoryRepo bookCategoryRepo;

	// TODO : GET API
	@GetMapping
	public List<BookModel> read() {
		return bookRepo.findAll();
	}

	// TODO : POST API
	@PostMapping()
	public BookModel create(@RequestBody BookPayload bookPayload) {
		BookCategoryModel bookCategory = bookCategoryRepo.findByCategory(bookPayload.getBookCategory());
		BookModel book = new BookModel(bookPayload.getBookName(), bookPayload.getBookCode(), bookPayload.getAuthor(),
				bookPayload.getYears(), bookCategory);
		return bookRepo.save(book);
	}

	// TODO : UPDATE API
	@PutMapping("/{id}")
	public BookModel update(@PathVariable(value = "id") Long id, @RequestBody BookPayload bookPayload)
			throws Exception {
		BookModel book = bookRepo.findById(id).orElseThrow(() -> new Exception());
		BookCategoryModel bookCategory = bookCategoryRepo.findByCategory(bookPayload.getBookCategory());

		book.setBookName(bookPayload.getBookName());
		book.setBookCode(bookPayload.getBookCode());
		book.setAuthor(bookPayload.getAuthor());
		book.setYears(bookPayload.getYears());
		book.setBookCategory(bookCategory);
		return bookRepo.save(book);
	}

	// TODO : DELETE API
	@DeleteMapping("/{id}")
	public String delete(@PathVariable(value = "id") Long id) {
		bookRepo.deleteById(id);
		return "Book with id " + id + " has been deleted";
	}
}
