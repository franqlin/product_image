package com.anhtran.productimage.service;

import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anhtran.productimage.model.Image;
import com.anhtran.productimage.model.Product;

import junit.framework.Assert;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/applicationContext.xml")
public class ImageServiceTest {
	@Autowired
	private ImageService imageService;
	@Autowired
	private ProductService productService;

	private Product product;
	private Image image;

	@BeforeClass
	public void initProductData() {
		product = new Product();
		product.setParentProduct(null);
		product.setName("ABC");
		product.setDescription("ABC");
		product.setImageList(new HashSet<Image>());
		productService.createProduct(product);
	}

	@AfterClass
	public void cleanupProduct() {
		productService.deleteProduct(product);
	}

	@After
	public void cleanupTest() {
		if (image != null) {
			imageService.deleteImage(image);
		}
	}

	private void createNewImage() {
		image = new Image();
		image.setProduct(product);
		image.setType("jpeg");
		image.setLocation("C:/location");
		imageService.createImage(image);
	}

	@Test
	public void createImageTest() {
		createNewImage();
		Assert.assertTrue(image.getId() > 0);
	}

	@Test
	public void updateImageTest() {
		createNewImage();
		image.setType("bmp");
		imageService.updateImage(image);
		Image result = imageService.getImageFromId(image.getId());
		Assert.assertEquals(result.getType(), "bmp");
	}
}