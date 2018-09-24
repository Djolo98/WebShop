package com.djolesavic.webshop.service;

import java.util.List;

import com.djolesavic.webshop.entity.Category;
import com.djolesavic.webshop.entity.Orders;

public interface OrdersService {
	
	public List<Orders> getOrders();
	
	public void save(Orders order);
	
}


