package com.sprint3.service;

import java.util.List;

import com.sprint3.dao.FloristDaoException;
import com.sprint3.dao.TicketDao;
import com.sprint3.dto.Ticket;

public class TicketService {

	private TicketDao ticketDao;

	public TicketService(TicketDao ticketDao) {
		super();
		this.ticketDao = ticketDao;
	}

	public List<Ticket> getAllTickets() throws FloristDaoException {
		return ticketDao.getAllTickets();
	}

	public float getTotalIncome() throws FloristDaoException {
		return ticketDao.getTotalIncome();
	}

}
