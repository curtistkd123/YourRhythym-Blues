package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.CartItem;
import com.example.demo.models.Category;
import com.example.demo.models.Order;
import com.example.demo.models.OrderDetail;
import com.example.demo.models.OrderItem;
import com.example.demo.models.PaymentDetail;
import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.services.HomeService;
import com.example.demo.services.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	private HomeService service;

	@Autowired
	private PaymentService pService;
//	
//	@GetMapping("/vendorRegister")
//	public String vendorSignup(@ModelAttribute("vendor") Vendor vendor) {
//		return "vendorRegister.jsp";
//	}
//	@PostMapping("/vendorRegister")
//	public String createVendor(@Valid @ModelAttribute("vendor")Vendor vendor, BindingResult result, HttpSession session) {
//		vValidate.validate(vendor, result);
//		if(result.hasErrors()) {
//			return"vendorRegister.jsp";
//		}
//		vService.createVendor(vendor);
//		session.setAttribute("id", vendor.getId());
//		
//		return"index.jsp"; 
//	}
//	

	// @GetMapping for product pages
	// takes path variable "product_id" and "quantity" from product display pages

	@GetMapping("/category{cat_id}")
	public String showCategory(@PathVariable("cat_id") Long id, @ModelAttribute("product")Product product, HttpSession session, Model model) {
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
		
		
		return "showCategory.jsp";
	}
		
		
		
		
	@GetMapping("/showProduct{id}")
	public String showProduct(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("product", this.pService.findProduct(id));
		return "showProduct.jsp";
	}

	@GetMapping("/addCartItem{product_id}")
	public String cartItem(@ModelAttribute("cartItem") CartItem cartItem, @PathVariable("product_id") Long id,
			HttpSession session, Model model) {
		if (session.getAttribute("cart") == null) {
			List<CartItem> cart = new ArrayList<CartItem>();
			session.setAttribute("cart", cart);
		}

		Long userId = (Long) session.getAttribute("userid");
		User user = this.service.findUserById(userId);

		Product product = service.findProduct(id);
		cartItem.setProduct(product);
		cartItem.setUser(user);
		List<CartItem> cart = user.getCartItems();
		for(CartItem c: cart) {
			if(c.getProduct().getId()==id) {
				int count= c.getQuantity();
				count++;
				c.setQuantity(count);
				pService.updateCart(c.getId(), count);
				
				int quantity = 0;
				for(CartItem i: cart) {
					quantity+= i.getQuantity();
				}
				model.addAttribute("cartsize", quantity);
				
				return "redirect:/";
			}
		}
		this.pService.createCartItem(cartItem);
		cartItem.setQuantity(cartItem.getQuantity() + 1);
		
		cart.add(cartItem);
		session.setAttribute("cart", cart);
		this.pService.createCartItem(cartItem);
		int quantity = 0;
		for(CartItem i: cart) {
			quantity+= i.getQuantity();
		}
		model.addAttribute("cartsize", quantity);
		return "redirect:/";
	}

	@PostMapping("/addCartItem{product_id}")
	public String createCartItem(@Valid @ModelAttribute("cartItem") CartItem cartItem, BindingResult result,
			@PathVariable("product_id") Long pid, @RequestParam(name = "quantity") Integer quantity,
			HttpSession session, Model viewModel) {
		 
		Long userId = (Long) session.getAttribute("userid");
		User user = this.service.findUserById(userId);
		Long product_id = pid;
		Product product = this.pService.findProduct(product_id);
		List<CartItem> cart = user.getCartItems();
		for(CartItem c: cart) {
			if(c.getProduct().getId()==pid) {
				int count= c.getQuantity();
				count++;
				c.setQuantity(count);
				pService.updateCart(c.getId(), count);
				return "redirect:/index";
			}
		}
		
		
		cartItem.setProduct(product);
		cartItem.setUser(user);
		cartItem.setQuantity(quantity);
		this.pService.createCartItem(cartItem);
		return "redirect:/index";
		
	}

	@GetMapping("/minus{c.id}")
	public String minus(@PathVariable("c.id") Long id, HttpSession session) {
		Long user_id = (Long) session.getAttribute("userid");
		User user = this.service.findUserById(user_id);
		List<CartItem> items = user.getCartItems();
		for (CartItem c : items) {
			if (c.getId() == id) {
				if (c.getQuantity() > 1) {

					int count = c.getQuantity();
					count--;
					c.setQuantity(count);
					pService.updateCart(c.getId(), count);

				}
			}
		}
		return "redirect:/shoppingCart" + user_id;
	}

	@GetMapping("/plus{c.id}")
	public String plus(@PathVariable("c.id") Long id, HttpSession session) {
		Long user_id = (Long) session.getAttribute("userid");
		User user = this.service.findUserById(user_id);
		List<CartItem> items = user.getCartItems();
		for (CartItem c : items) {
			if (c.getId() == id) {

				int count = c.getQuantity();
				count++;
				c.setQuantity(count);

				System.out.println(c.getQuantity());
				// pService.updateCartItem(count);
				pService.updateCart(c.getId(), count);
				//service.updateUser(user_id, user);

			}
		}
		return "redirect:/shoppingCart" + user_id;
	}

	@GetMapping("/shoppingCart{user_id}")
	public String shoppingCart(@PathVariable("user_id") Long id, Model viewModel, HttpSession session) {
		User user = pService.findUserById(id);
		List<CartItem> cartItems = user.getCartItems();
		viewModel.addAttribute("cart", cartItems);
		viewModel.addAttribute("user", user);

		float cartTotal = 0;
		for (CartItem c : cartItems) {
			cartTotal += c.getTotal();
		}

		viewModel.addAttribute("cartTotal", cartTotal);
		int quantity = 0;
		for(CartItem i: cartItems) {
			quantity+= i.getQuantity();
		}
		viewModel.addAttribute("cartsize", quantity);
		return "shoppingCart.jsp";
	}

	
	@GetMapping("/reviewCart")
	public String reviewCart(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("userid");
		User user = pService.findUserById(userId);
		List<CartItem> cartItems = user.getCartItems();
		viewModel.addAttribute("cartItems", cartItems);
		viewModel.addAttribute("user", user);	
		float cartTotal = 0;
		for (CartItem c : cartItems) {
			cartTotal += c.getTotal();
		}
		int quantity = 0;
		for(CartItem i: cartItems) {
			quantity+= i.getQuantity();
		}
		viewModel.addAttribute("cartsize", quantity);
		viewModel.addAttribute("cartTotal", cartTotal);
		return "checkOut.jsp";
	}
	
	@GetMapping("/orderDetail")
	public String shippingDetail(@ModelAttribute("order")Order order, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("userid");
		User user = this.service.findUserById(userId);	
		List<CartItem> cartItems = user.getCartItems();
		float cartTotal = 0;
		for (CartItem c : cartItems) {
			cartTotal += c.getTotal();
		}
		int quantity = 0;
		for(CartItem i: cartItems) {
			quantity+= i.getQuantity();
		}
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("order", order);
		viewModel.addAttribute("cartsize", quantity);
		viewModel.addAttribute("cartTotal", cartTotal);
		return "orderDetail.jsp";
	}
	
	@PostMapping("/orderDetail")
	public String newOrder(@Valid @ModelAttribute("order") Order order, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("userid");
		User user = this.service.findUserById(userId);	
		if (result.hasErrors()) {
			return "orderDetail.jsp";
		}else {
			
		order.setUser(user);
		
//		List<CartItem> cartItems = user.getCartItems();
//		order.setCartItems(cartItems);
//		order.setOrderShippingCost(shippingCost);
//		order.setOrderTax(orderTax);
//		order.setOrderAmount(orderAmount);
		List<CartItem> cart = user.getCartItems();
		List<OrderItem> orderitems = user.getOrderItems();
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		for(CartItem c: cart) {
			OrderItem item = new OrderItem(user, c.getProduct(),c.getQuantity());
			orderitems.add(item);
			OrderDetail detail = new OrderDetail(user,item,c.getProduct(),c.getProduct().getName(),c.getProduct().getPrice(), c.getQuantity());
			details.add(detail);
		}
		order.setOrderDetails(details);
		
		user.setOrderItems(orderitems);
		service.updateUser(user.getId(), user);
	
		return "redirect:/paymentDetail";
		}
	}
	
