package com.springboot.bsm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.bsm.demo.service.MyBookService;

@Controller
public class MyBookController {

	@Autowired
	private MyBookService myBookService;
	
	@GetMapping("/my_books/remove/{id}")
	public String deleteMyBook(@PathVariable("id") int id) {
		myBookService.deleteMyBook(id);
		return "redirect:/my_book_list";
		
	}
}
