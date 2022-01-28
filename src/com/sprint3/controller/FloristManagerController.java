package com.sprint3.controller;

import com.sprint3.dao.FloristManagerDao;
import com.sprint3.gui.FloristManagerView;

public class FloristManagerController {
	
	private FloristManagerView floristManagerView;
	private FloristManagerDao floristManagerDao;

	public FloristManagerController(FloristManagerView floristManagerView, FloristManagerDao floristManagerDao) {
		this.floristManagerView = floristManagerView;
		this.floristManagerDao = floristManagerDao;
	}
	
	public void run() {
		
		boolean keepGoing = true;
		
		
		//implementar que sólo te muestre la opción "add" si no hay floristerias 
		
		do {
			switch (getMenuSelection()) {
				case 1:
					//add
					break;
				case 2:
					//remove
					break;
				case 3:
					//show
					break;
				case 4:
					//run
					break;
				default:
					unknownCommand();		
			}
		}while(keepGoing);
		
		exitMessage();
		
		
	}//end run
	

	private int getMenuSelection() {        
    	return floristManagerView.printMenuAndGetSelection();
	}

	private void unknownCommand() {
    	floristManagerView.displayUnknownCommandBanner();
    }
	
    private void exitMessage() {
    	floristManagerView.displayExitBanner();
	}
}
