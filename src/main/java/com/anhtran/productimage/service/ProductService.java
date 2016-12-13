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
package com.anhtran.productimage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anhtran.productimage.model.Image;
import com.anhtran.productimage.model.Product;

@Service
public interface ProductService {
	public Product createProduct(Product parentProduct);
	public Product getProductFromId(long productId);
	public Product updateProduct(Product product);
	public void deleteProduct(Product product);

	public List<Product> getAllProductExcludingRelationship();
	public List<Product> getAllProductIncludingRelationship();
	public Product getProductExcludingRelationshipFromId(int productId);
	public Product getProductIncludingRelationshipFromId(int productId);
	public List<Product> getChildProductList(int productId);
	public List<Image> getImageList(int productId);
}
