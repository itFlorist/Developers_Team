package com.sprint3.controller;

import com.sprint3.dao.ProductDao;
import com.sprint3.dto.Tree;
import com.sprint3.gui.ProductView;

public class ProductController {

	private ProductView productView;
	private ProductDao productDao;

	public ProductController(ProductView productView, ProductDao productDao) {
		this.productView = productView;
		this.productDao = productDao;
	}

	public static void run() {

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
		productView.displayCreateTreeBanner();
		Tree newTree = productView.getNewTreeInfo();
		productDao.addTree(newTree.getId(), newTree);
		productView.displayCreateSuccessBanner();

	}

	private int getAddMenuSelection() {
		return productView.printAddMenuAndGetSelection();
	}

	private void unknownCommand() {
		productView.displayUnknownCommandBanner();
	}
}
