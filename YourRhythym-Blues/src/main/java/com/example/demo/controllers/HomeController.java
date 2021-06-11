package com.example.demo.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.CartItem;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.models.Vendor;
import com.example.demo.resources.FileUploadUtil;
import com.example.demo.services.HomeService;
import com.example.demo.validators.UserValidator;
import com.example.demo.validators.VendorValidator;

@Controller
public class HomeController {

	@Autowired
	private UserValidator uValidate;

	@Autowired
	private VendorValidator vValidate;

	@Autowired
	private HomeService service;

	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("userid") == null) {

			return "redirect:/login";
		}
		if (session.getAttribute("cart") == null) {
			List<CartItem> cart = new ArrayList<CartItem>();
			session.setAttribute("cart", cart);
		}
		List<Category> categories = service.findCategories();
		List<Product> products = service.findAllProducts();
		User user = service.findUserById((Long) session.getAttribute("userid"));
		model.addAttribute("user", user);
		model.addAttribute("products", products);
		model.addAttribute("categories",categories);
		List<CartItem> cart = user.getCartItems();
		// List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		model.addAttribute("cart", cart);
		int quantity = 0;
		for(CartItem i: cart) {
			quantity+= i.getQuantity();
		}
		model.addAttribute("cartsize", quantity);
		return "index.jsp";
	}

	@GetMapping("/newVendor")
	public String newVendor(@ModelAttribute("vendor") Vendor vendor) {
		return "newVendor.jsp";
	}

	@PostMapping("/newVendor")
	public String createVendor(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result,
			HttpSession session) {
		vValidate.validate(vendor, result);
		if (result.hasErrors()) {
			return "newVendor.jsp";
		}
		service.createVendor(vendor);
		session.setAttribute("venId", vendor.getId());

		return "vdashboard.jsp";
	}

	@GetMapping("/register")
	public String signup(@ModelAttribute("user") User user) {

		return "userRegister.jsp";
	}

	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		uValidate.validate(user, result);
		if (result.hasErrors()) {
			return "userRegister.jsp";
		}
		service.createUser(user);
		session.setAttribute("userid", user.getId());

		return "redirect:/";
	}

	@GetMapping("/login")
	public String ulogin(@ModelAttribute("user") User user) {

		return "userlogin.jsp";

	}

	// authenticate
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password) {

		boolean authenticate = service.authenticateUser(email, password);
		if (!authenticate) {
			model.addAttribute("error", "Email and/or password do not match");
			return "userlogin.jsp";
		}

		user = service.findByEmail(email);
		session.setAttribute("userid", user.getId());
		return "redirect:/";
	}

	@GetMapping("/edituser{id}")
	public String editUser(@ModelAttribute("user") User user, @PathVariable("id") Long id, Model model) {
		user = service.findUserById(id);
		model.addAttribute("user", user);
		return "editUser.jsp";
	}

	@PostMapping("/edituser{id}")
	public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,
			@PathVariable("id") Long id) {
		
		if (result.hasErrors()) {
			return "editUser.jsp";
		}

		service.updateUser(id,user);
		session.setAttribute("id", user.getId());
	
		return "redirect:/";
	}

	// new Product Controller

	@GetMapping("/newProduct")
	public String newProduct(@ModelAttribute("product") Product product, @ModelAttribute("category") Category category,
			Model model, HttpSession session) {
		List<Category> categories = service.AllCategories();
		Vendor vendor = service.findVendor((Long) session.getAttribute("venId"));
		model.addAttribute("vendor", vendor);
		model.addAttribute("categories", categories);
		;
		return "newProduct.jsp";
	}

	@PostMapping("/addCategory")
	public String addCategory(@RequestParam(name = "category") String name) {
		Category category = new Category();
		category.setName(name);
		service.addCategory(category);
		return "redirect:/newProduct";
	}

	@PostMapping("/newProduct{id}")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
			HttpSession session) {

		if (result.hasErrors()) {
			return "newProduct.jsp";
		}

		Long id = (Long) session.getAttribute("venId");
		Vendor vendor = service.findVendor(id);

		List<Vendor> vendors = new ArrayList<Vendor>();
		product.setVendors(vendors);
		vendors.add(vendor);
		product.setVendors(vendors);

		service.addProduct(product);
		System.out.println(product.getCategory());

		return "redirect:/vdashboard";
	}

	@GetMapping("/vendorlogin")
	public String vlogin(@ModelAttribute("vendor") Vendor vendor) {

		return "vendorlogin.jsp";

	}

	// authenticate
	@PostMapping("/vendorlogin")
	public String vlogin(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result, Model model,
			HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password) {

		boolean authenticate = service.authenticateVendor(email, password);
		if (!authenticate) {
			model.addAttribute("error", "Email and/or password do not match");
			return "vendorlogin.jsp";
		}

		vendor = service.findByVendorEmail(email);
		session.setAttribute("venId", vendor.getId());
		return "redirect:/vdashboard";
	}

	@GetMapping("/vdashboard")
	public String vdash(Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("venId");
		Vendor vendor = service.findVendor(id);
		model.addAttribute("vendor", vendor);
		return "vdashboard.jsp";
	}
	
	@GetMapping("/categories{id}")
	public String catList(@PathVariable("id")Long id,HttpSession session, Model model) {
	if (session.getAttribute("userid") == null) {

		return "redirect:/login";
	}
	if (session.getAttribute("cart") == null) {
		List<CartItem> cart = new ArrayList<CartItem>();
		session.setAttribute("cart", cart);
	}
	Category cat = service.findCategory(id);
	List<Category> categories = service.findCategories();
	List<Product> products = service.findProductByCategory(cat);
	User user = service.findUserById((Long) session.getAttribute("userid"));
	model.addAttribute("user", user);
	model.addAttribute("products", products);
	model.addAttribute("categories",categories);
	List<CartItem> cart = user.getCartItems();
	// List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
	model.addAttribute("cart", cart);
	return "index.jsp";
	}
	
	

}
