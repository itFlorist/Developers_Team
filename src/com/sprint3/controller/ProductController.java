package com.sprint3.controller;

import com.sprint3.dao.ProductDao;
import com.sprint3.gui.ProductView;

public class ProductController {

	private ProductView productView;
	private ProductDao productDao;

	public ProductController(ProductView productView, ProductDao productDao) {
		this.productView = productView;
		this.productDao = productDao;
	}

	public static void run() {

	}
}
