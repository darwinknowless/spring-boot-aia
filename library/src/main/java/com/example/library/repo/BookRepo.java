package com.example.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.BookModel;

@Repository
public interface BookRepo extends JpaRepository<BookModel, Long> {

}
