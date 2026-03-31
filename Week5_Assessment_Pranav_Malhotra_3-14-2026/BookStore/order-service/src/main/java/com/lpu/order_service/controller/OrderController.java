package com.lpu.order_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.lpu.order_service.entity.Order;
import com.lpu.order_service.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class OrderController {
	private OrderService orderService;
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	@PostMapping("/api/orders")
	public ResponseEntity<Order> saveOrder(@Valid @RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(orderService.saveOrder(order));
	}
	@GetMapping("/api/orders")
	public ResponseEntity<List<Order>> findAll() {
		return  ResponseEntity.status(HttpStatus.FOUND)
				.body(orderService.findAll());
	}
	@GetMapping("/api/orders/{id}")
	public ResponseEntity<Order>findById(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(orderService.findById(id));
	}
	@DeleteMapping("/api/orders/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable int id) {
		
		return ResponseEntity.status(HttpStatus.GONE)
				.body(orderService.deleteOrder(id));
	}
	@PutMapping("/api/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable int id,@RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(orderService.updateOrder(id, order));
	}
//	@GetMapping("/api/books")
//	public List<BookDTO> getBooks(){
//		return bookFeignClient.findAll();
//	}
//	@GetMapping("/api/books/{id}")
//	public BookDTO getBookByID(@PathVariable int id) {
//		return bookFeignClient.findById(id);
//	}
//	@PostMapping("/api/books")
//	public BookDTO saveBookDTO(@RequestBody BookDTO book) { 
//		return bookFeignClient.saveBookDTO(book);
//	}
//	@PutMapping("/api/books/{id}")
//	public BookDTO updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO ) {
//		return bookFeignClient.updateBook(id, bookDTO);
//	}
//	@DeleteMapping("/api/books/{id}")
//	public String deleteBook(@PathVariable int id) {
//		return bookFeignClient.deleteBook(id);
//	}
}
