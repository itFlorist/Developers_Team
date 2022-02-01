package com.sprint3;

import com.sprint3.controller.FloristManagerController;
import com.sprint3.dao.FloristManagerDao;
import com.sprint3.dao.FloristManagerDaoImpl;
import com.sprint3.gui.FloristManagerView;
import com.sprint3.gui.Teclado;

public class Main {

	public static void main(String[] args) {
		
        Teclado myIo = new Teclado();
        FloristManagerView myView = new FloristManagerView(myIo);
        FloristManagerDao myDao = new FloristManagerDaoImpl();
        FloristManagerController controller = new FloristManagerController(myView, myDao);

        controller.run();        

	}

}
