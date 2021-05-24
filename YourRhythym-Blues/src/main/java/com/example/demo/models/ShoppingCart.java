package com.david.yourRhythymBlues.models;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String belongsTo;

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
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="shoppingCart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Guitar> guitars;
	
	@OneToMany(mappedBy="shoppingCart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Amplifier> amplifiers;
	
	@OneToMany(mappedBy="shoppingCart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Accessory> accessories;

	public ShoppingCart() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBelongsTo() {
		return belongsTo;
	}

	public void setBelongsTo(String belongsTo) {
		this.belongsTo = belongsTo;
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

	public List<Guitar> getGuitars() {
		return guitars;
	}

	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}

	public List<Amplifier> getAmplifiers() {
		return amplifiers;
	}

	public void setAmplifiers(List<Amplifier> amplifiers) {
		this.amplifiers = amplifiers;
	}

	public List<Accessory> getAccessories() {
		return accessories;
	}

	public void setAccessories(List<Accessory> accessories) {
		this.accessories = accessories;
	}
	
	
}
