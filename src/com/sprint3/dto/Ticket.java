package com.sprint3.dto;

import java.util.Date;
import java.util.List;

public class Ticket {

	private int idTicket;
	private Date date;
	private List<Product> purchase;
	private float totalCost;
	
	public Ticket() {}
	
	public Ticket(int idTicket) {
		this.idTicket = idTicket;
		this.date = new Date(); 
	}

	public int getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public List<Product> getPurchase() {
		return purchase;
	}
	public void setPurchase(List<Product> purchase) {
		this.purchase = purchase;
	}

	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	
}
