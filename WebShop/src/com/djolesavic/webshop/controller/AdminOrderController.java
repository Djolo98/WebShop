package com.djolesavic.webshop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.djolesavic.webshop.dao.CategoryDAO;
import com.djolesavic.webshop.dao.OrdersDAO;
import com.djolesavic.webshop.entity.Category;
import com.djolesavic.webshop.entity.Orders;
import com.djolesavic.webshop.entity.Product;
import com.djolesavic.webshop.service.CategoryService;
import com.djolesavic.webshop.service.OrdersService;
import com.djolesavic.webshop.service.ProductService;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {
	
	@Autowired
	private CategoryService CategoryService;
	
	@Autowired 
	private ProductService ProductService;
	
	@Autowired
	private OrdersService OrdersService;
	
		@GetMapping("/list")
		public String listCategories(Model theModel) {
			
			List<Orders> theOrders = OrdersService.getOrders();
					
			theModel.addAttribute("order", theOrders);
			
			return "admin/list-orders";
		}


}

