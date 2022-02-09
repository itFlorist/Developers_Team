package com.sprint3.dao;

import java.time.LocalDate;
import java.util.List;

import com.sprint3.dto.Product;
import com.sprint3.dto.Ticket;

public interface FloristDao {

	List<Product> getAllStock() throws FloristDaoException;

	Product removeProduct(int id) throws FloristDaoException;

	public List<Product> getAllProducts() throws FloristDaoException;

	void addProductType(int id, Product product) throws FloristDaoException;

	public float getFloristValue() throws FloristDaoException;

}
