package com.djolesavic.webshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.djolesavic.webshop.entity.Category;
import com.djolesavic.webshop.entity.Orders;

@Repository
public class OrdersDAOImpl implements OrdersDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(Orders order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
	}
	
	@Override
	public List<Orders> getOrders() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  
		Query<Orders> theQuery = 
				currentSession.createQuery("from Orders",
						Orders.class);
		
		// execute query and get result list
		List<Orders> Orders = theQuery.getResultList();
				
		// return the results		
		return Orders;
	}

}
