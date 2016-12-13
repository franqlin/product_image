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

import com.anhtran.productimage.model.Image;

@Component
@Path("/image")
public interface ImageResource {
	@POST
	@Path("/{productId}/{type}/{location}")
	@Produces("application/json")
	public Image createImage(
		@PathParam("productId") long productId, 
		@PathParam("type") String type, 
		@PathParam("location")String location);

	@GET
	@Path("/{imageId}")
	@Produces("application/json")
	public Image getImageFromId(@PathParam("imageId") long imageId);

	@PUT
	@Path("/{imageId}/{productId}/{type}/{location}")
	@Produces("application/json")
	public Image updateImage(
		@PathParam("imageId") long imageId,
		@PathParam("productId") long productId,
		@PathParam("type") String type,
		@PathParam("location") String location);

	@DELETE
	@Path("/{imageId}")
	public Response deleteImage(@PathParam("imageId") long imageId);
}