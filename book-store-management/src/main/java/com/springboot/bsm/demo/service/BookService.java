package com.springboot.bsm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bsm.demo.entity.Book;
import com.springboot.bsm.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}
	
	public void deleteBookById(int id) {
		bookRepository.deleteById(id);
	}
}
