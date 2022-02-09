package com.sprint3.gui;

public class TicketView {

	/**
	 * This class contains the menu's methods
	 */

	private Teclado io;

	public TicketView(Teclado io) {
		this.io = io;
	}

	public void displayTotalIncome(float income) {
		io.print("\n*******TOTAL INCOME******");
		io.print("--------------------------");
		io.print("       " + income + "€     ");
		io.print("--------------------------");
	}

}
