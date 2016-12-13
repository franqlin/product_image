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

import org.springframework.stereotype.Service;

import com.anhtran.productimage.model.Image;

@Service
public interface ImageService {
	public Image createImage(Image image);
	public Image getImageFromId(long imageId);
	public Image updateImage(Image image);
	public void deleteImage(Image image);
}
