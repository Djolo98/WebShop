package com.djolesavic.webshop.service;

import java.util.List;

import com.djolesavic.webshop.entity.Product;

public interface ProductService {

	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);
	
	public List<Product> findByCategory(int theid);
	
}
