package com.sprint3.dto;

import java.util.List;
import java.util.Scanner;

public class Florist {

	private String name;
	private List<Product> stock;
	private float totalValue;

	public Florist() {

	}

	public Florist(String name, List<Product> stock, float totalValue) {
		super();
		this.name = name;
		this.stock = stock;
		this.totalValue = totalValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getStock() {
		return stock;
	}

	public void setStock(List<Product> stock) {
		this.stock = stock;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return "Florist [name=" + name + ", stock=" + stock + ", totalValue=" + totalValue + "]";
	}

}
