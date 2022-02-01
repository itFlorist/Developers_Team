package com.sprint3;

import com.sprint3.controller.FloristController;
import com.sprint3.controller.FloristManagerController;
import com.sprint3.dao.FloristDao;
import com.sprint3.dao.FloristDaoImpl;
import com.sprint3.dao.FloristManagerDao;
import com.sprint3.dao.FloristManagerDaoImpl;
import com.sprint3.gui.FloristManagerView;
import com.sprint3.gui.FloristView;
import com.sprint3.gui.Teclado;

public class Main {

	public static void main(String[] args) {

		Teclado myIo = new Teclado();
		FloristManagerView myView = new FloristManagerView(myIo);
		FloristManagerDao myDao = new FloristManagerDaoImpl();
		FloristManagerController controller = new FloristManagerController(myView, myDao);

		FloristView fView = new FloristView(myIo);
		FloristDao fDao = new FloristDaoImpl();
		FloristController fController = new FloristController(fView, fDao);

		controller.run();
		fController.runProduct();

	}

}
