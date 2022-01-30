package com.sprint3.gui;

public class FloristManagerView {

	private Teclado io;

	public FloristManagerView(Teclado io) {
		super();
		this.io = io;
	}
	
    public void displayUnknownCommandBanner() {
        io.print("Unknown command!");
    }

	public int printMenuAndGetSelection() {
		io.print("== FLORIST MANAGER v0.1 ==");
		io.print("1. Add Florist");
		io.print("2. Delete Florist");
		io.print("3. Show Florists");
		io.print("4. Run Florist");
		io.print("0. Exit");
		
		return io.leerInt("Select an option: ", 0, 4);
	}

	public void displayExitBanner() {
        io.print("Thanks for trusting us. Good bye!");
	}
}
