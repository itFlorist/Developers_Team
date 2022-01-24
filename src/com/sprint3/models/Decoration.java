package com.sprint3.models;

public class Decoration {
	
	private String material;
	
	public Decoration(String material) {
		this.material = material;
	}

	
	
	public String getMaterial() { return material; }

	public void setMaterial(String material) { this.material = material; }

	
	@Override
	public String toString() {
		return "Decoration [material=" + material + "]";
	}
}
