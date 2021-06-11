package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.models.Category;
import com.example.demo.models.CartItem;
import com.example.demo.models.Order;
import com.example.demo.models.OrderDetail;
import com.example.demo.models.OrderItem;
import com.example.demo.models.PaymentDetail;
import com.example.demo.models.Product;
//import com.example.demo.models.ShoppingSession;
import com.example.demo.repositories.CartItemRepository;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.OrderDetailRepository;
import com.example.demo.repositories.OrderItemRepository;
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
	
	@Autowired 
	private OrderItemRepository orderItemRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
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
	
	public Category find(Long id) {
		Category category = this.catRepo.findById(id).orElse(null);
		return category;
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
	
	public CartItem updateCart(Long id, Integer quantity) {
		CartItem updatedCartItem = this.findCartItem(id);
		updatedCartItem.setQuantity(quantity);
		return this.cartRepo.save(updatedCartItem);
	}
	
	/*public Order createOrder(Order order) {
		return orderRepo.save(order);
	}*/
	
	public Order findOrderItem(Long id) {
		Optional<Order> orderItem = orderRepo.findById(id);
			if(orderItem.isPresent()) {
				return orderItem.get();
			}else {
				return null;
			}
			
			
		
	}
	
	public OrderDetail createOrderDetail(OrderDetail orderDetail) {
		return this.orderDetailRepo.save(orderDetail);
	}
	
	public OrderDetail findOrderDetail(Long id) {
		Optional<OrderDetail> orderDetail = orderDetailRepo.findById(id);
		if(orderDetail.isPresent()) {
			return orderDetail.get();
		}else {
			return null;
		}
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


	
	public void deleteCartItem(Long id) {
		this.cartRepo.deleteById(id);
	}


}
