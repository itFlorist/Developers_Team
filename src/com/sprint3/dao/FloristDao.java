package com.sprint3.dao;

import java.util.List;
import com.sprint3.dto.Florist;
import com.sprint3.dto.Product;

public interface FloristDao {

	List<Product> getAllStock();
	
	
}
