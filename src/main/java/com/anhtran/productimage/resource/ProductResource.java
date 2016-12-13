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
package com.anhtran.productimage.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.anhtran.productimage.model.Product;

@Component
@Path("/product")
public interface ProductResource {
	@POST
	@Path("/{parentId}/{name}/{description}/{imageList}")
	@Produces("application/json")
	public Product createProduct(
		@PathParam("parentId") int parentId,
		@PathParam("name") String name,
		@PathParam("description") String description,
		@PathParam("imageList") String imageList);

	@GET
	@Path("/{productId}")
	@Produces("application/json")
	public Product getProductFromId(@PathParam("productId") int productId);

	@PUT
	@Path("/{productId}/{parentId}/{name}/{description}/{imageList")
	@Produces("application/json")
	public Product updateProduct(
		@PathParam("productId") int productId,
		@PathParam("parentId") int parentId,
		@PathParam("name") String name,
		@PathParam("description") String description,
		@PathParam("imageList") String imageList);

	@DELETE
	@Path("/{productId}")
	public Response deleteProduct(@PathParam("productId") int productId);
}