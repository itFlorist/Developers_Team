package com.sprint3.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.sprint3.dto.Product;
import com.sprint3.dto.Tree;

public class ProductDao {

	private Map<Integer, Product> products = new HashMap<>();
	private final String FLORIST_FILE;

	public Product addTree(int id, Tree tree) {
		loadFlorist();
		Product newTree = products.put(id, tree);
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
			products.put(currentTree.getId(), currentTree);
		}
		scanner.close();

	}

}
