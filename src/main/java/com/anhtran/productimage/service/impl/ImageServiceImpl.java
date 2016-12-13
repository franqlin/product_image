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

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.anhtran.productimage.dao.ImageDao;
import com.anhtran.productimage.model.Image;
import com.anhtran.productimage.service.ImageService;

@Transactional
public class ImageServiceImpl implements ImageService {
	@Autowired
	private ImageDao imageDao;

	public Image createImage(Image image) {
		imageDao.save(image);
		return image;
	}

	public Image getImageFromId(long imageId) {
		return imageDao.getImageById(imageId);
	}

	public Image updateImage(Image image) {
		imageDao.update(image);
		return image;
	}

	public void deleteImage(Image image) {
		imageDao.delete(image);
	}
}
