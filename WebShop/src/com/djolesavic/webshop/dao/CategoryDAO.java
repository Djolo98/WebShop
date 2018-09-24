package com.djolesavic.webshop.dao;

import java.util.List;

import com.djolesavic.webshop.entity.Category;

public interface CategoryDAO {

	public List<Category> getCategories();

	public void saveCategory(Category theCategory);

	public Category getCategory(int theId);

	public void deleteCategory(int theId);
	
}

