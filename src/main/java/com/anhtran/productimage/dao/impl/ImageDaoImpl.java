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
package com.anhtran.productimage.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.anhtran.productimage.dao.ImageDao;
import com.anhtran.productimage.model.Image;

public class ImageDaoImpl implements ImageDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Image image) {
		sessionFactory.getCurrentSession().persist(image);
	}

	public void update(Image image) {
		sessionFactory.getCurrentSession().update(image);
	}

	public void delete(Image image) {
		sessionFactory.getCurrentSession().delete(image);
	}

	public Image getImageById(long id) {
		return (Image) sessionFactory.getCurrentSession().get(Image.class, id);
	}
}
