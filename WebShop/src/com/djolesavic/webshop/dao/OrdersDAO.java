package com.djolesavic.webshop.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.djolesavic.webshop.entity.Orders;

@Transactional
public interface OrdersDAO {
	
	public List<Orders> getOrders();
	
	public void save(Orders order);
	
}
