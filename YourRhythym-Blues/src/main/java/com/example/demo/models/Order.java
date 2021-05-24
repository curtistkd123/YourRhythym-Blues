package com.example.demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, max=100)
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	@OneToMany(mappedBy="order", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<OrderDetail> orderDetails;
	
	@NotNull
	private float orderAmount;
	
	@NotBlank
	private String orderShipName;
	
	@NotBlank
	private String orderShipAddress;
	
	@NotBlank
	private String orderShipAddress2;
	
	@NotBlank
	private String orderCity;
	
	@NotBlank
	private String orderState;
	
	@NotBlank
	private Integer orderZip;
	
	@NotBlank
	private String orderCountry;
	
	@NotBlank
	private Integer orderPhone;
	
	@NotNull
	private float orderShippingCost;
	
	@NotNull
	private float orderTax;
	
	@NotBlank
	private String orderEmail;
	
	@NotBlank
	private Date orderDate;
	
	@NotBlank
	private Date orderShipped;
	
	@NotNull
	private Long orderTrackingNumber;

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getOrderShipName() {
		return orderShipName;
	}

	public void setOrderShipName(String orderShipName) {
		this.orderShipName = orderShipName;
	}

	public String getOrderShipAddress() {
		return orderShipAddress;
	}

	public void setOrderShipAddress(String orderShipAddress) {
		this.orderShipAddress = orderShipAddress;
	}

	public String getOrderShipAddress2() {
		return orderShipAddress2;
	}

	public void setOrderShipAddress2(String orderShipAddress2) {
		this.orderShipAddress2 = orderShipAddress2;
	}

	public String getOrderCity() {
		return orderCity;
	}

	public void setOrderCity(String orderCity) {
		this.orderCity = orderCity;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public Integer getOrderZip() {
		return orderZip;
	}

	public void setOrderZip(Integer orderZip) {
		this.orderZip = orderZip;
	}

	public String getOrderCountry() {
		return orderCountry;
	}

	public void setOrderCountry(String orderCountry) {
		this.orderCountry = orderCountry;
	}

	public Integer getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(Integer orderPhone) {
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getOrderShipped() {
		return orderShipped;
	}

	public void setOrderShipped(Date orderShipped) {
		this.orderShipped = orderShipped;
	}

	public Long getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(Long orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}
	
	
	
}
