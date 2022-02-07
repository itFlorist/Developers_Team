package com.sprint3.dto;

import java.util.List;
import java.util.Scanner;

public class Florist {

	private String name;
	private List<Product> stock;
	private float totalValue;
	
	private int idTicket;
//	private int idProduct;

	public Florist() {

	}
	
	public Florist(String name, int idTicket) {
		this.name = name;
		this.idTicket = idTicket;
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

	

	public int getIdTicket() {
		return idTicket++;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

//	public int getIdProduct() {
//		return idProduct++;
//	}
//	public void setIdProduct(int idProduct) {
//		this.idProduct = idProduct;
//	}
	
	@Override
	public String toString() {
		return "Florist [name=" + name + ", stock=" + stock + ", totalValue=" + totalValue + "]";
	}

}
