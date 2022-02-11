package com.sprint3.dao;

import java.time.LocalDate;
import java.util.List;

import com.sprint3.dto.Ticket;

public interface TicketDao {

	public float getTotalIncome() throws FloristDaoException;

	public List<Ticket> getAllTickets() throws FloristDaoException;
	
//	public List<Ticket> getTickets() throws FloristDaoException;
	
//	public List<Ticket> getOldTickets(List<Ticket> tickets, LocalDate date) throws FloristDaoException;
}
