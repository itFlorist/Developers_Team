package com.sprint3.dto;

public abstract class Product {

	private int id;
	private String name;
	private float price;
	
	public Product() {}
	
	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	abstract void toDo();
}
