package com.sprint3.dto;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {

	private static int id;
	private String name;
	private float price;



	
	
	public Product() {}
	

	public Product(int id, String name, float price) {
		super();
		this.id = Product.id++;
		this.name = name;
		this.price = price;
		this.stock = new ArrayList<Product>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	abstract void toDo();
}
