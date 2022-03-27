package com.sprint3.service;

import java.util.List;

import com.sprint3.dao.FloristDao;
import com.sprint3.dao.FloristDaoException;
import com.sprint3.dto.Product;

public class FloristService {

	private FloristDao floristDao;

	public FloristService(FloristDao floristDao) {
		this.floristDao = floristDao;
	}

	public void addProductType(int id, Product newProduct) throws FloristDaoException {
		floristDao.addProductType(newProduct.getId(), newProduct);

	}

	public Product removeProduct(int id) throws FloristDaoException {
		return floristDao.removeProduct(id);
	}

	public List<Product> getAllStock() throws FloristDaoException {
		return floristDao.getAllStock();
	}

	public float getFloristValue() throws FloristDaoException {
		return floristDao.getFloristValue();
	}

	public Product getProduct(int id) throws FloristDaoException {
		return floristDao.getProduct(id);
	}

}
