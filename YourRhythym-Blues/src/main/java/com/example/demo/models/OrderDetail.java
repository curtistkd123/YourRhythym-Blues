package com.example.demo.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="orderDetails")
public class OrderDetail {
	
	
	//order detail 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="orderItem_id")
	private OrderItem orderItems;
	
	public OrderItem getOrderItem() {
		return orderItems;
	}

	public void setOrderItem(OrderItem orderItems) {
		this.orderItems = orderItems;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	
	@NotBlank
	private String detailName;
	
	@NotNull
	private float detailPrice;
	
	@NotNull
	private Integer detailQuantity;
	
	@OneToOne(mappedBy="orderDetail", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private PaymentDetail paymentDetail;

	
	
	public OrderDetail(User user, OrderItem orderItems,  Product product, @NotBlank String detailName,
			@NotNull float detailPrice, @NotNull Integer detailQuantity) {
		super();
		this.user = user;
		this.orderItems = orderItems;
		
		this.product = product;
		this.detailName = detailName;
		this.detailPrice = detailPrice;
		this.detailQuantity = detailQuantity;
		this.paymentDetail = paymentDetail;
	}

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
	
	public OrderDetail() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public float getDetailPrice() {
		return detailPrice;
	}

	public void setDetailPrice(float detailPrice) {
		this.detailPrice = detailPrice;
	}

	public Integer getDetailQuantity() {
		return detailQuantity;
	}

	public void setDetailQuantity(Integer detailQuantity) {
		this.detailQuantity = detailQuantity;
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

	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}
	
	
	

}
