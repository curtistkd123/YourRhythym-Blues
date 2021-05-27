package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.CartItem;
import com.example.demo.models.Order;
import com.example.demo.models.OrderDetail;
import com.example.demo.models.PaymentDetail;
//import com.example.demo.models.ShoppingSession;
import com.example.demo.repositories.CartItemRepository;
import com.example.demo.repositories.OrderDetailRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.PaymentDetailRepository;
//import com.example.demo.repositories.ShoppingSessionRepository;

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
	
//	@Autowired
//	private ShoppingSessionRepository sessionRepo;  
	
	public CartItem createCartItem(CartItem cartItem) {
		return this.cartRepo.save(cartItem);
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

}
