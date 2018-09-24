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
@RequestMapping("/admin/category")
public class AdminCategoryController {
	
	@Autowired
	private CategoryService CategoryService;
	
	@Autowired 
	private ProductService ProductService;
	
	@Autowired
	private OrdersService OrdersService;
	
		@GetMapping("/list")
		public String listCategories(Model theModel) {
			
			List<Category> theCategories = CategoryService.getCategories();
					
			theModel.addAttribute("categories", theCategories);
			
			return "admin/list-categories";
		}
		
		@GetMapping("/products")
		public String listProducts(Model theModel) {
			
			List<Product> theProducts = ProductService.getProducts();
					
			theModel.addAttribute("products", theProducts);
			
			return "admin/list-products";
		}
		
		@GetMapping("/add")
		public String addCategory(Model theModel) {
			
			Category theCategory = new Category();
			
			theModel.addAttribute("category", theCategory);
			
			return "admin/category-form";
		}
		
		@PostMapping("/save")
		public String saveCategory(@ModelAttribute("category") Category theCategory) {
			
			CategoryService.saveCategory(theCategory);	
			
			return "redirect:/admin/category/list";
		}
		
		@GetMapping("/update")
		public String updateCategory(@RequestParam("categoryId") int theId,
										Model theModel) {
			
			Category theCategory = CategoryService.getCategory(theId);	
			
			theModel.addAttribute("category", theCategory);
				
			return "admin/category-form";
		}
		
		@GetMapping("/delete")
		public String deleteCategory(@RequestParam("categoryId") int theId) {
			
			CategoryService.deleteCategory(theId);
			
			return "redirect:/admin/category/list";
		}


}

