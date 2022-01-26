package com.sprint3.service;

import java.io.*;
import java.util.*;

public class FloristService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int id;
	private int floristId;
	private String floristName;
	private ArrayList<FloristService> floristerias;

	public FloristService() {
		super();
		this.floristId = FloristService.id++;
//		this.floristName = floristName;
		this.floristerias = new ArrayList<FloristService>();
	}

	public FloristService(int floristId, String floristName) {
		super();
		this.floristId = FloristService.id++;
		this.floristName = floristName;
		this.floristerias = new ArrayList<FloristService>();
	}

	public int getFloristId() {
		return floristId;
	}

	public void setFloristId(int floristId) {
		this.floristId = floristId;
	}

	public String getFloristName() {
		return floristName;
	}

	public void setFloristName(String floristName) {
		this.floristName = floristName;
	}

	public ArrayList<FloristService> getFloristerias() {
		return floristerias;
	}

	public void setFloristerias(ArrayList<FloristService> floristerias) {
		this.floristerias = floristerias;
	}

	public void runFloristService() throws Exception {

		boolean exit = false;

		do {
			switch (menu()) {
			case 1:
				addFlorist(floristerias);
				break;
			case 2:
				deleteFlorist(floristerias);
				break;
			case 3:
				showFlorist(floristerias);
				break;
			case 4:
				goToFlorist(floristerias);
				break;
			case 0:
				System.out.println("Bye bye");
				exit = true;
				break;
			}
		} while (!exit);
	}

	public static byte menu() {
		Scanner sc = new Scanner(System.in);
		byte choice;
		final byte MIN = 0;
		final byte MAX = 4;

		do {
			System.out.println("\nMAIN MENU");
			System.out.println("1. Add Florist.");
			System.out.println("2. Delete Florist.");
			System.out.println("3. Show Florist.");
			System.out.println("4. Manage your Florist´s shop."); // redirigir a Florist
			System.out.println("0. Exit.\n");
			choice = sc.nextByte();
			if (choice < MIN || choice > MAX) {
				System.out.println("Invalid choice");
			}
		} while (choice < MIN || choice > MAX);
		return choice;
	}

	public static void addFlorist(ArrayList<FloristService> floristerias) throws Exception {

		Scanner sc = new Scanner(System.in);
		String floristName = null;
		int floristId = 0;
		int position = 0;
		floristerias = ois(floristerias);

		System.out.println("Type the name of the florist to be added");
		floristName = sc.nextLine().toUpperCase();

		position = searchFlorist(floristerias, floristName);

		if (position == -1) {
			FloristService florist = new FloristService(floristId, floristName);
			floristerias.add(florist);
			oos(floristerias);
			System.out.println("Florist " + floristName + " added to application");
			System.out.println(florist.toString());
		} else {
			System.out.println("There is already a flower shop called " + floristName + " in the application");
		}
	}

	public static void deleteFlorist(ArrayList<FloristService> floristerias) throws Exception {

		Scanner sc = new Scanner(System.in);
		String floristName;
		boolean found = false;
		floristerias = ois(floristerias);
		ListIterator it = floristerias.listIterator();

		if (floristerias.isEmpty()) {
			System.out.println("There is no Florist´s shop in app to be deleted");
		} else {

			System.out.println("Type the name of the florist to be deleted");
			floristName = sc.nextLine().toUpperCase();

			while (it.hasNext()) {
				FloristService florist = (FloristService) it.next();
				if (floristName.equalsIgnoreCase(florist.getFloristName())) {
					it.remove();
					oos(floristerias);
					System.out.println("Florist " + floristName + " deleted from application");
					found = true;
				}
			}
			if (!found) {
				System.out.println("The Florist " + floristName + " does not exist in the application.");
			}
		}
	}

	public static void showFlorist(ArrayList<FloristService> floristerias) throws Exception {

		floristerias = ois(floristerias);

		if (floristerias.isEmpty()) {
			System.out.println("There is no Florists in the application");
		} else {
			for (FloristService florist : floristerias) {
				System.out.println(florist);
			}
		}
	}

	public static void goToFlorist(ArrayList<FloristService> floristerias) {

		Scanner sc = new Scanner(System.in);
		String floristName;
		System.out.println("Type the name of the florist to be managed");
		floristName = sc.nextLine();
		
		for (FloristService florist : floristerias) {
			if (floristName.equalsIgnoreCase(florist.getFloristName())) {
			 //florist.runFlorist(); // (redirigir a Florist)
			}
		}
	}

	public static void oos(ArrayList<FloristService> floristerias) throws Exception {
		File file = new File("florist.txt");
		ObjectOutputStream oos = null;

		oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(floristerias);
		oos.close();
	}

	public static ArrayList<FloristService> ois(ArrayList<FloristService> floristerias) throws Exception {
		File file = new File("florist.txt");
		ObjectInputStream ois = null;

		if (file.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			floristerias = (ArrayList<FloristService>) ois.readObject();
			ois.close();
		}
		return floristerias;
	}

	public static int searchFlorist(ArrayList<FloristService> floristerias, String floristName) {

		Scanner sc = new Scanner(System.in);
		int position = -1;
		int i = 0;
		boolean found = false;

		while (i < floristerias.size() && !found) {
			if (floristerias.get(i).getFloristName().equalsIgnoreCase(floristName)) {
				position = floristerias.indexOf(floristerias.get(i));
				found = true;
			}
			i++;
		}
		return position;
	}

	@Override
	public String toString() {
		return "Florist [floristId=" + floristId + ", floristName=" + floristName + "]";
	}
}
