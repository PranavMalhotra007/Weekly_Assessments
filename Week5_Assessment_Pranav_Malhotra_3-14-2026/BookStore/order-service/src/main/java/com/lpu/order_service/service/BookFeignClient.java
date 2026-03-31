package com.lpu.order_service.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lpu.order_service.entity.BookDTO;


@FeignClient("BOOK-SERVICE")
public interface BookFeignClient {
	@GetMapping("/api/books")
	public List<BookDTO> findAll();
	@GetMapping("/api/books/{id}")
	public BookDTO findById(@PathVariable int id);
	@PostMapping("/api/books")
	public BookDTO saveBookDTO(@RequestBody BookDTO book) ;
	@PutMapping("/api/books/{id}")
	public BookDTO updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO );
	@DeleteMapping("/api/books/{id}")
	public String deleteBook(@PathVariable int id) ;
}
