package com.sprint3.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.sprint3.dao.FloristManagerDaoException;
import com.sprint3.dao.TicketDao;
import com.sprint3.dao.TicketDaoFileImpl;
import com.sprint3.dto.Florist;
import com.sprint3.gui.FloristManagerView;
import com.sprint3.gui.FloristView;
import com.sprint3.gui.TicketView;
import com.sprint3.service.FloristManagerService;
import com.sprint3.service.FloristManagerServiceException;
import com.sprint3.service.FloristService;
import com.sprint3.service.TicketService;

public class FloristManagerController {

	private FloristManagerView floristManagerView;
	private FloristManagerService floristManagerService;

	public FloristManagerController(FloristManagerView floristManagerView,
			FloristManagerService floristManagerService) {
		this.floristManagerView = floristManagerView;
		this.floristManagerService = floristManagerService;
	}

	public void run() {

		boolean keepGoing = true;
		int menuSelection = -1;

		try {

			do {
				switch (getMenuSelection()) {
				case 1:
					addFlorist();
					break;
				case 2:
					removeFlorist();
					break;
				case 3:
					showFlorists();
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

	private void addFlorist() throws FloristManagerServiceException, FloristManagerDaoException {
		floristManagerView.displayCreateFlorist();
		String floristName = floristManagerView.getFloristName();
		boolean existsName = floristManagerService.checkName(floristName);

		if (existsName) {
			floristManagerView.displayFloristNameNotUnique();
		} else {
			Florist newFlorist = new Florist(floristName, 0, 0);
			floristManagerService.addFlorist(floristName, newFlorist);
			floristManagerView.displayCreateSuccessBanner(floristName);
		}
	}

	private void removeFlorist() throws FloristManagerServiceException, FloristManagerDaoException {
		floristManagerView.displayRemoveFloristBanner();
		String floristName = floristManagerView.getFloristName();
		Florist removedFlorist = floristManagerService.removeFlorist(floristName);
		floristManagerView.displayRemoveResult(removedFlorist);
	}

	private void showFlorists() throws FloristManagerServiceException, FloristManagerDaoException {
		floristManagerView.displayGetFlorist();
		System.out.println(floristManagerService.getAllFlorists());
	}

	private int getMenuSelection() throws FloristManagerServiceException, FloristManagerDaoException {
		List<Florist> list = floristManagerService.getAllFlorists();
		if (list.isEmpty()) {
			return floristManagerView.printMenuAndGetSelectionPartial();
		} else {
			return floristManagerView.printMenuAndGetSelectionComplete();
		}
	}

	private void runFlorist() throws FloristManagerServiceException, FloristManagerDaoException {
		String floristName = floristManagerView.getFloristName();
		boolean existsName = floristManagerService.checkName(floristName);

		if (existsName) {
			floristName += "_Florist.txt";

			File file = new File(floristName);
			boolean result;
			try {
				result = file.createNewFile();
				if (result) {
					System.out.println("file created");
				} else {
					System.out.println("File already exist");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			return;
		}

		FloristView floristView = new FloristView(floristManagerView.getIo());
		// FloristDao floristDao = new FloristDaoFileImpl(floristName);
		FloristService floristService = new FloristService(floristName);
		TicketView ticketView = new TicketView(floristManagerView.getIo());
		TicketDao ticketDao = new TicketDaoFileImpl();
		TicketService ticketService = new TicketService(ticketDao);
		TicketController ticketController = new TicketController(ticketView, ticketService);

		FloristController floristController = new FloristController(floristView, floristService, ticketController);
		floristController.runProduct();
	}

	private void unknownCommand() {
		floristManagerView.displayUnknownCommandBanner();
	}

	private void exitMessage() {
		floristManagerView.displayExitBanner();
	}
}
