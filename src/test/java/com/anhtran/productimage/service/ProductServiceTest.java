package com.anhtran.productimage.service;

import java.util.HashSet;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anhtran.productimage.model.Image;
import com.anhtran.productimage.model.Product;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/applicationContext.xml")
public class ProductServiceTest {
	@Autowired
	private ProductService productService;

	private Product product;

	@After
	public void cleanup() {
		if (product != null) {
			productService.deleteProduct(product);
		}
	}

	private void createNewProduct() {
		product = new Product();
		product.setParentProduct(null);
		product.setName("ABC");
		product.setDescription("ABC");
		product.setImageList(new HashSet<Image>());
		productService.createProduct(product);
	}

	@Test
	public void createProductTest() {
		createNewProduct();
		Assert.assertTrue(product.getId() > 0);
	}

	@Test
	public void getProductTest() {
		createNewProduct();

		// search for this product
		Product result = productService.getProductFromId(product.getId());
		Assert.assertTrue(result != null);
		Assert.assertEquals(result.getId(), product.getId());
	}

	@Test
	public void updateProductTest() {
		createNewProduct();

		// update 
		product.setName("BCD");
		productService.updateProduct(product);

		// get product
		Product result = productService.getProductFromId(product.getId());
		Assert.assertEquals(result.getName(), "BCD");
	}
}
