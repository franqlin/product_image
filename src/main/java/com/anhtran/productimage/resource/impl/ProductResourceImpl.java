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
package com.anhtran.productimage.resource.impl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.anhtran.productimage.model.Image;
import com.anhtran.productimage.model.Product;
import com.anhtran.productimage.resource.ProductResource;
import com.anhtran.productimage.service.ImageService;
import com.anhtran.productimage.service.ProductService;

public class ProductResourceImpl implements ProductResource {
	@Autowired
	ProductService productService;
	@Autowired
	ImageService imageService;

	public Product createProduct(int parentId, String name, String description, String imageList) {
		Set<Image> images = getImageList(imageList);

		Product product = new Product();
		product.setImageList(images);
		Product parentProduct = productService.getProductFromId(parentId);
		product.setParentProduct(parentProduct);
		product.setName(name);
		product.setDescription(description);
		return productService.createProduct(product);
	}

	private Set<Image> getImageList(String imageList) {
		// parsing image list
		String[] imageIdStrings = imageList.split(",");
		Set<Image> images = new HashSet<Image>();
		for (int i=0; i<imageIdStrings.length; i++) {
			long imgId = Long.parseLong(imageIdStrings[i]);
			Image image = imageService.getImageFromId(imgId);
			images.add(image);
		}
		return images;
	}

	public Product getProductFromId(int productId) {
		return productService.getProductFromId(productId);
	}

	public Product updateProduct(int productId, int parentId, String name, String description, String imageList) {
		Product product = productService.getProductFromId(productId);
		Product parentProduct = productService.getProductFromId(parentId);
		Set<Image> images = getImageList(imageList);
		product.setParentProduct(parentProduct);
		product.setName(name);
		product.setDescription(description);
		product.setImageList(images);
		return productService.updateProduct(product);
	}

	public Response deleteProduct(int productId) {
		Product product = productService.getProductFromId(productId);
		productService.deleteProduct(product);
		return Response.status(200).entity("").build();
	}

}