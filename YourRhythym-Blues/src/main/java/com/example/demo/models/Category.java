package com.example.demo.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, max=100)
	private String name;
	
	private String description;
	
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
	//updating file
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@OneToMany(mappedBy"category", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Product> products;
	
	public void setProduct(Long id) {
		this.product = product;
	}
	
	public String getProduct() {
		return product;
	}
	
	public Category() {
		
	}
	
	public Category(String name) {
		this.name = name;
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




	

}
