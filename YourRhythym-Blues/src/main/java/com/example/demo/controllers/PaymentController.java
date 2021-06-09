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
import com.example.demo.models.Order;
import com.example.demo.models.OrderDetail;
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
	
	//@GetMapping for product pages
	// takes path variable "product_id" and "quantity" from product display pages 
	
	@GetMapping("/showProduct{id}")
	public String showProduct(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("product", this.pService.findProduct(id));
		return "showProduct.jsp";
	}
	

	@GetMapping("/addCartItem{product_id}")
	public String cartItem(@ModelAttribute("cartItem") CartItem cartItem,@PathVariable("product_id")Long id,HttpSession session,Model model) {
		if (session.getAttribute("cart")==null) {
			List<CartItem> cart = new ArrayList<CartItem>();
			session.setAttribute("cart", cart);
		}
	
		Long userId = (Long)session.getAttribute("userid");
		User user = this.service.findUserById(userId);
		
			Product product = service.findProduct(id);
			cartItem.setProduct(product);
			cartItem.setUser(user);
			this.pService.createCartItem(cartItem);
			cartItem.setQuantity(cartItem.getQuantity()+1);
			List <CartItem> cart = (List<CartItem>) session.getAttribute("cart");
			cart.add(cartItem);
			session.setAttribute("cart", cart);
			this.pService.createCartItem(cartItem);
					
	
		return "redirect:/";
	}
	
			
	@PostMapping("/addCartItem{product_id}")
	public String createCartItem(@Valid @ModelAttribute("cartItem") CartItem cartItem, BindingResult result, @PathVariable("product_id") Long pid,
			@RequestParam(name="quantity") Integer quantity, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("userid");
		User user = this.service.findUserById(userId);
		Long product_id = pid;
		Product product = this.pService.findProduct(product_id);
		cartItem.setProduct(product);
		cartItem.setUser(user);
		cartItem.setQuantity(quantity);
		this.pService.createCartItem(cartItem);
		return "redirect:/index";
	}
	

	
	@GetMapping("/shoppingCart{user_id}")
	public String shoppingCart(@PathVariable("user_id") Long id,  Model viewModel, HttpSession session) {
		User user = pService.findUserById(id);	
		List<CartItem> cartItems = user.getCartItems();
		viewModel.addAttribute("cart", cartItems);
		viewModel.addAttribute("user", user);
		
		float cartTotal = 0;
		for(CartItem c: cartItems) {
			cartTotal += c.getTotal();
		}
		
		viewModel.addAttribute("cartTotal",cartTotal);
		return "shoppingCart.jsp";
	}
	
	
	
	@PostMapping("/shoppingCart/checkOut")
	public String createOrderItem(@ModelAttribute("orderItem") Order order, HttpSession session) {
		Long userId = (Long)session.getAttribute("userid");
		User user = this.service.findUserById(userId);
		order.setUser(user);
		this.pService.createOrderItem(order);
		return "redirect:/checkOut";
	}
	
	@GetMapping("/reviewCart")
	public String checkOut(@ModelAttribute("orderItem") Order order) {
		
		return "checkOut.jsp";
	}
	
	@PostMapping("/shoppingCart/Checkout/paymentDetail")
	public String createOrderDetail(@ModelAttribute("orderDetail") OrderDetail orderDetail, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("userid");
		User user = this.service.findUserById(userId);
		orderDetail.setUser(user);
		this.pService.createOrderDetail(orderDetail);
		return "redirect:/paymentDetail";
	}
	
	@GetMapping("/paymentDetail")
	public String paymentDetail(@ModelAttribute("paymentDetail") PaymentDetail paymentDetail, HttpSession session, Model viewModel) {
		return "paymentDetail.jsp";
	}

	@RequestMapping(value="/shoppingCart{userid}/delete{id}")
	public String deleteCartItem(@PathVariable("id") Long id,@PathVariable("userid")Long userid) {
		User user = service.findUserById(userid);
		List<CartItem> cart = user.getCartItems();
		cart.remove(pService.findCartItem(id));
		pService.deleteCartItem(id);
		
	
		return"redirect:/shoppingCart{userid}";

	
	}
}
