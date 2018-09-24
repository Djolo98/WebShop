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
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private CategoryService CategoryService;
	
	@Autowired 
	private ProductService ProductService;
	
	@Autowired
	private OrdersService OrdersService;
	
	@GetMapping("/checkout")
	public String checkout(Model theModel) {
		
		List<Category> theCategories = CategoryService.getCategories();
				
		theModel.addAttribute("categories", theCategories);
		
		return "home/checkout";
	}
	
	@GetMapping("/")
	public String home(Model theModel) {
		
		List<Category> theCategories = CategoryService.getCategories();
				
		theModel.addAttribute("categories", theCategories);
		
		return "home/home";
	}
	
	@GetMapping("/{id}")
	public String homeCategories(@PathVariable int id, Model theModel) {
		
		List<Category> theCategories = CategoryService.getCategories();
		
		Category theCategory = CategoryService.getCategory(id);

		List<Product> theProducts = ProductService.findByCategory(id);
		
		theModel.addAttribute("categories", theCategories);
		
		theModel.addAttribute("category", theCategory);
		
		theModel.addAttribute("products", theProducts);
		
		return "home/home";
	}
	
	@GetMapping("/tobasket/{id}")
	public String toBasket(@PathVariable int id, Model theModel) {
		List<Category> theCategories = CategoryService.getCategories();
		Product theProduct = ProductService.getProduct(id);
		theModel.addAttribute("categories", theCategories);
		theModel.addAttribute("product", theProduct);
		return "home/tobasket";
	}
	 
	@PostMapping("/tobasket/addtobasket")
	public String addBasket(HttpServletRequest request, @RequestParam(required = true) Integer id, @RequestParam(required = true) Integer quantity) {
		HttpSession session = request.getSession(); 
		HashMap<Integer,Product> cart;
		if(session.getAttribute("cart")==null){
			session.setAttribute("cart", new HashMap<Integer,Product>());
		}
		cart = (HashMap<Integer,Product>)session.getAttribute("cart");
		Product product = ProductService.getProduct(id);
		product.quantity = quantity;
		if (!cart.containsKey(id)){
			cart.put(id,product); 
		} else {
			Product productFromCart = cart.get(id);
			productFromCart.quantity += quantity;
		}
		return "home/cart";
	}
	
	@PostMapping("/addone")
	public String addOne(HttpServletRequest request, @RequestParam(required = true) Integer id) {
		HttpSession session = request.getSession(); 
		HashMap<Integer,Product> cart;
		if(session.getAttribute("cart")==null){
			session.setAttribute("cart", new HashMap<Integer,Product>());
		}
		cart = (HashMap<Integer,Product>)session.getAttribute("cart");
		Product product = ProductService.getProduct(id);
		Product productFromCart = cart.get(id);
		if (!cart.containsKey(id)){
			cart.put(id,product); 
		} else {
			productFromCart.quantity ++;
		}
		return "redirect:/home/cart";
	}
	
	@PostMapping("/removeone")
	public String removeOne(HttpServletRequest request, @RequestParam(required = true) Integer id) {
		HttpSession session = request.getSession(); 
		HashMap<Integer,Product> cart;
		if(session.getAttribute("cart")==null){
			session.setAttribute("cart", new HashMap<Integer,Product>());
		}
		cart = (HashMap<Integer,Product>)session.getAttribute("cart");
		Product product = ProductService.getProduct(id);
		Product productFromCart = cart.get(id);
		if (!cart.containsKey(id)){
			cart.put(id,product); 
		} else {
			productFromCart.quantity --;
		}
		if (productFromCart.quantity==0) {
			cart.remove(id); 
		}
		return "redirect:/home/cart";
	}
	
	@GetMapping("/cart")
	public String cart(HttpServletRequest request, Model theModel) {
		List<Category> theCategories = CategoryService.getCategories();
		theModel.addAttribute("categories", theCategories);
		
		List<Product> products = new ArrayList<Product>();

		HttpSession session = request.getSession();

		if(session.getAttribute("cart")!=null){
			HashMap<Integer,Product> sessionProducts = (HashMap<Integer,Product>)session.getAttribute("cart");
			for(Entry<Integer, Product> p : sessionProducts.entrySet()){
				products.add(p.getValue());
			}
		}
		
		theModel.addAttribute("products", products);
		return "home/cart";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam(required = true) Integer id, HttpServletRequest request, Model theModel) {
		List<Category> theCategories = CategoryService.getCategories();
		theModel.addAttribute("categories", theCategories);
		
		HttpSession session = request.getSession();

		if(session.getAttribute("cart")!=null){
			HashMap<Integer,Product> sessionProducts = (HashMap<Integer,Product>)session.getAttribute("cart");
			if (sessionProducts.containsKey(id)){
				sessionProducts.remove(id); 
			} 
		}
		
		return "redirect:/home/cart";
	}
	
	@PostMapping("/clearcart")
	public String clearCart(HttpServletRequest request, Model theModel) {
		List<Category> theCategories = CategoryService.getCategories();
		theModel.addAttribute("categories", theCategories);
		
		HttpSession session = request.getSession();

		if(session.getAttribute("cart")!=null){
			session.invalidate();
		}
		
		return "redirect:/home/cart";
	}
	
	@RequestMapping("/confirm")
	public String confirm(@RequestParam(required = false) Integer id, HttpServletRequest request, Model theModel, String userdata) {
		List<Category> theCategories = CategoryService.getCategories();
		theModel.addAttribute("categories", theCategories);
		
		if(userdata==null) {
			
		} else {
			
			StringBuilder sb = new StringBuilder();
			HttpSession session = request.getSession();
			HashMap<Integer,Product> sessionProducts = (HashMap<Integer,Product>)session.getAttribute("cart");
			sb.append("[");
			for(Map.Entry<Integer, Product> p : sessionProducts.entrySet()){
				sb.append("{\"id\":");
				sb.append(p.getValue().getId());
				sb.append("{\"q\":");
				sb.append(p.getValue().getQuantity());
				sb.append("},");
			}
			String substr = sb.substring(0, sb.length()-1);
			substr += "]";
			Orders order = new Orders();
			order.setOrdertime(new Date(new java.util.Date().getTime()));
			order.setProducts(substr);
			OrdersService.save(order);
			
			session.removeAttribute("cart");
			return "confirmsuccess";
		}
		return "home/confirm";
	}
	
	@PostMapping("/checkout/confirm")
	public String checkout(@RequestParam(required = false) Integer id, HttpServletRequest request, Model theModel, String firstname, String lastname, String email, String address) {
		List<Category> theCategories = CategoryService.getCategories();
		theModel.addAttribute("categories", theCategories);
		
			StringBuilder sb = new StringBuilder();
			HttpSession session = request.getSession();
			String substr = "007";
			Orders order = new Orders();
			order.setOrdertime(new Date(new java.util.Date().getTime()));
			order.setProducts(substr);
			order.setFirstName(firstname);
			order.setLastName(lastname);
			order.setEmail(email);
			order.setAddress(address);
			OrdersService.save(order);
			
			session.removeAttribute("cart");
			
		return "home/cart";
	}

	
	
}



