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

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.anhtran.productimage.dao.ProductDao;
import com.anhtran.productimage.model.Image;
import com.anhtran.productimage.model.Product;

public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Product product) {
		sessionFactory.getCurrentSession().persist(product);
	}

	public void update(Product product) {
		sessionFactory.getCurrentSession().update(product);
	}

	public void delete(Product product) {
		sessionFactory.getCurrentSession().delete(product);
	}

	public Product getProductById(long productId) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProductExcludingRelationship() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select * from product").addEntity(Product.class);
		List<Product> result = query.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProductIncludingRelationship() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> result = session.createCriteria(Product.class).list();
		return result;
	}

	@SuppressWarnings("unchecked")
	public Product getProductExcludingRelationshipFromId(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select * from product p where p.id = :productId")
			.addEntity(Product.class).setParameter("productId", productId);
		List<Product> result = query.list();
		return result.size() > 0 ? result.get(0) : null;
	}

	public Product getProductIncludingRelationshipFromId(int productId) {
		return getProductById(productId);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getChildProductList(int productId) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> result = session.createCriteria(Product.class)
				.add(Restrictions.eq("parentProduct.id", productId))
				.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Image> getImageList(int productId) {
		Session session = sessionFactory.getCurrentSession();
		List<Image> result = session.createCriteria(Image.class)
				.add(Restrictions.eq("product", productId))
				.list();
		return result;
	}
}
