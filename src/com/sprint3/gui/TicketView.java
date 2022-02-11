package com.sprint3.gui;

import java.time.LocalDate;
import java.util.List;

import com.sprint3.dto.Ticket;

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

	public int displayTicketMenu() {
		io.print("\n== TICKET MENU ==");
		io.print("1. Show all tickets");
		io.print("2. Show tickets by date");
		io.print("0. Exit.\n");

		return io.leerInt("Please select one choice: ", 0, 2);
	}

	public void displayAllTickets(List<Ticket> tickets) {

		if (tickets.isEmpty()) {
			io.print("There is no tickets");
		} else {
			String stockHeadings = String.format("%8s | %15s | %12s", "TICKETID", "TICKETDATE", "TOTALPRICE");
			io.print(" ");
			io.print(stockHeadings);
			io.print(
					"-----------------------------------------------------------------------------------------------------------------");
			for (Ticket ticket : tickets) {
				String ticketStock = String.format("%8s | %15s | %12s", ticket.getTicketId(), ticket.getDate(),
						ticket.getTotalPurchasePrice());
				io.print(ticketStock);
			}
			io.print(
					"-----------------------------------------------------------------------------------------------------------------");
		}
	}

	public LocalDate getTicketDateChoice() {
		LocalDate dateTicket = null;
		int year = io.leerInt("\nPlease enter Purchase's year: ", 2020, 2022);
		int month = io.leerInt("Please enter Purchase's month by number: ", 1, 12);
		int day = io.leerInt("Please enter Purchase's day: ", 1, 31);
		dateTicket = LocalDate.of(year, month, day);
		io.print("\nTicket´s search by date " + dateTicket + " in progress...");
//		io.print("\nTicket's date: " + dateTicket);
		return dateTicket;
	}

	public void displayTicketsByDate(List<Ticket> tickets, LocalDate dateTicket) {

		boolean found = false;

		String stockHeadings = String.format("%8s | %15s | %12s", "TICKETID", "TICKETDATE", "TOTALPRICE");
		io.print(" ");
		io.print(stockHeadings);
		io.print(
				"-----------------------------------------------------------------------------------------------------------------");

		for (Ticket ticket : tickets) {
			if (ticket.getDate().isEqual(dateTicket)) {
//				foundTicket(dateTicket);

				String ticketStock = String.format("%8s | %15s | %12s", ticket.getTicketId(), ticket.getDate(),
						ticket.getTotalPurchasePrice());
				io.print(ticketStock);

				found = true;
			}
		}
		io.print(
				"-----------------------------------------------------------------------------------------------------------------");
		if (!found) {
			notFoundTicket(dateTicket);
		}
//		io.leerString("Please hit enter to continue");
	}

	private void notFoundTicket(LocalDate dateTicket) {
		io.print("\n***** No tickets from this date: " + dateTicket + " *****");

	}

	private void foundTicket(LocalDate dateTicket) {
		io.print("\nShowing ticket/s from this date: " + dateTicket);
	}

	public void displayTicketsByDateBanner() {
		io.print("\n-- SHOW TICKETS BY DATE --");

	}

	public void displayTicketsBanner() {
		io.print("\n--- SHOWING ALL TICKETS FROM THIS FLORIST ---");

	}

}
