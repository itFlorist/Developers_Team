package com.sprint3.dto;


public abstract class Product {

	private static int id;
	private String name;
	private float price;

	public Product() {}
	
	public Product(int id) {
		//this.id = Product.id++;
		this.id = id;
	}

	public Product(int id, String name, float price) {
		this.id = Product.id++;
		this.name = name;
		this.price = price;
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

	//public abstract Product getStock();

	public abstract float getHeight();

	public abstract String getFlowerColour();

	public abstract String getMaterial();

}
