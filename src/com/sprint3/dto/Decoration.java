package com.sprint3.dto;

public class Decoration extends Product {

	private String material;

	public Decoration(String material) {
		super();
		this.material = material;
	}
	
	public Decoration(int id, String name, float price, String material) {
		super(id, name, price);
		this.material = material;
	}

	@Override
	public String getMaterial() { 
		return material; 
	}
	public void setMaterial(String material) { 
		this.material = material; 
		}

	@Override
	public String toString() {
		return "Decoration [material=" + material + "]";
	}

	@Override
	public float getHeight() {
		return 0;
	}

	@Override
	public String getFlowerColour() {
		return null;
	}

}
