package com.sprint3.gui;

import com.sprint3.dto.Tree;

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

	// Method that prints on console the AddMenu and gets a selection from the user.
	public int printAddMenuAndGetSelection() {
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

		return LecturaDatos.leerInt("Please select one option from the above.");
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

	public void displayUnknownCommandBanner() {
		System.out.println("Unknown command!");
	}

	public void displayCreateTreeBanner() {
		System.out.println("=== Add Tree ===");
	}

	public Tree getNewTreeInfo() {
		int id = LecturaDatos.leerInt("Please enter the Tree id");
		String name = LecturaDatos.leerLinea("Please enter the Tree name");
		float price = LecturaDatos.leerFloat("Please enter the Tree price");
		float height = LecturaDatos.leerFloat("Please enter the Tree height");
		// Instantiating a new Tree object using the height to satisfy the constructor
		// requirement
		Tree currentTree = new Tree(id, name, price, height);
		currentTree.setName(name);
		currentTree.setPrice(price);
		currentTree.setHeight(height);
		return currentTree;
	}

}
