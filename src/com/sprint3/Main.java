package com.sprint3;

import java.io.File;
import java.io.IOException;

import com.sprint3.controller.FloristController;
import com.sprint3.controller.FloristManagerController;
import com.sprint3.dao.FloristDao;
import com.sprint3.dao.FloristDaoFileImpl;
import com.sprint3.dao.FloristManagerDao;
import com.sprint3.dao.FloristManagerDaoException;
import com.sprint3.dao.FloristManagerDaoFileImpl;
import com.sprint3.gui.FloristManagerView;
import com.sprint3.gui.FloristView;
import com.sprint3.gui.Teclado;

public class Main {
	
	public static void main(String[] args) {

		String filePath = "floristList.txt";
		
		File file = new File(filePath); //initialize File object and passing path as argument  
		boolean result;  
		try{  
			result = file.createNewFile();  //creates a new file  
			if(result) {     // test if successfully created a new file  {  
				System.out.println("File created"); 
			}else{  
				System.out.println("File already exist");  
			}  
		}catch(IOException e){  
		e.printStackTrace();    //prints exception if any  
		}         
	
		Teclado myIo = new Teclado();
		FloristManagerView myView = new FloristManagerView(myIo);
		FloristManagerDao myDao = new FloristManagerDaoFileImpl(filePath);
		FloristManagerController controller = new FloristManagerController(myView, myDao);

		controller.run();
	}

}
