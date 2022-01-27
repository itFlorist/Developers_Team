package com.sprint3.controller;

import java.util.List;

import com.sprint3.dao.ProductDao;
import com.sprint3.dto.Product;
import com.sprint3.gui.ProductView;

public class ProductController {

	private static ProductView productView;
	private ProductDao productDao;
	private static List<Product> stock;

	public ProductController(ProductView productView, ProductDao productDao) {
		this.productView = productView;
		this.productDao = productDao;
	}

	public static void runProduct() {

		boolean keepGoing = true;
		int choice = 0;

		try {
			while (keepGoing) {
				choice = getMenuProduct();

				switch (choice) {
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
					keepGoing = false;
					break;
				default:
					unknownCommand();
				}
			}

		} catch (Exception e) {
			productView.displayErrorMessage(e.getMessage());
		}
	}

	private static void add(List<Product> stock) {

	}

	private static void delete(List<Product> stock) {

	}

	private static void showFloristStock(List<Product> stock) {
		
		//Oliver

	}

	private static void showFloristValue(List<Product> stock) {

	}

	private static void showCurrentPurchaseReceipt(List<Product> stock) {

	}

	private static void showOldPurchaseReceipts(List<Product> stock) {
		
		//Oliver

	}

	private static void totalIncome(List<Product> stock) {

	}

	private static int getMenuProduct() {
		return productView.menuProduct();
	}

	private static void unknownCommand() {
		productView.displayUnknownCommandBanner();
	}
}
