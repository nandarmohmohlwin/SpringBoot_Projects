package com.springboot.bsm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.bsm.demo.entity.Book;
import com.springboot.bsm.demo.entity.MyBook;
import com.springboot.bsm.demo.service.BookService;
import com.springboot.bsm.demo.service.MyBookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private MyBookService myBookService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/available_books")
	public String getAllBooks(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "book_list";
	}

	@GetMapping("/book_register")
	public String bookRegister(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "book_register";
	}

	@PostMapping("/create")
	public String createBook(@ModelAttribute("book") Book book) {
		bookService.saveBook(book);

		// my_books table in Database
		if (myBookService.getMyBookById(book.getId()).isPresent()) {
			MyBook myBook = new MyBook(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
			myBookService.saveMyBook(myBook);
		}

		return "redirect:/available_books";
	}

	@GetMapping("available_books/update/{id}")
	public String updateBooksForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("book", bookService.getBookById(id));
		return "edit_book_list";
	}

	@GetMapping("available_books/remove/{id}")
	public String removeBooks(@PathVariable("id") int id) {
		bookService.deleteBookById(id);
		myBookService.deleteMyBook(id);
		return "redirect:/available_books";
	}

	@GetMapping("/my_book_list")
	public String myBooksList(Model model) {
		model.addAttribute("my_books", myBookService.getAllMyBooks());
		return "my_books";
	}

	@GetMapping("/my_books/{id}")
	public String myBook(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		MyBook myBook = new MyBook(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		myBookService.saveMyBook(myBook);
		return "redirect:/available_books";
	}

}
