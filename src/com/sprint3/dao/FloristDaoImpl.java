package com.sprint3.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sprint3.dto.Florist;
import com.sprint3.dto.Product;
import com.sprint3.dto.Tree;

public class FloristDaoImpl implements FloristDao {

	/*
	 * private void add(List<Product> stock) { }
	 * 
	 * private void delete(List<Product> stock) { }
	 * 
	 * private void showFloristValue(List<Product> stock) { }
	 * 
	 * private void showFloristStock(List<Product> stock) { }
	 * 
	 * private void showCurrentPurchaseReceipt(List<Product> stock) { }
	 * 
	 * private void showOldPurchaseReceipts(List<Product> stock) { }
	 * 
	 * private void totalIncome(List<Product> stock) { }
	 */

	private Map<Integer, Product> stock = new HashMap<>();
	private final String FLORIST_FILE;

	public Product addTree(int id, Tree tree) {
		loadFlorist();
		Product newTree = stock.put(id, tree);
		writeFlorist();
		return newTree;
	}

	// FILE PERSISTENCE

	private void loadFlorist() {
		Scanner scanner;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(FLORIST_FILE)));
		} catch (Exception e) {
			System.out.println("File does not exist");
		}
		String currentLine;
		Tree currentTree;
		while (scanner.hasNextLine()) {
			currentLine = scanner.nextLine();
			currentTree = unmarshallTree(currentLine);
			stock.put(currentTree.getId(), currentTree);
		}
		scanner.close();

	}



	@Override
	public List<Product> getAllStock(stock) {
		
		//loadFlorist();
		
		for (Product product : stock) {
			if (product.getType().equals("Tree")) {
				int treeStock = stock.size();
			} else if (product.equals(Flower)) {
				int flowerStock = stock.size();
			} else if (product.equals(Decoration)) {
				int decorationStock = stock.size();
			}
		}
		return null;
	}

}