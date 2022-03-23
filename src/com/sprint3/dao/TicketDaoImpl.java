package com.sprint3.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sprint3.dto.Ticket;

public class TicketDaoImpl implements TicketDao {

	private Map<Integer, Ticket> tickets = new HashMap<>();
	private final String TICKET_FILE;
	private final String DELIMITER = "::";

	public TicketDaoImpl() {
		TICKET_FILE = "ticket.txt";
	}

	/*
	 * Alb
	 */
	public float getTotalIncome() throws TicketDaoException {
		loadTicket();
		float income = 0;
		for (Map.Entry<Integer, Ticket> entry : tickets.entrySet()) {
			income = income + entry.getValue().getTotalPurchasePrice();
		}
		return income;
	}

	private void loadTicket() throws TicketDaoException {
		Scanner scanner;
		try {
			// Create Scanner for reading the file
			scanner = new Scanner(new BufferedReader(new FileReader(TICKET_FILE)));
		} catch (FileNotFoundException e) {
			throw new TicketDaoException("-_- Could not load roster data into memory.", e);
		}
		// currentLine holds the most recent line read from the file
		String currentLine;
		// currentTicket holds the most recent Ticket unmarshalled
		Ticket currentTicket;
		// Go through TICKET_FILE line by line, decoding each line into a Ticket
		// object by calling the unmarshallTicket method. Process while we have more
		// more lines in the file
		while (scanner.hasNextLine()) {
			// get the next line in the file
			currentLine = scanner.nextLine();
			// unmarshall the line into a Ticket
			currentTicket = unmarshallTicket(currentLine);
//			System.out.println(currentTicket);
			// The Ticket id is used as a map key to put the currentTicket into the map
			tickets.put(currentTicket.getTicketId(), currentTicket);
		}
		// Clean up
		scanner.close();
	}

	private Ticket unmarshallTicket(String ticketAsText) {
		// ticketAsText is expecting a line read in from our file.
		// E.g., it might look like this:
		// 00001::07/07/2022::85.95
		// TicketId::date::totalPurchasePrice
		//
		// 00001::Oak::49.99::5.75
		// productId::productName::productPrice::productFeature
		//
		// This line is then split at the DELIMITER (::), leaving an array of Strings,
		// stored as ticketTokens, which should look like this:
		// _________________________
		// | | | | | | | | | | | | |
		// |00001|07/07/2022 |85.95|
		// | | | | | | | | | | | | |
		// -------------------------
		// [0] [1] [2]
		// ___________________________
		// | | | | | | | | | | | | | |
		// |000022 | Oak |49.99| 5.75|
		// | | | | | | | | | | | | | |
		// ---------------------------
		// [3] [4] [5] [6]

		String[] productTokens = ticketAsText.split(DELIMITER);
		String ticketId = productTokens[0];
		String date = productTokens[1];
		String totalPurchasePrice = productTokens[2];
//		String productId = productTokens[3];
//		String productName = productTokens[4];
//		String productPrice = productTokens[5];
//		String productFeature = productTokens[6];

		// A new Project object is created using the id to satisfy the
		// requirements of the Project constructor
		int id = Integer.parseInt(ticketId);
		float totalPurchase = Float.parseFloat(totalPurchasePrice);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
//		LocalDate localDate = LocalDate.parse(date);
		Ticket ticketFromFile = new Ticket(id, localDate, totalPurchase);

		return ticketFromFile;
	}

	public List<Ticket> getAllTickets() throws TicketDaoException {
		loadTicket();
		List<Ticket> tickets = getTickets();
		return tickets;
	}

	public List<Ticket> getTickets() throws TicketDaoException {
		return new ArrayList<Ticket>(tickets.values());
	}

//	public List<Ticket> getOldTickets(List<Ticket> tickets, LocalDate date) throws FloristDaoException {
//		loadTicket();
//		return tickets;
//	}
}
