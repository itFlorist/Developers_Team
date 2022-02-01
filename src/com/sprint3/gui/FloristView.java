package com.sprint3.gui;

import com.sprint3.dto.Decoration;
import com.sprint3.dto.Flower;
import com.sprint3.dto.Product;
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

		io.print("\nMAIN MENU");
		io.print("1. Add Product.");
		io.print("2. Delete Product.");
		io.print("3. Show Florist´s stock.");
		io.print("4. Show Florist´s value.");
		io.print("5. Get current purchase receipt.");
		io.print("6. Get old purchase receipts.");
		io.print("7. Display total income.");
		io.print("0. Exit.\n");

		return io.leerInt("Please select one choice.", 0, 7);

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
		String name = io.leerString("Please enter the product name: ");
		float price = io.leerFloat("Please enter the product price: ");

		switch (product) {
		case "Tree": {
			float height = io.leerFloat("Please enter the produt height: ");
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
		System.out.println("=== Stock ===");
	}

//	public void displayFloristStock(List<Product> stock) {
//		String stockHeadings = String.format("%-25s | %10s", "Florist´s name", "Stock");
//		io.print(stockHeadings);
//		io.print(
//				"-----------------------------------------------------------------------------------------------------------------");
//		for (Product florist : stock) {
//			String floristStock = String.format("%-25s | %10s", florist.getName(), florist.getStock());
//			io.print(floristStock);
//		}
//		io.leerString("Please hit enter to continue");
//	}

	public void displayOldPurchasesBanner() {
		System.out.println("=== Old Purchases ===");
	}

	public void displayExitBanner() {
		io.print("Bye bye!");
	}

	public void displayRemoveProductBanner() {
		io.print("-- Delete Product --");
	}

	public int getProductIdChoice() {
		return io.leerInt("Please enter Product Id");
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

}

//	public static void showDeleteMenu() {
//		System.out.println(" ");
//		System.out.println(" DELETE MENU");
//		System.out.println(" ");
//		System.out.println("************************************************");
//		System.out.println("*  Please, choose an option: ");
//		System.out.println("*    1.-Delete Tree");
//		System.out.println("*    2.-Delete Flower");
//		System.out.println("*    3.-Delete Decoration");
//		System.out.println("*    0.-Back to Principal ProductView");
//		System.out.println("************************************************");
//		System.out.println(" ");
//		System.out.print(">> ");
//	}
