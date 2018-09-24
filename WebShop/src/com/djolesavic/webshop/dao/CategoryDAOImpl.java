package com.djolesavic.webshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.djolesavic.webshop.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Category> getCategories() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  
		Query<Category> theQuery = 
				currentSession.createQuery("from Category",
											Category.class);
		
		// execute query and get result list
		List<Category> Categories = theQuery.getResultList();
				
		// return the results		
		return Categories;
	}

	@Override
	public void saveCategory(Category theCategory) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the Category ... finally LOL
		currentSession.saveOrUpdate(theCategory);
		
	}

	@Override
	public Category getCategory(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Category theCategory = currentSession.get(Category.class, theId);
		
		return theCategory;
	}

	@Override
	public void deleteCategory(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Category where id=:CategoryId");
		theQuery.setParameter("CategoryId", theId);
		
		theQuery.executeUpdate();		
	}

}
