package com.sprint3;

import com.sprint3.models.Florist;
import com.sprint3.service.FloristService;

public class Main {

	public static void main(String[] args) throws Exception {
		
		FloristService floristService = new FloristService();
		floristService.runFloristService();
		
//		Florist florist = new Florist();
//		florist.runFlorist();
		
	}

}
