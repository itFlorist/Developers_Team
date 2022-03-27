package com.sprint3.controller;

import java.time.LocalDate;
import java.util.List;

import com.sprint3.dao.FloristDaoException;
import com.sprint3.dto.Ticket;
import com.sprint3.gui.TicketView;
import com.sprint3.service.TicketService;

public class TicketController {

	private TicketView ticketView;
	private TicketService ticketService;

	public TicketController(TicketView ticketView, TicketService ticketService) {
		this.ticketView = ticketView;
		this.ticketService = ticketService;
	}

	public void runDisplayTickets() throws FloristDaoException {

		boolean keepGoing = true;
		int menuSelection;
		while (keepGoing) {
			menuSelection = getShowTicketMenu();

			switch (menuSelection) {
			case 1:
				showAllTickets();
				break;
			case 2:
				showByDate();
				break;
			case 0:
				keepGoing = false;
				break;
			default:
				unknownCommand();
			}
		}
	}

	private void showAllTickets() throws FloristDaoException {

		ticketView.displayTicketsBanner();
		List<Ticket> tickets = ticketService.getAllTickets();
		ticketView.displayAllTickets(tickets);
	}

	private void showByDate() throws FloristDaoException {

		ticketView.displayTicketsByDateBanner();
		LocalDate dateTicket = ticketView.getTicketDateChoice();
		List<Ticket> tickets = ticketService.getAllTickets();
		ticketView.displayTicketsByDate(tickets, dateTicket);
	}

	private int getShowTicketMenu() {
		return ticketView.displayTicketMenu();
	}

	public void unknownCommand() {
		System.out.println("Unknown command!");

	}

	public void getTotalIncome() throws FloristDaoException {
		float income = ticketService.getTotalIncome();
		ticketView.displayTotalIncome(income);
	}

}
