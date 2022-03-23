package com.sprint3.gui;

import com.sprint3.dto.Florist;

public class FloristManagerView {

	private Teclado io;

	public FloristManagerView(Teclado io) {
		super();
		this.io = io;
	}

	public Teclado getIo() {
		return io;
	}

	public void setIo(Teclado io) {
		this.io = io;
	}

	public String getFloristName() {
		String floristName = io.leerString("Write the Florist's name: ");
		return floristName.toUpperCase();
	}

	public int printMenuAndGetSelectionPartial() {
		io.print("\n== FLORIST MANAGER v0.1 ==");
		io.print("1. Add Florist");
		io.print("0. Exit.\n");

		return io.leerInt("Select an option: ", 0, 1);
	}

	public int printMenuAndGetSelectionComplete() {
		io.print("\n== FLORIST MANAGER v0.1 ==");
		io.print("1. Add Florist");
		io.print("2. Delete Florist");
		io.print("3. Show Florists");
		io.print("4. Run Florist");
		io.print("0. Exit.\n");

		return io.leerInt("Select an option: ", 0, 4);
	}

	public void displayCreateFlorist() {
		io.print("=== CREATE FLORIST ===");
	}

	public void displayCreateSuccessBanner(String florist) {
		io.print(florist + " successfully created. ");
	}

	public void displayFloristNameNotUnique() {
		io.print("This Florist already exists. Select another name or delete the Florist you choose.");
	}

	public void displayRemoveFloristBanner() {
		io.print("=== DELETE FLORIST ===");
	}

	public void displayRemoveResult(Florist removedFlorist) {
		if (removedFlorist != null) {
			io.print("Florist " + removedFlorist.getName() + " successfully removed.");
		} else {
			io.print("No such Florist.");
		}
		io.leerString("Please hit enter to continue.");
	}

	public void displayGetFlorist() {
		io.print("=== FLORIST LIST ===");
	}

	public void displayUnknownCommandBanner() {
		io.print("Unknown command!");
	}

	public void displayExitBanner() {
		io.print("Thanks for trusting us. Good bye!");
	}

	public void displayErrorMessage(String message) {
		io.print("=== ERROR ===");
		io.print(message);
	}

}
