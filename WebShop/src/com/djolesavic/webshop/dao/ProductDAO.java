package com.djolesavic.webshop.dao;

import java.util.List;

import com.djolesavic.webshop.entity.Product;

public interface ProductDAO {

	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);
	
	public List<Product> findByCategory(int theid);
	
}

