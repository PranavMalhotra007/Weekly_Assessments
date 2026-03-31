package com.lpu.book_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.book_service.DTO.BookDTO;
import com.lpu.book_service.entity.Book;
import com.lpu.book_service.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	private BookService bookService;
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public List<BookDTO> findAll(){
		return bookService.findAll();
	}
	@GetMapping("/{id}")
	public BookDTO findById(@PathVariable int id) {
		return  bookService.findByID(id);
	}
	@PostMapping
	public BookDTO saveBookDTO(@RequestBody BookDTO book) {
		return bookService.saveBookDTO(book);
	}
	@PostMapping("/save")
	public BookDTO saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	@PutMapping("/{id}")
	public BookDTO updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO ) {
		return bookService.update(id, bookDTO);
	}
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable int id) {
		return bookService.deleteByID(id);
	}
}
