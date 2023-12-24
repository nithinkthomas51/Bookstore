package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.MyBookLists;
import com.bookstore.repository.MyBookRepository;

@Service
public class MyBookService {
	
	@Autowired
	MyBookRepository myBookRepo;
	
	public void save(MyBookLists myBook) {
		myBookRepo.save(myBook);
	}
	
	public List<MyBookLists> getAllBooks() {
		return myBookRepo.findAll();
	}
	
	public MyBookLists findById(int id) {
		return myBookRepo.findById(id).get();
	}
	
	public void deleteMyBook(int id) {
		myBookRepo.deleteById(id);
	}

}
