package com.lpu.order_service.entity;

public class BookDTO {
	private int id;
	private String title;
	private double price;
	private int quantity;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BookDTO() {
		super();
	}
	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
