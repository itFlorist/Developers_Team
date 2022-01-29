package com.sprint3.dao;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.sprint3.dto.Florist;
import com.sprint3.dto.Product;
import com.sprint3.dto.Tree;

public class FloristDaoImpl {

/*	
  	private void showFloristValue(List<Product> stock) {}
	private void showFloristStock(List<Product> stock) {}
	private void showCurrentPurchaseReceipt(List<Product> stock) {}
	private void showOldPurchaseReceipts(List<Product> stock) {}
	private void totalIncome(List<Product> stock) {}
	*/

	private Map<Integer, Product> stock = new HashMap<>();
	
	private final String FLORIST_FILE;
    private final String DELIMITER = "::";
	
    
    public FloristDaoImpl() {
    	FLORIST_FILE = "DvdLibrary.txt";
    }

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
	
    public Product removeProduct(int id) {
        loadStock();
        Product removedProduct = products.remove(id);
        writeStock();
        return removedProduct;
    }

    
    private Product unmarshallProduct(String productAsText) {
        //productAsText is expecting a line read in from our file.
        //E.g., it might look like this:
        //00001::Orchid::21.95::Flower::NULL::White::NULL
    	// iD::name::price::class::height::color::material
        //
        //This line is then split at the DELIMITER (::), leaving an array of Strings,
        //stored as dvdTokens, which should look like this:
        //___________________________________________
        //|     |      |     |      |    |     |    |
        //|00001|Orchid|21.95|Flower|NULL|White|NULL|
        //|     |      |     |      |    |     |    |
        //-------------------------------------------
        //  [0]   [1]    [2]   [3]   [4]   [5]   [6]
        
        String [] productTokens = productAsText.split(DELIMITER);
        //Given the pattern above, the DVD title is in index 0 of the array.
        String idString = productTokens[0];
        String name = productTokens[1];
        String price = productTokens[2];
        String type = productTokens[3];
        String height = productTokens[4];
        String color = productTokens[5];
        String material = productTokens[6];
        
        //A new Project object is created using the id to satisfy the 
        //requirements of the Project constructor
        int id = Integer.parseInt(idString);
        Product productFromFile = new Product(id);
        //The remaining tokens are then set into the DVD object using the appropriate setters.
        productFromFile.setName(name);
        productFromFile.setPrice(Float.parseFloat(price));
        productFromFile.setType(type);
        productFromFile.setHeight(height);
        productFromFile.setColor(color);
        productFromFile.setMaterial(material);
        
        return productFromFile;
    }
    
    
	private void loadStock() {
		Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(FLORIST_FILE)));
        } catch (FileNotFoundException e) {
            throw new FloristDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        //currentLine holds the most recent line read from the file
        String currentLine;
        //curentDvd holds the most recent DVD unmarshalled
        Florist currentFlorist;
        //Go through LIBRARY_FILE line by line, decoding each line into a DVD
        //object by calling the unmarshallDvd method. Process while we have more
        //more lines in the file
        while (scanner.hasNextLine()) {
            //get the next line in the file
            currentLine = scanner.nextLine();
            //unmarshall the line into a DVD
            currentFlorist = unmarshallDvd(currentLine);
            
            //The Dvd title is used as a map key to put the currentDvd ino the map
            dvds.put(currentDvd.getTitle(),currentDvd);
        }
        //Clean up
        scanner.close();
	}

}
