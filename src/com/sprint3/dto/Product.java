package com.sprint3.dto;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {

	private static int id;
	private String name;
	private float price;
	private List<Product> stock;
	
	public Product() {}
	
	public Product(int id, String name, float price) {
		super();
		this.id = Product.id++;
		this.name = name;
		this.price = price;
		this.stock = new ArrayList<Product>();
	}

	abstract void toDo();
}
