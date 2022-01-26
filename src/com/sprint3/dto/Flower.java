package com.sprint3.dto;

public class Flower extends Product {

	private String colour;

	public Flower(String colour) {
		super();
		this.colour = colour;
	}
	
	
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
	void toDo() {
		// TODO Auto-generated method stub
		
	}
}
