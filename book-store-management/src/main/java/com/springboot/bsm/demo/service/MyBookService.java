package com.springboot.bsm.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bsm.demo.entity.MyBook;
import com.springboot.bsm.demo.repository.MyBookRepository;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepository myBookRepository;
	
	public MyBook saveMyBook(MyBook myBook) {
		return myBookRepository.save(myBook);
	}
	
	public List<MyBook> getAllMyBooks(){
		return myBookRepository.findAll();
	}
	
	public Optional<MyBook> getMyBookById(int id) {
		return myBookRepository.findById(id);
	}
	
	public void deleteMyBook(int id) {
		myBookRepository.deleteById(id);
	}
}
