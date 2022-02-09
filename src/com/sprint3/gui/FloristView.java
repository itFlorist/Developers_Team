package com.sprint3.gui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.sprint3.dto.Decoration;
import com.sprint3.dto.Flower;
import com.sprint3.dto.Product;
import com.sprint3.dto.Ticket;
import com.sprint3.dto.Tree;

public class FloristView {

	/**
	 * This class contains the menu's methods
	 */

	private Teclado io;

	public FloristView(Teclado io) {
		this.io = io;
	}

	public int menuProduct() {

		io.print("\n== MAIN MENU ==");
		io.print("1. Add Product.");
		io.print("2. Delete Product.");
		io.print("3. Show Florist's stock.");
		io.print("4. Show Florist's value.");
		io.print("5. Get current purchase receipt.");
		io.print("6. Get old purchase receipts.");
		io.print("7. Display total income.");
		io.print("0. Exit.\n");

		return io.leerInt("Please select one choice: ", 0, 7);

	}

	/**
	 * Method that prints on console the AddMenu and gets an option chosen by the
	 * user
	 * 
	 * @return int
	 */
	public int printAddMenuAndGetSelection() {
		System.out.println(" ");
		System.out.println(" ADD MENU");
		System.out.println(" ");
		System.out.println("************************************************");
		System.out.println("*  Please, choose an option: ");
		System.out.println("*    1.-Add Tree");
		System.out.println("*    2.-Add Flower");
		System.out.println("*    3.-Add Decoration");
		System.out.println("*    0.-Back");
		System.out.println("************************************************");
		System.out.println(" ");
		System.out.print(">> ");

		return io.leerInt("Please select one option from the above.");

	}

	public void displayErrorMessage(String errorMsg) {
		io.print("=== ERROR ===");
		io.print(errorMsg);
	}

	public void displayUnknownCommandBanner() {
		io.print("Unknown command!");
	}

	public void displayCreateProductBanner(String product) {
		if (product == "Tree") {
			System.out.println("=== Add Tree ===");
		} else if (product == "Flower") {
			System.out.println("=== Add Flower ===");
		} else if (product == "Decoration") {
			System.out.println("=== Add Decoration ===");
		}
	}

	/**
	 * Getting the info and instantiating a new Product (Tree, Flower o Decoration)
	 * depending on the parameter passed.
	 * 
	 * @author ALBERTO
	 * @param A String specfying the type of the product
	 * @return A type of Product
	 */
	public Product getNewProductInfo(String product) {
		Product currentProduct;

		int id = io.leerInt("Please enter the " + product + " id: ");
		String name = io.leerString("Please enter the " + product + " name: ");
		float price = io.leerFloat("Please enter the " + product + " price: ");

		switch (product) {
		case "Tree": {
			float height = io.leerFloat("Please enter the " + product + " height: ");
			currentProduct = new Tree(id, name, price, height);
			break;
		}
		case "Flower": {
			String colour = io.leerString("Please enter the " + product + "colour: ");
			currentProduct = new Flower(id, name, price, colour);
			break;
		}
		case "Decoration": {
			String material = io.leerString("Please enter the " + product + " material: ");
			currentProduct = new Decoration(id, name, price, material);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + product);
		}
		return currentProduct;
	}

	public void displayCreateSuccessBanner(String product) {
		io.print(product + " successfully created. ");
	}

	public void displayStockBanner() {
		io.print("");
		io.print("=== Stock ===");
		io.print("");
	}

	public void displayTotalTypeProducts(List<Product> stock) {

		int treeStock = 0;
		int flowerStock = 0;
		int decorationStock = 0;

		for (Product product : stock) {
			if (product.getClass().getSimpleName().equals("Tree")) {
				treeStock++;
			} else if (product.getClass().getSimpleName().equals("Flower")) {
				flowerStock++;
			} else if (product.getClass().getSimpleName().equals("Decoration")) {
				decorationStock++;
			}
		}
		io.print("Trees: " + treeStock);
		io.print("Flowers: " + flowerStock);
		io.print("Decoration: " + decorationStock);
	}

	public void displayFloristStock(List<Product> stock) {
		String stockHeadings = String.format("%2s | %15s | %12s | %8s", "ID", "PRODUCT TYPE", "NAME", "PRICE");
		io.print(" ");
		io.print(stockHeadings);
		io.print(
				"-----------------------------------------------------------------------------------------------------------------");
		for (Product florist : stock) {
			String floristStock = String.format("%2s | %15s | %12s | %8s", florist.getId(),
					florist.getClass().getSimpleName(), florist.getName(), florist.getPrice());
			io.print(floristStock);
		}
		io.print(
				"-----------------------------------------------------------------------------------------------------------------");
		io.leerString("Please hit enter to continue");
	}

