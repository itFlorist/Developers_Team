package com.sprint3.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sprint3.dto.Decoration;
import com.sprint3.dto.Flower;
import com.sprint3.dto.Product;
import com.sprint3.dto.Tree;

public class FloristDaoImpl implements FloristDao {

	/*
	 * private void showFloristValue(List<Product> stock) {} private void
	 * showFloristStock(List<Product> stock) {} private void
	 * showCurrentPurchaseReceipt(List<Product> stock) {} private void
	 * showOldPurchaseReceipts(List<Product> stock) {} private void
	 * totalIncome(List<Product> stock) {}
	 */

	private Map<Integer, Product> stock = new HashMap<>();

	private final String FLORIST_FILE;

	private final String DELIMITER = "::";

	public FloristDaoImpl() {
		FLORIST_FILE = "florist.txt";
	}

	public void addProductType(int id, Product product) throws FloristDaoException {
		loadStock();
		Product newProduct = stock.put(id, product);
		writeStock();
	}

	public Product removeProduct(int id) throws FloristDaoException {
		loadStock();
		Product removedProduct = stock.remove(id);
		writeStock();
		return removedProduct;
	}

	public List<Product> getAllProducts() throws FloristDaoException {
		loadStock();
		return new ArrayList(stock.values());
	}

	// FILE PERSISTENCE
	// Data Marshalling & Unmarshalling
	/**
	 * marshallProduct organises the Product information from an in memory object
	 * into a line of text, so it is in an appropriate format for writing it to
	 * permanent storage.
	 * 
	 * @param aProduct a Product object in memory
	 * @return a String consisting of the format Project
	 *         id::name::price::class::height::color::material
	 */
	private String marshallProduct(Product aProduct) {
		// A Project object needs to be turned into a line of text for the file.
		// E.g, need to turn an in memory object to end up like this:
		// 00001::Orchid::21.95::Flower::NULL::White::NULL

		// the properties are got out of the Project object using getters and these are
		// concatenated with the delimiter as a kind of spacer.

		/*
		 * 
		 * VIGILAR CON LOS NULLS DE LOS ATRIBUTOS NO INCLUIDOS EN LOS OBJETOS
		 * 
		 */

		String productAsText = aProduct.getId() + DELIMITER;
		productAsText += aProduct.getName() + DELIMITER;
		productAsText += aProduct.getPrice() + DELIMITER;
		productAsText += aProduct.getClass().getSimpleName() + DELIMITER;
		productAsText += aProduct.getHeight() + DELIMITER;
		productAsText += aProduct.getFlowerColour() + DELIMITER;
		productAsText += aProduct.getMaterial();
		return productAsText;
	}

	private Product unmarshallProduct(String productAsText) {
		// productAsText is expecting a line read in from our file.
		// E.g., it might look like this:
		// 00001::Orchid::21.95::Flower::NULL::White::NULL
		// iD::name::price::class::height::color::material
		//
		// This line is then split at the DELIMITER (::), leaving an array of Strings,
		// stored as dvdTokens, which should look like this:
		// ___________________________________________
		// | | | | | | | |
		// |00001|Orchid|21.95|Flower|NULL|White|NULL|
		// | | | | | | | |
		// -------------------------------------------
		// [0] [1] [2] [3] [4] [5] [6]

		String[] productTokens = productAsText.split(DELIMITER);
		String idString = productTokens[0];
		String name = productTokens[1];
		String price = productTokens[2];
		String type = productTokens[3];
		String height = productTokens[4];
		String color = productTokens[5];
		String material = productTokens[6];

		// A new Project object is created using the id to satisfy the
		// requirements of the Project constructor
		int id = Integer.parseInt(idString);
		Product productFromFile = null; // = new Product(id);

		switch (type) {
		case "Tree":
			// productFromFile = new Tree(id, name, Float.parseFloat(price),
			// Float.parseFloat(height));
			productFromFile = new Tree(Float.parseFloat(height));
			break;
		case "Flower":
			// productFromFile = new Flower(id, name, Float.parseFloat(price), color);
			productFromFile = new Flower(color);
			break;
		case "Decoration":
			productFromFile = new Decoration(material);
			break;
		}

		// The remaining tokens are then set into the Product object using the
		// appropriate setters.
		productFromFile.setId(id);
		productFromFile.setName(name);
		productFromFile.setPrice(Float.parseFloat(price));

		return productFromFile;
	}

	private void loadStock() throws FloristDaoException {
		Scanner scanner;
		try {
			// Create Scanner for reading the file
			scanner = new Scanner(new BufferedReader(new FileReader(FLORIST_FILE)));
		} catch (FileNotFoundException e) {
			throw new FloristDaoException("-_- Could not load roster data into memory.", e);
		}
		// currentLine holds the most recent line read from the file
		String currentLine;
		// curentDvd holds the most recent DVD unmarshalled
		Product currentProduct;
		// Go through LIBRARY_FILE line by line, decoding each line into a Product
		// object by calling the unmarshallProduct method. Process while we have more
		// more lines in the file
		while (scanner.hasNextLine()) {
			// get the next line in the file
			currentLine = scanner.nextLine();
			// unmarshall the line into a Product
			currentProduct = unmarshallProduct(currentLine);

			// The Product id is used as a map key to put the currentProduct into the map
			stock.put(currentProduct.getId(), currentProduct);
		}
		// Clean up
		scanner.close();
	}

	private void writeStock() throws FloristDaoException {
		// We are translating the IOException to an application specific exception
		// and then simple throwing it i.e. reporting it to the code that called us.

		PrintWriter out;

		try {
			out = new PrintWriter(new FileWriter(FLORIST_FILE));
		} catch (IOException e) {
			throw new FloristDaoException("Could not save Product data", e);
		}
		String productAsText;
		List<Product> productList = this.getAllProducts();
		for (Product currentProduct : productList) {
			// turn a Product into a string
			productAsText = marshallProduct(currentProduct);
			// write the Product object to to the file;
			out.println(productAsText);
			// force PrintWriter to write line to the file
			out.flush();
		}
		// Clean up
		out.close();
	}

	public List<Product> getAllStock() throws FloristDaoException {

		loadStock();
		List<Product> products = getAllProducts();
		return products;
	}
}