//	@GetMapping("/shippingDetail{orderDetail}")
//	public String shippingDetail(@ModelAttribute("paymentDetail")PaymentDetail paymentDetail, @PathVariable("orderDetail") Long odId, HttpSession session, Model viewModel) {
//		Long userId = (Long)session.getAttribute("userid");
//		User user = this.service.findUserById(userId);
//
//		
//		
//		return "shippingDetail.jsp";
//	}
//<<<<<<< HEAD


	@GetMapping("/paymentDetail")
	public String paymentDetail(@ModelAttribute("paymentDetail") PaymentDetail paymentDetail, HttpSession session,
			Model viewModel) {
		return "paymentDetail.jsp";
	}


	@RequestMapping(value = "/shoppingCart{userid}/delete{id}")
	public String deleteCartItem(@PathVariable("id") Long id, @PathVariable("userid") Long userid) {
		User user = service.findUserById(userid);
		List<CartItem> cart = user.getCartItems();
		cart.remove(pService.findCartItem(id));
		pService.deleteCartItem(id);

//		
//=======
	
//	@RequestMapping(value="/shoppingCart{userid}/delete{id}")
//		public String deleteCartItem(@PathVariable("id") Long id) {
//			pService.deleteCartItem(id);
//			return "redirect:/shoppingCart{user_id}";
//		
//	}
//	
//	
//>>>>>>> 32ffe894cdbf596c5e4b9a3d1a38e62536677d8d
	
		return"redirect:/shoppingCart{userid}";


		/*
		 * @RequestMapping(value="/shoppingCart{userid}/delete{id}") public String
		 * deleteCartItem(@PathVariable("id") Long id) { pService.deleteCartItem(id);
		 * return "redirect:/shoppingCart{user_id}";
		 * 
		 * }
		 */


	}
	
	@PostMapping("/payment")
		public String createOrder(HttpSession session) {
		Long id = (Long) session.getAttribute("userid");
		User user = service.findUserById(id);
		List<CartItem> cart = user.getCartItems();
		List<OrderItem> orderitems = user.getOrderItems();
		
		for(CartItem c: cart) {
			OrderItem item = new OrderItem(user, c.getProduct(),c.getQuantity());
			orderitems.add(item);
		}
		
		user.setOrderItems(orderitems);
		service.updateUser(user.getId(), user);
		
		return"/orderDetail";
	}
}
