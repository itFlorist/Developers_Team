package com.sprint3.models;

public class Flower {

	private int flowerId;
	private String flowerName;
	private String flowerColour;
	private float flowerPrice;

	public Flower(int flowerId, String flowerName, String flowerColour, float flowerPrice) {
		super();
		this.flowerId = flowerId;
		this.flowerName = flowerName;
		this.flowerColour = flowerColour;
		this.flowerPrice = flowerPrice;
	}

	public int getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(int flowerId) {
		this.flowerId = flowerId;
	}

	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public String getFlowerColour() {
		return flowerColour;
	}

	public void setFlowerColour(String flowerColour) {
		this.flowerColour = flowerColour;
	}

	public float getFlowerPrice() {
		return flowerPrice;
	}

	public void setFlowerPrice(float flowerPrice) {
		this.flowerPrice = flowerPrice;
	}

	@Override
	public String toString() {
		return "Flower [flowerId=" + flowerId + ", flowerName=" + flowerName + ", flowerColour=" + flowerColour
				+ ", flowerPrice=" + flowerPrice + "]";
	}

}
