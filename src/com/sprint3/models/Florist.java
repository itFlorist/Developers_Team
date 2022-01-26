package com.sprint3.models;

import java.util.List;
import java.util.Scanner;

public class Florist {

	private String name;
	private List<Product> stock;
	private float totalValue;

	public Florist() {
		
	}
	public Florist(String name, List<Product> stock, float totalValue) {
		super();
		this.name = name;
		this.stock = stock;
		this.totalValue = totalValue;
	}

	public void runFlorist() {

		boolean exit = false;

		do {
			switch (menu()) {
			case 1:
				add(stock);
				break;
			case 2:
				delete(stock);
				break;
			case 3:
				showFloristStock(stock);
				break;
			case 4:
				showFloristValue(stock);
				break;
			case 5:
				showCurrentPurchaseReceipt(stock);
				break;
			case 6:
				showOldPurchaseReceipts(stock);
				break;
			case 7:
				totalIncome(stock);
				break;
			case 0:
				System.out.println("Bye bye");
				exit = true;
				break;
			}
		} while (!exit);
	}

	public static byte menu() {
		Scanner sc = new Scanner(System.in);
		byte choice;
		final byte MIN = 0;
		final byte MAX = 7;

		do {
			System.out.println("\nMAIN MENU");
			System.out.println("1. Add Product.");
			System.out.println("2. Delete Product.");
			System.out.println("3. Show Florist´s stock.");
			System.out.println("4. Show Florist´s value.");
			System.out.println("5. Get current purchase receipt.");
			System.out.println("6. Get old purchase receipts.");
			System.out.println("7. Display total income.");
			System.out.println("0. Exit.\n");
			choice = sc.nextByte();
			if (choice < MIN || choice > MAX) {
				System.out.println("Invalid choice");
			}
		} while (choice < MIN || choice > MAX);
		return choice;
	}

	private void add(List<Product> stock) {

	}

	private void delete(List<Product> stock) {

	}

	private void showFloristValue(List<Product> stock) {

	}

	private void showFloristStock(List<Product> stock) {

	}

	private void showCurrentPurchaseReceipt(List<Product> stock) {

	}

	private void showOldPurchaseReceipts(List<Product> stock) {

	}

	private void totalIncome(List<Product> stock) {

	}

	@Override
	public String toString() {
		return "Florist [name=" + name + ", stock=" + stock + ", totalValue=" + totalValue + "]";
	}

}
