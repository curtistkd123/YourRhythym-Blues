package com.example.demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="orders")
public class Order {
	
	// order model // 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Size(min=2, max=100)
//	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	@OneToMany(mappedBy="order", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<OrderDetail> orderDetails;
	
//	@OneToMany(mappedBy="order", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private List<CartItem> cartItems;
	
//	public List<CartItem> getCartItems() {
//		return cartItems;
//	}
//
//	public void setCartItems(List<CartItem> cartItems) {
//		this.cartItems = cartItems;
//	}

	@NotNull
	private float orderAmount;
	
	@NotBlank
	private String orderFirstName;
	
	@NotBlank
	private String orderLastName;
	

	private String orderCompanyName;
	
	@NotBlank
	private String orderAddress1;
	

	private String orderAddress2;
	
	@NotBlank
	private String orderCity;
	
	@NotBlank
	private String orderState;
	
	@NotBlank
	private String orderZip;
	
	@NotBlank
	private String orderCountry;
	
	@NotBlank
	private String orderPhone;
	
	@NotNull
	private float orderShippingCost;
	
	@NotNull
	private float orderTax;
	
	@NotBlank
	private String orderEmail;

	
//	@NotBlank
	private Date orderShipped;
	
//	@NotNull
//	private Long orderTrackingNumber;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM--DD HH:mm:ss")
	private Date createdAt;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM--DD HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Order() {
	}

	public Order(User user2) {
		// TODO Auto-generated constructor stub
		this.user = user2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderFirstName() {
		return orderFirstName;
	}

	public void setOrderFirstName(String orderFirstName) {
		this.orderFirstName = orderFirstName;
	}

	public String getOrderLastName() {
		return orderLastName;
	}

	public void setOrderLastName(String orderLastName) {
		this.orderLastName = orderLastName;
	}

	public String getOrderCompanyName() {
		return orderCompanyName;
	}

	public void setOrderCompanyName(String orderCompanyName) {
		this.orderCompanyName = orderCompanyName;
	}

	public String getOrderAddress1() {
		return orderAddress1;
	}

	public void setOrderAddress1(String orderAddress1) {
		this.orderAddress1 = orderAddress1;
	}

	public String getOrderAddress2() {
		return orderAddress2;
	}

	public void setOrderAddress2(String orderAddress2) {
		this.orderAddress2 = orderAddress2;
	}

	public String getOrderCity() {
		return orderCity;
	}

	public void setOrderCity(String orderCity) {
		this.orderCity = orderCity;
	}

	

	public String getOrderCountry() {
		return orderCountry;
	}

	public void setOrderCountry(String orderCountry) {
		this.orderCountry = orderCountry;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}



	public String getOrderZip() {
		return orderZip;
	}

	public void setOrderZip(String orderZip) {
		this.orderZip = orderZip;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public float getOrderShippingCost() {
		return orderShippingCost;
	}

	public void setOrderShippingCost(float orderShippingCost) {
		this.orderShippingCost = orderShippingCost;
	}

	public float getOrderTax() {
		return orderTax;
	}

	public void setOrderTax(float orderTax) {
		this.orderTax = orderTax;
	}

	public String getOrderEmail() {
		return orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	public Date getOrderShipped() {
		return orderShipped;
	}

	public void setOrderShipped(Date orderShipped) {
		this.orderShipped = orderShipped;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	
	

//	public List<CartItem> getCartItems() {
//		return cartItems;
//	}
//
//	public void setCartItems(List<CartItem> cartItems) {
//		this.cartItems = cartItems;
//	}

//	public Long getOrderTrackingNumber() {
//		return orderTrackingNumber;
//	}
//
//	public void setOrderTrackingNumber(Long orderTrackingNumber) {
//		this.orderTrackingNumber = orderTrackingNumber;
//	}


	
	
	
}
