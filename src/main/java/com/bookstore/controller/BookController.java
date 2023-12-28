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
	
	/*
	 * This will return the UI for adding a new book to the store
	 * User needs to provide the name, author and price of the
	 * book and then click on submit.
	 */
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView availableBooks(@RequestParam(value = "category", defaultValue = "All") String category) {
		ModelAndView m = new ModelAndView("availableBooks");
		m.addObject("book", bookService.getAllBooks(category));
		m.addObject("selectedCategory", category);
		return m;
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookService.save(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/available_books/update/{id}")
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
	
	@GetMapping("/cancel")
	public String onCancel() {
		return "redirect:/available_books";
	}
	
	@GetMapping("/available_books/{category}")
	public ModelAndView getBooksCategoryWise(@PathVariable("category") String category) {
		ModelAndView m = new ModelAndView("availableBooks", "book", bookService.findByCategory(category));
		m.addObject("selectedCategory", category);
		return m;
	}

}
