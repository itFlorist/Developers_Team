package com.sprint3.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.sprint3.dao.FloristManagerDaoException;
import com.sprint3.dao.FloristDao;
import com.sprint3.dao.FloristDaoImpl;
import com.sprint3.dao.FloristManagerDao;
import com.sprint3.dao.FloristManagerDaoImpl;
import com.sprint3.dao.TicketDao;
import com.sprint3.dao.TicketDaoImpl;
import com.sprint3.dto.Florist;
import com.sprint3.gui.FloristManagerView;
import com.sprint3.gui.FloristView;
import com.sprint3.gui.TicketView;

public class FloristManagerController {

	private FloristManagerView floristManagerView;
	private FloristManagerDao floristManagerDao;

	public FloristManagerController(FloristManagerView floristManagerView, FloristManagerDao floristManagerDao) {
		this.floristManagerView = floristManagerView;
		this.floristManagerDao = floristManagerDao;
	}

	public void run() {

		boolean keepGoing = true;
		int menuSelection = -1;

		// implementar que sólo te muestre la opción "add" si no hay floristerias
		try {

			do {
				switch (getMenuSelection()) {
				case 1:
					addFlorist();
					// System.out.println("ADD method under construction");
					break;
				case 2:
					removeFlorist();
					// System.out.println("REMOVE method under construction");
					break;
				case 3:
					showFlorists();
					// mejorar el formato de impresion
					System.out.println("SHOW method under construction");
					break;
				case 4:
					runFlorist();
					break;
				case 0:
					keepGoing = false;
					break;
				default:
					unknownCommand();
				}
			} while (keepGoing);

			exitMessage();

		} catch (Exception e) {
			floristManagerView.displayErrorMessage(e.getMessage());
		}

	}// end run

	private void removeFlorist() throws FloristManagerDaoException {
		floristManagerView.displayRemoveFloristBanner();
		String floristName = floristManagerView.getFloristName();
		Florist removedFlorist = floristManagerDao.removeFlorist(floristName);
		// System.out.println(removedFlorist);
		floristManagerView.displayRemoveResult(removedFlorist);
	}

	private void addFlorist() throws FloristManagerDaoException {
		floristManagerView.displayCreateFlorist();
		String floristName = floristManagerView.getFloristName();
		boolean existsName = floristManagerDao.checkName(floristName);
//		System.out.println(floristName);
//		System.out.println(existsName);

		if (existsName) {
			floristManagerView.displayFloristNameNotUnique();
		} else {
			Florist newFlorist = new Florist(floristName, 0, 0);
			floristManagerDao.addFlorist(floristName, newFlorist);
			floristManagerView.displayCreateSuccessBanner(floristName);
		}
	}

	private void showFlorists() throws FloristManagerDaoException {
		floristManagerView.displayGetFlorist();
		System.out.println(floristManagerDao.getAllFlorists());
	}

	private int getMenuSelection() throws FloristManagerDaoException {
		List<Florist> list = floristManagerDao.getAllFlorists();
		if (list.isEmpty()) {
			return floristManagerView.printMenuAndGetSelectionPartial();
		} else {
			return floristManagerView.printMenuAndGetSelectionComplete();
		}
	}

	private void runFlorist() throws FloristManagerDaoException {
		String floristName = floristManagerView.getFloristName();
		boolean existsName = floristManagerDao.checkName(floristName);

		if(existsName) {
			floristName += "_Florist.txt";
			
			File file = new File(floristName);  
			boolean result;  
			try{  
				result = file.createNewFile();
				if (result) {
					System.out.println("file created " + file.getCanonicalPath());
				} else {
					System.out.println("File already exist at location: " + file.getCanonicalPath());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			return;
		}

		FloristView floristView = new FloristView(floristManagerView.getIo());
		FloristDao floristDao = new FloristDaoImpl(floristName);
		TicketView ticketView = new TicketView(floristManagerView.getIo());
		TicketDao ticketDao = new TicketDaoImpl();
		FloristController floristController = new FloristController(floristView, ticketView, floristDao, ticketDao, null);
//		FloristController fc = new FloristController(new FloristView(new Teclado()), new FloristDaoImpl());
		floristController.runProduct();
	}

	private void unknownCommand() {
		floristManagerView.displayUnknownCommandBanner();
	}

	private void exitMessage() {
		floristManagerView.displayExitBanner();
	}
}
