package com.lpu.order_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lpu.order_service.entity.BookDTO;
import com.lpu.order_service.entity.Order;
import com.lpu.order_service.repository.OrderRepository;

@Service
public class OrderService {
	private BookFeignClient bookFeignClient;
	private OrderRepository orderRepository;
	public OrderService(BookFeignClient bookFeignClient, OrderRepository orderRepository) {
		super();
		this.bookFeignClient = bookFeignClient;
		this.orderRepository = orderRepository;
	}
	public Order saveOrder(Order order) {
		BookDTO bookDTO = bookFeignClient.findById(order.getBookid());
		order.setTotalprice(bookDTO.getPrice()*order.getQuantity());
		return orderRepository.save(order);
	}
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	public Order findById(int id) {
		return orderRepository.findById(id).get();
	}
	public String deleteOrder(int id) {
		orderRepository.deleteById(id);
		return "Order deleted";
	}
	public Order updateOrder(int id, Order order) {
		return orderRepository.save(order);
	}
}
