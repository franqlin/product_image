/*
 * This work is free software; you can redistribute it and/or
 * modify it under the terms of the Apache License as published 
 * by the Apache Software Foundation.
 *
 * This work is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * Apache License for more details.
 *
 * Copyright (c) 2015 Anh Tran (tranhoanganh89@gmail.com). 
 * All rights reserved.
 */
package com.anhtran.productimage.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.anhtran.productimage.dao.ProductDao;
import com.anhtran.productimage.model.Image;
import com.anhtran.productimage.model.Product;
import com.anhtran.productimage.service.ProductService;

@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	public Product createProduct(Product product) {
		productDao.save(product);
		return product;
	}

	public Product getProductFromId(long productId) {
		return productDao.getProductById(productId);
	}

	public Product updateProduct(Product product) {
		productDao.update(product);
		return product;
	}

	public void deleteProduct(Product product) {
		productDao.delete(product);
	}

	public List<Product> getAllProductExcludingRelationship() {
		return productDao.getAllProductExcludingRelationship();
	}

	public List<Product> getAllProductIncludingRelationship() {
		return productDao.getAllProductIncludingRelationship();
	}

	public Product getProductExcludingRelationshipFromId(int productId) {
		return productDao.getProductExcludingRelationshipFromId(productId);
	}

	public Product getProductIncludingRelationshipFromId(int productId) {
		return productDao.getProductIncludingRelationshipFromId(productId);
	}

	public List<Product> getChildProductList(int productId) {
		return productDao.getChildProductList(productId);
	}

	public List<Image> getImageList(int productId) {
		return productDao.getImageList(productId);
	}
}