	public void displayExitBanner() {
		io.print("Bye bye!");
	}

	public void displayRemoveProductBanner() {
		io.print("\n=== Delete Product ===");
	}

	public int getProductIdChoice() {
		return io.leerInt("Please enter Product Id: ");
	}

	public void displayRemoveResult(Product productRecord) {
		if (productRecord != null) {
			io.print("Product successfully removed.");
		} else {
			io.print("No such Product.");
		}
		io.leerString("Please hit enter to continue.");
	}

	public void unknownCommand() {
		io.print("Unknown command!");

	}

	/**
	 * Method that shows on console the value recieved by parameter.
	 * 
	 * @param value
	 */
	public void displayStockValue(float value) {
		io.print("\n*******STOCK VALUE******");
		io.print("--------------------------");
		io.print("       " + value + "€     ");
		io.print("--------------------------");

	}

	public void displayOldReceiptsBanner() {
		io.print("\n-- Old Purchase Receipts --");

	}

	public void displayAllTickets(List<Ticket> tickets) {

		String stockHeadings = String.format("%2s | %15s | %12s", "TICKETID", "TICKETDATE", "TOTALPRICE");
		io.print(" ");
		io.print(stockHeadings);
		io.print(
				"-----------------------------------------------------------------------------------------------------------------");
		for (Ticket ticket : tickets) {
			String ticketStock = String.format("%2s | %15s | %12s", ticket.getTicketId(), ticket.getDate(),
					ticket.getTotalPurchasePrice());
			io.print(ticketStock);
		}
		io.print(
				"-----------------------------------------------------------------------------------------------------------------");
		io.leerString("Please hit enter to continue");

//		for (Ticket ticket : tickets) {
//			io.print(ticket.toString());
//			io.print("Showing all tickets..."); //Provisional para visualizar
//		}
	}

	public LocalDate getTicketDateChoice() {
		LocalDate dateTicket = null;
		int year = io.leerInt("\nPlease enter Purchase's year: ", 2020, 2022);
		int month = io.leerInt("\nPlease enter Purchase's month by number: ", 1, 12);
		int day = io.leerInt("\nPlease enter Purchase's day: ", 1, 31);
		dateTicket = LocalDate.of(year, month, day);
		io.print("\nTicket's date: " + dateTicket);
		return dateTicket;

	}

	public void displayOldTickets(List<Ticket> tickets, LocalDate dateTicket) {

		String stockHeadings = String.format("%2s | %15s | %12s", "TICKETID", "TICKETDATE", "TOTALPRICE");
		io.print(" ");
		io.print(stockHeadings);
		io.print(
				"-----------------------------------------------------------------------------------------------------------------");
		for (Ticket ticket : tickets) {
			if (ticket.getDate() == dateTicket) {
				foundTicket();
				String ticketStock = String.format("%2s | %15s | %12s", ticket.getTicketId(), ticket.getDate(),
						ticket.getTotalPurchasePrice());
				io.print(ticketStock);
			}
		}
		io.print(
				"-----------------------------------------------------------------------------------------------------------------");
		io.leerString("Please hit enter to continue");

//		for (Ticket ticket : tickets) {
//			if (ticket.getDate() == dateTicket) {
//				foundTicket();
//				io.print(ticket.toString());
//
//			} else {
//				notFoundTicket();
//				io.print("\nNo tickets for this date: " + dateTicket);
//			}
//		}

	}

	private void notFoundTicket() {
		io.print("Not found ticket!");

	}

	private void foundTicket() {
		io.print("Ticket found!");
	}

	public void displayCurrentReceiptBanner() {
		io.print("\n ########  CURRENT RECEIPT  ########");
		io.print("\n ### nº :                        ###");
		io.print("\n ### Date :                      ###");
		io.print("\n ###################################");
	}

	public int menuReceiptComplete() {

		io.print("\n== RECEIPT MENU ==");
		io.print("1. Add Product");
		io.print("2. Display Products");
		io.print("3. Discard Product");
		io.print("4. Confirm Receipt");
		io.print("0. Exit.\n");

		return io.leerInt("Please select one choice: ", 0, 4);
	}

	public int menuReceiptPartial() {

		io.print("\n== RECEIPT MENU ==");
		io.print("1. Add Product");
		io.print("2. Display Products");
		io.print("0. Exit.\n");

		return io.leerInt("Please select one choice: ", 0, 2);
	}

	public void addProductToReceiptBanner() {
		io.print("---ADD PRODUCT---");

	}

	public void displayTicketsBanner() {
		io.print("\n--- SHOW TICKETS ---");

	}
}
