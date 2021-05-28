package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.models.CartItem;
import com.example.demo.models.Order;
import com.example.demo.models.OrderDetail;
import com.example.demo.models.PaymentDetail;
import com.example.demo.models.Product;
//import com.example.demo.models.ShoppingSession;
import com.example.demo.repositories.CartItemRepository;
import com.example.demo.repositories.OrderDetailRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.PaymentDetailRepository;
//import com.example.demo.repositories.ShoppingSessionRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class PaymentService {
	@Autowired
	private CartItemRepository cartRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderDetailRepository orderDetailRepo;
	
	@Autowired
	private PaymentDetailRepository paymentDetailRepo;
	
	@Autowired
	private ProductRepository pRepo;
	
	@Autowired
	private UserRepository uRepo;
	
	
//	@Autowired
//	private ShoppingSessionRepository sessionRepo;  
	
	public User findUserById(Long id) {
		Optional<User> user = uRepo.findById(id);
		
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	
	public CartItem createCartItem(CartItem cartItem) {
		return this.cartRepo.save(cartItem);
	}
	
	public List<CartItem> allCartItems() {
		return this.cartRepo.findAll();
	}
	
	public CartItem findCartItem(Long id) {
		Optional<CartItem> cartItem = cartRepo.findById(id);
			if(cartItem.isPresent()) {
				return cartItem.get();
			}else {
				return null;
			}
			
	}
	
	public Order createOrderItem(Order order) {
		return this.orderRepo.save(order);
	}
	
	public OrderDetail createOrderDetail(OrderDetail orderDetail) {
		return this.orderDetailRepo.save(orderDetail);
	}
	
	public PaymentDetail createPaymentDetail(PaymentDetail paymentDetail) {
		return this.paymentDetailRepo.save(paymentDetail);
	}
	
//	public ShoppingSession createShoppingSession(ShoppingSession shoppingSession) {
//		return this.sessionRepo.save(shoppingSession);
//	}

	public Product findProduct(Long id) {
		Product product = this.pRepo.findById(id).orElse(null);
		return product;
	}
	
}
