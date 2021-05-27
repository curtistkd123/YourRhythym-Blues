package com.example.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	@PostMapping("/shoppingCart")
	public String createCartItem(@ModelAttribute("cartItem") CartItem cartItem, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.service.findUserById(userId);
		cartItem.setUser(user);
		this.pService.createCartItem(cartItem);
		return "redirect:/shoppingCart";
	}
	
	@GetMapping("/shoppingCart")
	public String shoppingCart(@ModelAttribute("cartItem") CartItem cartItem) {
		return "shoppingCart.jsp";
	}
	@PostMapping("/shoppingCart/checkOut")
	public String createOrderItem(@ModelAttribute("orderItem") Order order, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
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
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.service.findUserById(userId);
		orderDetail.setUser(user);
		this.pService.createOrderDetail(orderDetail);
		return "redirect:/paymentDetail";
	}
	
	@GetMapping("/shoppingCart/checkOut/paymentDetail")
	public String paymentDetail(@ModelAttribute("paymentDetail") PaymentDetail paymentDetail, HttpSession session, Model viewModel) {
		return "paymentDetail.jsp";
	}
}
