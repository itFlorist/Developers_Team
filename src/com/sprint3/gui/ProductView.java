package com.sprint3.gui;

public class ProductView {

	/**
	 * This class contains the menu's methods
	 */

	private Teclado io;

	public ProductView(Teclado io) {
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

		return io.leerInt("Please select one choice.", 1, 7);

	}

	public void displayErrorMessage(String errorMsg) {
		io.print("=== ERROR ===");
		io.print(errorMsg);
	}

	public void displayUnknownCommandBanner() {
		io.print("Unknown command!");
		
	}
}

//	public static void showMenuPrincipal() {
//		System.out.println(" ");
//		System.out.println(" FLORIST");
//		System.out.println(" ");
//		System.out.println("************************************************");
//		System.out.println("*  Please, choose an option: ");
//		System.out.println("*    1.-Create file Florist");
//		System.out.println("*    2.-Add Product");
//		System.out.println("*    3.-Delete Product");
//		System.out.println("*    4.-Show stock");
//		System.out.println("*    0.-Exit");
//		System.out.println("************************************************");
//		System.out.println(" ");
//		System.out.print(">> ");
//	}
//
//	public static void showAddMenu() {
//		System.out.println(" ");
//		System.out.println(" ADD MENU");
//		System.out.println(" ");
//		System.out.println("************************************************");
//		System.out.println("*  Please, choose an option: ");
//		System.out.println("*    1.-Add Tree");
//		System.out.println("*    2.-Add Flower");
//		System.out.println("*    3.-Add Decoration");
//		System.out.println("*    0.-Back to Principal ProductView");
//		System.out.println("************************************************");
//		System.out.println(" ");
//		System.out.print(">> ");
//	}
//
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
//
//
