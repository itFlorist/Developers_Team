package com.sprint3.gui;

public class ProductView {

	/**
	 * This class contains the menu's methods
	 */
	public static void showMenuPrincipal() {
		System.out.println(" ");
		System.out.println(" FLORIST");
		System.out.println(" ");
		System.out.println("************************************************");
		System.out.println("*  Please, choose an option: ");
		System.out.println("*    1.-Create file Florist");
		System.out.println("*    2.-Add Product");
		System.out.println("*    3.-Delete Product");
		System.out.println("*    4.-Show stock");
		System.out.println("*    0.-Exit");
		System.out.println("************************************************");
		System.out.println(" ");
		System.out.print(">> ");
	}

	public static void showAddMenu() {
		System.out.println(" ");
		System.out.println(" ADD MENU");
		System.out.println(" ");
		System.out.println("************************************************");
		System.out.println("*  Please, choose an option: ");
		System.out.println("*    1.-Add Tree");
		System.out.println("*    2.-Add Flower");
		System.out.println("*    3.-Add Decoration");
		System.out.println("*    0.-Back to Principal ProductView");
		System.out.println("************************************************");
		System.out.println(" ");
		System.out.print(">> ");
	}

	public static void showDeleteMenu() {
		System.out.println(" ");
		System.out.println(" DELETE MENU");
		System.out.println(" ");
		System.out.println("************************************************");
		System.out.println("*  Please, choose an option: ");
		System.out.println("*    1.-Delete Tree");
		System.out.println("*    2.-Delete Flower");
		System.out.println("*    3.-Delete Decoration");
		System.out.println("*    0.-Back to Principal ProductView");
		System.out.println("************************************************");
		System.out.println(" ");
		System.out.print(">> ");
	}

}
