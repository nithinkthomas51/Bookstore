package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView availableBooks() {
		ModelAndView m = new ModelAndView("availableBooks", "book", bookService.getAllBooks());
		return m;
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookService.save(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/available_book/update/{id}")
	public String updateBook(@PathVariable("id") int id, Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("book", book);
		return "updateBook";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		return "redirect:/available_books";
	}

}
