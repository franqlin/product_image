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

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.anhtran.productimage.model.Image;
import com.anhtran.productimage.model.Product;
import com.anhtran.productimage.resource.ImageResource;
import com.anhtran.productimage.service.ImageService;
import com.anhtran.productimage.service.ProductService;

public class ImageResourceImpl implements ImageResource {
	@Autowired
	private ImageService imageService;
	@Autowired
	private ProductService productService;

	public Image createImage(long productId, String type, String location) {
		Image image = new Image();
		Product product = productService.getProductFromId(productId);
		image.setProduct(product);
		image.setType(type);
		image.setLocation(location);
		return imageService.createImage(image);
	}

	public Image getImageFromId(long imageId) {
		return imageService.getImageFromId(imageId);
	}

	public Image updateImage(long imageId, long productId, String type, String location) {
		Image image = imageService.getImageFromId(imageId);
		Product product = productService.getProductFromId(productId);
		image.setProduct(product);
		image.setType(type);
		image.setLocation(location);
		return imageService.updateImage(image);
	}

	public Response deleteImage(long imageId) {
		Image image = imageService.getImageFromId(imageId);
		imageService.deleteImage(image);
		return Response.status(200).entity("").build();
	}
}
