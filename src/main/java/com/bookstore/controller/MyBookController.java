package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookLists;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookService;

@Controller
public class MyBookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookService myBookService;
	
	@GetMapping("/my_book")
	public ModelAndView showMyBook() {
		ModelAndView m = new ModelAndView("myBooks", "myBook", myBookService.getAllBooks());
		return m;
	}
	
	@RequestMapping("/mylist/{id}")
	public String addToMyBook(@PathVariable("id") int id) {
		Book book = bookService.findById(id);
		MyBookLists myBook = new MyBookLists(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		myBookService.save(myBook);
		return "redirect:/my_book";
	}
	
	@RequestMapping("/deletemylist/{id}")
	public String deleteMyBook(@PathVariable("id") int id) {
		myBookService.deleteMyBook(id);
		return "redirect:/my_book";
	}

}
