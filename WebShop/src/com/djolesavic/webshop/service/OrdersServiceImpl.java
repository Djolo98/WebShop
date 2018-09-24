package com.djolesavic.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djolesavic.webshop.dao.OrdersDAO;
import com.djolesavic.webshop.entity.Category;
import com.djolesavic.webshop.entity.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDAO OrdersDAO;
	
	@Override
	@Transactional
	public List<Orders> getOrders() {
		return OrdersDAO.getOrders();
	}
	
	@Override
	@Transactional
	public void save(Orders order) {

		OrdersDAO.save(order);
	}
}
