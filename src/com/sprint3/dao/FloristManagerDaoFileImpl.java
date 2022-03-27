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

import com.sprint3.dto.Florist;

public class FloristManagerDaoFileImpl implements FloristManagerDao {

	private Map<String, Florist> floristArchive = new HashMap<>();

	private final String FLORIST_ARCHIVE_FILE;

	private final String DELIMITER = "::";

	public FloristManagerDaoFileImpl(String file) {
		FLORIST_ARCHIVE_FILE = file;
	}

	public void addFlorist(String name, Florist florist) throws FloristManagerDaoException {
		loadFlorist();
		floristArchive.put(name, florist);
		writeFlorist();
	}

	public Florist removeFlorist(String floristName) throws FloristManagerDaoException {
		loadFlorist();
		Florist removedFlorist = floristArchive.remove(floristName);
		writeFlorist();
		return removedFlorist;
	}

	// ------------------------------------------------------------------------------
	public int getProductId(String floristName) throws FloristManagerDaoException {
		loadFlorist();
		int id;

		Florist fl = floristArchive.get(floristName);
		id = fl.getIdProduct();
		fl.setIdProduct(id + 1);
		writeFlorist();

		return id;
	}
	// ------------------------------------------------------------------------------

//	public boolean checkName(String floristName) throws FloristManagerDaoException{
//		List<Florist> florists = getAllFlorists(); 
//		
//		for(Florist florist : florists) {
//			if(floristName.equals(florist.getName())) {
//				return true;
//			}
//		}
//		return false;
//	}

	public List<Florist> getAllFlorists() throws FloristManagerDaoException {
		loadFlorist();
		return new ArrayList<Florist>(floristArchive.values());
	}

	// FILE PERSISTENCE
	// Data Marshalling & Unmarshalling
	/**
	 * marshallProduct organises the Florist information from an in memory object
	 * into a line of text, so it is in an appropriate format for writing it to
	 * permanent storage.
	 * 
	 * @param aProduct a Florist object in memory
	 * @return a String consisting of the format Project name::idProduct::idTicket
	 */
	private String marshallFlorist(Florist aFlorist) {
		// A Project object needs to be turned into a line of text for the file.
		// E.g, need to turn an in memory object to end up like this:
		// Navarro::1::3

		// the properties are got out of the Project object using getters and these are
		// concatenated with the delimiter as a kind of spacer.

		String floristAsText = aFlorist.getName() + DELIMITER;
		floristAsText += aFlorist.getIdProduct() + DELIMITER;
		floristAsText += aFlorist.getIdTicket();
		return floristAsText;
	}

	private Florist unmarshallFlorist(String floristAsText) {
		// floristAsText is expecting a line read in from our file.
		// E.g., it might look like this:
		// Navarro::1::3
		// name::idProduct::idTicket
		//
		// This line is then split at the DELIMITER (::), leaving an array of Strings,
		// stored as floristTokens, which should look like this:
		// ______________________
		// | | | |
		// |Navarro| 1 | 3 |
		// | | | |
		// ----------------------
		// [0] [1] [2]

		String[] floristTokens = floristAsText.split(DELIMITER);
		String name = floristTokens[0];
		String idProductString = floristTokens[1];
		String idTicketString = floristTokens[2];

		// A new Project object is created using the id to satisfy the
		// requirements of the Project constructor

		// int idFlorist = Integer.parseInt(idFloristString);???

		int idProduct = Integer.parseInt(idProductString);
		int idTicket = Integer.parseInt(idTicketString);
		Florist floristFromFile = new Florist(name, idProduct, idTicket);

		// The remaining tokens are then set into the Product object using the
		// appropriate setters.
		floristFromFile.setName(name);
		floristFromFile.setIdProduct(idProduct);
		floristFromFile.setIdTicket(idTicket);

		return floristFromFile;
	}

	private void loadFlorist() throws FloristManagerDaoException {
		Scanner scanner;
		try {
			// Create Scanner for reading the file
			scanner = new Scanner(new BufferedReader(new FileReader(FLORIST_ARCHIVE_FILE)));
		} catch (FileNotFoundException e) {
			throw new FloristManagerDaoException("-_- Could not load roster data into memory.", e);
		}
		// currentLine holds the most recent line read from the file
		String currentLine;
		// curentFlorist holds the most recent Florist unmarshalled
		Florist currentFlorist;
		// Go through FLORIST_ARCHIVE_FILE line by line, decoding each line into a
		// Florist
		// object by calling the unmarshallFlorist method. Process while we have more
		// more lines in the file
		while (scanner.hasNextLine()) {
			// get the next line in the file
			currentLine = scanner.nextLine();
			// unmarshall the line into a Florist
			currentFlorist = unmarshallFlorist(currentLine);

			// The Florist id is used as a map key to put the currentProduct into the map
			floristArchive.put(currentFlorist.getName(), currentFlorist);
		}
		// Clean up
		scanner.close();
	}

	private void writeFlorist() throws FloristManagerDaoException {
		// We are translating the IOException to an application specific exception
		// and then simple throwing it i.e. reporting it to the code that called us.

		PrintWriter out;

		try {
			out = new PrintWriter(new FileWriter(FLORIST_ARCHIVE_FILE));
		} catch (IOException e) {
			throw new FloristManagerDaoException("Could not save Product data", e);
		}
		String floristAsText;
		List<Florist> productList = this.getAllFlorists();
		for (Florist currentFlorist : productList) {
			// turn a Florist into a string
			floristAsText = marshallFlorist(currentFlorist);
			// write the Florist object to to the file;
			out.println(floristAsText);
			// force PrintWriter to write line to the file
			out.flush();
		}
		// Clean up
		out.close();
	}

}
