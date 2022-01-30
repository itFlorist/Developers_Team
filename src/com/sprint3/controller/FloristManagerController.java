package com.sprint3.controller;

import com.sprint3.dao.FloristDao;
import com.sprint3.dao.FloristDaoImpl;
import com.sprint3.dao.FloristManagerDao;
import com.sprint3.dao.FloristManagerDaoImpl;
import com.sprint3.gui.FloristManagerView;
import com.sprint3.gui.FloristView;
import com.sprint3.gui.Teclado;

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
					System.out.println("ADD method under construction");
					break;
				case 2:
					//remove
					System.out.println("REMOVE method under construction");
					break;
				case 3:
					//show
					System.out.println("SHOW method under construction");
					break;
				case 4:
//					Teclado io = new Teclado();
//			        FloristView floristView = new FloristView(io);
//			        FloristDao floristDao = new FloristDaoImpl();
//			        FloristController floristController = new FloristController(floristView, floristDao);
					FloristController fc = new FloristController(new FloristView(new Teclado()), new FloristDaoImpl());
					fc.runProduct();
					break;
				case 0:
					keepGoing = false;
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
