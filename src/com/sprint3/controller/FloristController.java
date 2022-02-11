package com.sprint3.controller;

import java.time.LocalDate;
import java.util.List;

import com.sprint3.dao.FloristDao;
import com.sprint3.dao.FloristDaoException;
import com.sprint3.dao.TicketDao;
import com.sprint3.dto.Product;
import com.sprint3.dto.Ticket;
import com.sprint3.gui.FloristView;
import com.sprint3.gui.TicketView;
import com.sprint3.controller.TicketController;

public class FloristController {

	private FloristView floristView;
	private FloristDao floristDao;
	private TicketController ticketController;


	public FloristController(FloristView floristView, FloristDao floristDao, TicketController ticketController) {
		this.floristView = floristView;
		this.floristDao = floristDao;
		this.ticketController = ticketController;
	}

	public void runProduct() {

		boolean keepGoing = true;
		int choice = 0;

		try {
			while (keepGoing) {
				choice = getMenuProduct();

				switch (choice) {
				case 1:
					addProductSelection();
					break;
				case 2:
					removeProduct();
					break;
				case 3:
					showFloristStock();
					break;
				case 4:
					showFloristValue();
					break;
				case 5:
					showCurrentPurchaseReceipt();
					break;
				case 6:
					showTickets();
					break;
				case 7:
					totalIncome();
					break;
				case 0:
					keepGoing = false;
					break;
				default:
					unknownCommand();
				}
			}
			exitMessage();

		} catch (Exception e) {
			floristView.displayErrorMessage(e.getMessage());
		}
	}

	private void addProductSelection() throws FloristDaoException {
		boolean keepGoing = true;
		int menuSelection;
		while (keepGoing) {
			menuSelection = getAddMenuSelection();

			switch (menuSelection) {
			case 1:
				addProduct("Tree");
				break;
			case 2:
				addProduct("Flower");
				break;
			case 3:
				addProduct("Decoration");
				break;
			case 0:
				keepGoing = false;
				break;
			default:
				unknownCommand();
			}
		}
	}

	private void addProduct(String product) throws FloristDaoException {
		floristView.displayCreateProductBanner(product);
		Product newProduct = floristView.getNewProductInfo(product);
		floristDao.addProductType(newProduct.getId(), newProduct);
		floristView.displayCreateSuccessBanner(product);
	}

	private void removeProduct() throws FloristDaoException {
		floristView.displayRemoveProductBanner();
		int id = floristView.getProductIdChoice();
		Product removedProduct = floristDao.removeProduct(id);
		floristView.displayRemoveResult(removedProduct);
	}

	private void showFloristStock() throws FloristDaoException {
		floristView.displayStockBanner();
		List<Product> stock = floristDao.getAllStock();
		floristView.displayTotalTypeProducts(stock);
		floristView.displayFloristStock(stock);
	}

	private void showFloristValue() throws FloristDaoException {
		float value = floristDao.getFloristValue();
		floristView.displayStockValue(value);
	}

	private void showCurrentPurchaseReceipt() throws FloristDaoException {
		floristView.displayCurrentReceiptBanner();
		// Ticket currentTicket = null;

		boolean keepGoing = true;
		boolean receiptIsEmpty = true;
		int menuSelection = -1;

		do {

			if (receiptIsEmpty) {
				menuSelection = getReceiptMenuSelectionP();
			} else {
				menuSelection = getReceiptMenuSelectionC();
			}

			switch (menuSelection) {
			case 1:
				addProductToReceipt();
				receiptIsEmpty = false;
				break;
			case 2:
				showFloristStock();
				break;
			case 3:
				// discardProduct();
				break;
			case 4:
				// confirmReceipt();
				receiptIsEmpty = true;
				break;
			case 0:
				keepGoing = false;
				break;
			default:
				unknownCommand();
			}
		} while (keepGoing);

	}

	private void addProductToReceipt() throws FloristDaoException {
		floristView.addProductToReceiptBanner();
		int id = floristView.getProductIdChoice();
		Product productToAdd = floristDao.getProduct(id);
		
		if (productToAdd == null) {
			floristView.displayErrorMessage("Requested product is not available at stock");
			return;
		} else {
			 * -añadir producto a ticket
//			 * -borrar producto de stock
			Product removedProduct = floristDao.removeProduct(id);
			System.out.println("The product " + removedProduct + " has been removed from stock");
//			 * -mensaje transaccion exitosa
			System.out.println("=)");
		}
//		FloristManagerDao.getiD();
//			Floristeria floristeria(name, idProd, idTicket);

		/*comprobar que id existe ---service
//		if(currentTicket == null) {
//			currentTicket = new Ticket();
//		}
		//si idExiste{
		 * -añadir producto a ticket
		 * -borrar producto de stock
		 * -mensaje transaccion exitosa
		 * }else{
		 * imprimir error en view
     */
	}

	private int getReceiptMenuSelectionC() {
		return floristView.menuReceiptComplete();
	}

	private int getReceiptMenuSelectionP() {
		return floristView.menuReceiptPartial();
	}

	private void showTickets() throws FloristDaoException {

		ticketController.runDisplayTickets();
	}

	/*
	 * Alb
	 */
	private void totalIncome() throws FloristDaoException {
		ticketController.getTotalIncome();
//		float income = ticketDao.getTotalIncome();
//		ticketView.displayTotalIncome(income);
	}

	private int getMenuProduct() {
		return floristView.menuProduct();
	}

	private void unknownCommand() {
		floristView.unknownCommand();
	}

	private void exitMessage() {
		floristView.displayExitBanner();

	}

	private int getAddMenuSelection() {
		return floristView.printAddMenuAndGetSelection();
	}
}