package com.sprint3.controller;

import java.util.List;

import com.sprint3.dao.FloristDao;

import com.sprint3.dto.Tree;

import com.sprint3.dto.Florist;

import com.sprint3.gui.FloristView;

public class FloristController {

	private static FloristView floristView;
	private FloristDao floristDao;
	private static List<Product> stock;

	public FloristController(FloristView floristView, FloristDao floristDao) {
		this.floristView = floristView;
		this.floristDao = floristDao;
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

	private static void add() {

	}

	private static void delete() {

	}

	private static void showFloristStock() {
		
		//Oliver

	}

	private static void showFloristValue() {

	}

	private static void showCurrentPurchaseReceipt() {

	}

	private static void showOldPurchaseReceipts() {
		
		//Oliver

	}

	private static void totalIncome() {

	}

	private static int getMenuProduct() {
		return floristView.menuProduct();
	}

	private static void unknownCommand() {
		floristView.displayUnknownCommandBanner();
	}

	private void addProduct() {
		boolean keepGoing = true;
		int menuSelection;
		while (keepGoing) {
			menuSelection = getAddMenuSelection();

			switch (menuSelection) {
			case 1:
				addTree();
				break;
			case 2:
				// addFlower();
				break;
			case 3:
				// addDecoration();
				break;
			case 0:
				// back to principal menu
				break;
			default:
				unknownCommand();
			}
		}
		// exitMessage();

	}

	private void addTree() {
		floristView.displayCreateTreeBanner();
		Tree newTree = floristView.getNewTreeInfo();
		floristDao.addTree(newTree.getId(), newTree);
		floristView.displayCreateSuccessBanner();

	}

	private int getAddMenuSelection() {
		return floristView.printAddMenuAndGetSelection();
	}

	private void unknownCommand() {
		floristView.displayUnknownCommandBanner();
	}
}
