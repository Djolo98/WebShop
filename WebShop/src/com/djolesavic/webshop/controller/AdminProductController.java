package com.djolesavic.webshop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.annotation.MultipartConfig;
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
import org.springframework.web.multipart.MultipartFile;

import com.djolesavic.webshop.dao.CategoryDAO;
import com.djolesavic.webshop.dao.OrdersDAO;
import com.djolesavic.webshop.entity.Category;
import com.djolesavic.webshop.entity.Orders;
import com.djolesavic.webshop.entity.Product;
import com.djolesavic.webshop.service.CategoryService;
import com.djolesavic.webshop.service.OrdersService;
import com.djolesavic.webshop.service.ProductService;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
	
	@Autowired
	private CategoryService CategoryService;
	
	@Autowired 
	private ProductService ProductService;
	
	@GetMapping("/list")
	public String listProducts(Model theModel) {
		
		List<Product> theProducts = ProductService.getProducts();
			
		theModel.addAttribute("products", theProducts);
		
		return "admin/list-products";
	}
	
	@GetMapping("/add")
	public String showFormForAdd(Model theModel) {
		
		List<Category> theCategories = CategoryService.getCategories();
				
		theModel.addAttribute("categories", theCategories);
		
		Product theProduct = new Product();
		
		theModel.addAttribute("product", theProduct);
		
		return "admin/product-form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		
		ProductService.saveProduct(theProduct);	
		
		return "redirect:/admin/product/list";
	}
	
	
	@GetMapping("/update")
	public String updateProduct(@RequestParam("productId") int theId,
									Model theModel) {
		
		List<Category> theCategories = CategoryService.getCategories();
				
		theModel.addAttribute("categories", theCategories);
		
		Product theProduct = ProductService.getProduct(theId);	
		
		theModel.addAttribute("product", theProduct);
			
		return "admin/product-form";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		ProductService.deleteProduct(theId);
		
		return "redirect:/admin/product/list";
	}


}

