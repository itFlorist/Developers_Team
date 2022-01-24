package com.sprint3.models;

public class Tree {

	private float height;

	public Tree(float height) {
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

}
