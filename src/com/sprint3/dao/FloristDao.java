package com.sprint3.dao;

import java.util.List;

import com.sprint3.dto.Product;

public interface FloristDao {

	Product removeProduct(int id) throws FloristDaoException;
	
	public List<Product> getAllProducts() throws FloristDaoException;


}
