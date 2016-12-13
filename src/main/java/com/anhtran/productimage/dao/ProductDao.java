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
package com.anhtran.productimage.dao;

import java.util.List;

import com.anhtran.productimage.model.Image;
import com.anhtran.productimage.model.Product;

public interface ProductDao {
	public void save(Product image);
	public void update(Product image);
	public Product getProductById(long productId);
	public void delete(Product image);
	
	public List<Product> getAllProductExcludingRelationship();
	public List<Product> getAllProductIncludingRelationship();
	public Product getProductExcludingRelationshipFromId(int productId);
	public Product getProductIncludingRelationshipFromId(int productId);
	public List<Product> getChildProductList(int productId);
	public List<Image> getImageList(int productId);
}