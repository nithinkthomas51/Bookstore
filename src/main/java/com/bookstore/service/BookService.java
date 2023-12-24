package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public void save(Book b) {
		bookRepo.save(b);
	}
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	public Book findById(int id) {
		return bookRepo.findById(id).get();
	}
	
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}

}
