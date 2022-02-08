package com.sprint3.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {

	private int ticketId;
	private LocalDate date;
	private float totalPurchasePrice;

	private int productId;
	private String productName;
	private float productPrice;
	private String productFeature;

	public Ticket() {

	}

	public Ticket(int ticketId, LocalDateTime date, float totalPurchasePrice, int productId, String productName,
			float productPrice, String productFeature) {
		super();
		this.ticketId = ticketId;
		this.date = LocalDate.now();
		this.totalPurchasePrice = totalPurchasePrice;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productFeature = productFeature;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public float getTotalPurchasePrice() {
		return totalPurchasePrice;
	}

	public void setTotalPurchasePrice(float totalPurchasePrice) {
		this.totalPurchasePrice = totalPurchasePrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductFeature() {
		return productFeature;
	}

	public void setProductFeature(String productFeature) {
		this.productFeature = productFeature;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", date=" + date + ", totalPurchasePrice=" + totalPurchasePrice
				+ ", productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productFeature=" + productFeature + "]";
	}

}
