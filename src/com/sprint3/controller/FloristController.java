package com.sprint3.controller;

import java.util.List;
import com.sprint3.dao.FloristDao;
import com.sprint3.dto.Tree;
import com.sprint3.dto.Florist;
import com.sprint3.dto.Product;
import com.sprint3.gui.FloristView;
import com.sprint3.dao.FloristDaoException;

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
					addProduct();
					break;
				case 2:
					removeProduct();
					break;
				case 3:
					//showFloristStock();
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
					//unknownCommand();
				}
			}
			exitMessage();

		} catch (Exception e) {
			floristView.displayErrorMessage(e.getMessage());
		}
	}

//	private void addProduct() {
//		boolean keepGoing = true;
//		int menuSelection;
//		while (keepGoing) {
//			menuSelection = getAddMenuSelection();
//
//			switch (menuSelection) {
//			case 1:
//				addTree();
//				break;
//			case 2:
//				// addFlower();
//				break;
//			case 3:
//				// addDecoration();
//				break;
//			case 0:
//				// back to principal menu
//				break;
//			default:
//				unknownCommand();
//			}
//		}
		// exitMessage();
//	}
	
//	private void addTree() {
//		floristView.displayCreateTreeBanner();
//		Tree newTree = floristView.getNewTreeInfo();
//		floristDao.addTree(newTree.getId(), newTree);
//		floristView.displayCreateSuccessBanner();
//	}
	
	private void addProduct() throws FloristDaoException {
		System.out.println("Create Product");
		Product newProduct = floristView.getNewProductInfo();
		floristDao.addProduct(newProduct.getId(),newProduct);
		System.out.println("Process completed succesfully!");
	}
	
	private void removeProduct() throws FloristDaoException{
		floristView.displayRemoveProductBanner();
        int id = floristView.getProductIdChoice();
        Product removedProduct = floristDao.removeProduct(id);
        System.out.println(removedProduct);
        floristView.displayRemoveResult(removedProduct);
	}

//	private void showFloristStock() { // Oliver
//
//		floristView.displayStockBanner();
//		List<Product> stock = floristDao.getAllStock();
//		floristView.displayFloristStock(stock);
//
//	}
  
	private void showFloristValue() {

	}

	private void showCurrentPurchaseReceipt() {

	}

	private void showOldPurchaseReceipts() {
		
		//Oliver

	}

	private void totalIncome() {

	}

	private int getMenuProduct() {
		return floristView.menuProduct();
	}

	private void exitMessage() {
		floristView.displayExitBanner();
		
	}


//	private int getAddMenuSelection() {
//		return floristView.printAddMenuAndGetSelection();
//	}

}
