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
import javax.validation.constraints.NotBlank;
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
	private String orderShipFirstName;
	
	@NotBlank
	private String orderShipLastName;
	

	private String orderShipCompanyName;
	
	@NotBlank
	private String orderShipAddress1;
	
	@NotBlank
	private String orderShipAddress2;
	
	@NotBlank
	private String orderShipCity;
	
	@NotBlank
	private Integer orderShipZip;
	
	@NotBlank
	private String orderShipCountry;
	
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


	public String getOrderShipAddress2() {
		return orderShipAddress2;
	}

	public void setOrderShipAddress2(String orderShipAddress2) {
		this.orderShipAddress2 = orderShipAddress2;
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

	public String getOrderShipFirstName() {
		return orderShipFirstName;
	}

	public void setOrderShipFirstName(String orderShipFirstName) {
		this.orderShipFirstName = orderShipFirstName;
	}

	public String getOrderShipLastName() {
		return orderShipLastName;
	}

	public void setOrderShipLastName(String orderShipLastName) {
		this.orderShipLastName = orderShipLastName;
	}

	public String getOrderShipCompanyName() {
		return orderShipCompanyName;
	}

	public void setOrderShipCompanyName(String orderShipCompanyName) {
		this.orderShipCompanyName = orderShipCompanyName;
	}

	public String getOrderShipAddress1() {
		return orderShipAddress1;
	}

	public void setOrderShipAddress1(String orderShipAddress1) {
		this.orderShipAddress1 = orderShipAddress1;
	}

	public String getOrderShipCity() {
		return orderShipCity;
	}

	public void setOrderShipCity(String orderShipCity) {
		this.orderShipCity = orderShipCity;
	}

	public Integer getOrderShipZip() {
		return orderShipZip;
	}

	public void setOrderShipZip(Integer orderShipZip) {
		this.orderShipZip = orderShipZip;
	}

	public String getOrderShipCountry() {
		return orderShipCountry;
	}

	public void setOrderShipCountry(String orderShipCountry) {
		this.orderShipCountry = orderShipCountry;
	}
	
	
	
}
