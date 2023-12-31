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
	
	public List<Book> getAllBooks(String category) {
		if (category.equals("All")) {
			return bookRepo.findAll();
		} else {
			return bookRepo.findAllByCategory(category);
		}
	}
	
	public Book findById(int id) {
		return bookRepo.findById(id).get();
	}
	
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}
	
	public List<Book> findByCategory(String category) {
		return bookRepo.findAllByCategory(category);
	}

}
