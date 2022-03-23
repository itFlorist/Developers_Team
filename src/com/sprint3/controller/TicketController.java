package com.sprint3.controller;

import java.time.LocalDate;
import java.util.List;

import com.sprint3.dao.FloristDao;
import com.sprint3.dao.FloristDaoException;
import com.sprint3.dto.Product;
import com.sprint3.dto.Ticket;
import com.sprint3.gui.TicketView;
import com.sprint3.dao.TicketDao;
import com.sprint3.dao.TicketDaoException;
import com.sprint3.gui.FloristView;

public class TicketController {

	private TicketView ticketView;
	private TicketDao ticketDao;

	public TicketController(TicketView ticketView, TicketDao ticketDao) {
		super();
		this.ticketView = ticketView;
		this.ticketDao = ticketDao;
	}

	public void runDisplayTickets() throws TicketDaoException {

		boolean keepGoing = true;
		int menuSelection;
		while (keepGoing) {
			menuSelection = getShowTicketMenu();

			switch (menuSelection) {
			case 1:
				showAllTickets();
				break;
			case 2:
				shortByDate();
				break;
			case 0:
				keepGoing = false;
				break;
			default:
				unknownCommand();
			}
		}
	}

	private void showAllTickets() throws TicketDaoException {

		ticketView.displayTicketsBanner();
		List<Ticket> tickets = ticketDao.getAllTickets();
		ticketView.displayAllTickets(tickets);
	}

	private void shortByDate() throws TicketDaoException {

		ticketView.displayTicketsByDateBanner();
		LocalDate dateTicket = ticketView.getTicketDateChoice();
		List<Ticket> tickets = ticketDao.getAllTickets();
//		tickets = ticketDao.getOldTickets(tickets, dateTicket);
		ticketView.displayTicketsByDate(tickets, dateTicket);
	}

	private int getShowTicketMenu() {
		return ticketView.displayTicketMenu();
	}

	public void unknownCommand() {
		System.out.println("Unknown command!");

	}
}

//	public void runProduct() {
//
//		boolean keepGoing = true;
//		int choice = 0;
//
//		try {
//			while (keepGoing) {
//				choice = getMenuProduct();
//
//				switch (choice) {
//				case 1:
//					addProductSelection();
//					break;
//				case 2:
//					removeProduct();
//					break;
//				case 3:
//					showFloristStock();
//					break;
//				case 4:
//					showFloristValue();
//					break;
//				case 5:
//					showCurrentPurchaseReceipt();
//					break;
//				case 6:
//					showPurchaseReceipts();
//					break;
//				case 7:
//					totalIncome();
//					break;
//				case 0:
//					keepGoing = false;
//					break;
//				default:
//					// unknownCommand();
//				}
//			}
//			exitMessage();
//
//		} catch (Exception e) {
//			floristView.displayErrorMessage(e.getMessage());
//		}
//	}
//
//	private void addProductSelection() throws FloristDaoException {
//		boolean keepGoing = true;
//		int menuSelection;
//		while (keepGoing) {
//			menuSelection = getAddMenuSelection();
//
//			switch (menuSelection) {
//			case 1:
//				addProduct("Tree");
//				break;
//			case 2:
//				addProduct("Flower");
//				break;
//			case 3:
//				addProduct("Decoration");
//				break;
//			case 0:
//				keepGoing = false;
//				break;
//			default:
//				unknownCommand();
//			}
//		}
//	}
//
//	private void addProduct(String product) throws FloristDaoException {
//		floristView.displayCreateProductBanner(product);
//		Product newProduct = floristView.getNewProductInfo(product);
//		floristDao.addProductType(newProduct.getId(), newProduct);
//		floristView.displayCreateSuccessBanner(product);
//	}
//
//	private void removeProduct() throws FloristDaoException {
//		floristView.displayRemoveProductBanner();
//		int id = floristView.getProductIdChoice();
//		Product removedProduct = floristDao.removeProduct(id);
//		System.out.println(removedProduct);
//		floristView.displayRemoveResult(removedProduct);
//	}
//
//	private void showFloristStock() throws FloristDaoException {
//		floristView.displayStockBanner();
//		List<Product> stock = floristDao.getAllStock();
//		floristView.displayTotalTypeProducts(stock);
//		floristView.displayFloristStock(stock);
//	}
//
//	private void showFloristValue() throws FloristDaoException {
//		float value = floristDao.getFloristValue();
//		floristView.displayStockValue(value);
//	}
//
//	private void showCurrentPurchaseReceipt() {
//		floristView.displayCurrentReceiptBanner();
//
//		boolean keepGoing = true;
//		int menuSelection;
//		while (keepGoing) {
//			menuSelection = getAddMenuSelection();

//			switch (menuSelection) {
//			case 1:
//				addProduct("Tree");
//				break;
//			case 2:
//				addProduct("Flower");
//				break;
//			case 3:
//				addProduct("Decoration");
//				break;
//			case 0:
//				keepGoing = false;
//				break;
//			default:
//				unknownCommand();
//			}
//		}
//
//		floristView.displayRemoveProductBanner();
//		int id = floristView.getProductIdChoice();
//		Product removedProduct = floristDao.removeProduct(id);
//		System.out.println(removedProduct);
//		floristView.displayRemoveResult(removedProduct);
//	}
//
//	private void showOldPurchaseReceipts() {
//
//		// Oliver
//
//	}
//
//	private void totalIncome() {
//
//	}
//
//	private int getMenuProduct() {
//		return floristView.menuProduct();
//	}
//
//	private void unknownCommand() {
//		floristView.unknownCommand();
//	}
//
//	private void exitMessage() {
//		floristView.displayExitBanner();
//
//	}
//
//	private int getAddMenuSelection() {
//		return floristView.printAddMenuAndGetSelection();
//	}
//}