package com.sprint3.controller;

import com.sprint3.dao.FloristDao;
import com.sprint3.dto.Product;
import com.sprint3.dto.Tree;
import com.sprint3.gui.FloristView;

public class FloristController {

	private FloristView floristView;
	private FloristDao floristDao;

	public FloristController(FloristView floristView, FloristDao floristDao) {
		this.floristView = floristView;
		this.floristDao = floristDao;
	}

	public void runProduct() {

		boolean keepGoing = true;
		int choice = 0;

		try {
			while (keepGoing) {
				choice = getMenuProduct();

				switch (choice) {
				case 1:
					add();
					break;
				case 2:
					delete();
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
					showOldPurchaseReceipts();
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

		} catch (Exception e) {
			floristView.displayErrorMessage(e.getMessage());

		}
	}

	private void add() {
		boolean keepGoing = true;
		int menuSelection;
		while (keepGoing) {
			menuSelection = getAddMenuSelection();

			switch (menuSelection) {
			case 1:
				addProduct(new Tree());
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

	private void addProduct(Product product) {
		floristView.displayCreateTreeBanner();
		newTree = floristView.getNewTreeInfo();
		floristDao.addTree(newTree.getId(), newTree);
		floristView.displayCreateSuccessBanner();

	}

	private int getAddMenuSelection() {
		return floristView.printAddMenuAndGetSelection();
	}

	private void delete() {

	}

	private void showFloristStock() {

		// Oliver

	}

	private void showFloristValue() {

	}

	private void showCurrentPurchaseReceipt() {

	}

	private void showOldPurchaseReceipts() {

		// Oliver

	}

	private void totalIncome() {

	}

	private int getMenuProduct() {
		return floristView.menuProduct();
	}

	private void unknownCommand() {
		floristView.displayUnknownCommandBanner();
	}

}
