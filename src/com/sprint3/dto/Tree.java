package com.sprint3.dto;

public class Tree extends Product {

	private float height;

	public Tree() {

	}

	public Tree(int id, String name, float price, float height) {
		super(id, name, price);
		this.height = height;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Tree [height=" + height + "]";
	}

	@Override
	void toDo() {
		// TODO Auto-generated method stub

	}
}
