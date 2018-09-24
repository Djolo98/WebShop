package com.djolesavic.webshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.djolesavic.webshop.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Product> getProducts() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Product> theQuery = 
				currentSession.createQuery("from Product",
											Product.class);
		
		// execute query and get result list
		List<Product> Products = theQuery.getResultList();
				
		// return the results		
		return Products;
	}

	@Override
	public void saveProduct(Product theProduct) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the Product ... finally LOL
		currentSession.saveOrUpdate(theProduct);
		
	}

	@Override
	public Product getProduct(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Product theProduct = currentSession.get(Product.class, theId);
		
		return theProduct;
	}

	@Override
	public void deleteProduct(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Product where id=:ProductId");
		theQuery.setParameter("ProductId", theId);
		
		theQuery.executeUpdate();		
	}

	@Override
	public List<Product> findByCategory(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("FROM Product P WHERE P.category = :category");
		theQuery.setParameter("category", theId);
				
		// execute query and get result list
		List<Product> Products = theQuery.getResultList();
						
		// return the results	
		return Products;
	}

}
