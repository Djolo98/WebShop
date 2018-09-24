package com.djolesavic.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djolesavic.webshop.dao.CategoryDAO;
import com.djolesavic.webshop.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	// need to inject Category dao
	@Autowired
	private CategoryDAO CategoryDAO;
	
	@Override
	@Transactional
	public List<Category> getCategories() {
		return CategoryDAO.getCategories();
	}

	@Override
	@Transactional
	public void saveCategory(Category theCategory) {

		CategoryDAO.saveCategory(theCategory);
	}

	@Override
	@Transactional
	public Category getCategory(int theId) {
		
		return CategoryDAO.getCategory(theId);
	}

	@Override
	@Transactional
	public void deleteCategory(int theId) {
		
		CategoryDAO.deleteCategory(theId);
	}
}
