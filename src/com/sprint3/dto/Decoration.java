package com.sprint3.dto;

public class Decoration extends Product {
	
	private String material;
	
	public Decoration(String material) {
		super();
		this.material = material;
	}


	public String getMaterial() { return material; }
	public void setMaterial(String material) { this.material = material; }

	
	@Override
	public String toString() {
		return "Decoration [material=" + material + "]";
	}

	@Override
	void toDo() {
		// TODO Auto-generated method stub
		
	}
}
