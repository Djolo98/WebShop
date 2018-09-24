package com.djolesavic.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djolesavic.webshop.dao.ProductDAO;
import com.djolesavic.webshop.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	// need to inject product dao
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {

		productDAO.saveProduct(theProduct);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		
		return productDAO.getProduct(theId);
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		
		productDAO.deleteProduct(theId);
	}

	@Override
	@Transactional
	public List<Product> findByCategory(int theId) {
		return productDAO.findByCategory(theId);
	}
}





