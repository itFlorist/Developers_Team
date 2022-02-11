package com.sprint3.dto;

public class Flower extends Product {

	private String colour;

	public Flower(String colour) {
		super();
		this.colour = colour;
	}

	public Flower(int id, String name, float price, String colour) {
		super(id, name, price);
		this.colour = colour;
	}
	
	@Override
	public String getFlowerColour() {
		return colour;
	}
	public void setFlowerColour(String colour) {
		this.colour = colour;
	}

	
	@Override
	public String toString() {
		return "Flower [colour=" + colour + "]";
	}

	@Override
	public float getHeight() {
		return 0;
	}
	@Override
	public String getMaterial() {
		return null;
	}
}
