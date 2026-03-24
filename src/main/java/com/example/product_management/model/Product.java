package com.example.product_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private int productId;
	@Column(name = "proName")
	private String proName;
	@Column(name="`order`")
	private int order;
	@Column(name="isActive")
	private boolean isActive;
	public Product(int productId, String proName, int order, boolean isActive) {
		super();
		this.productId = productId;
		this.proName = proName;
		this.order = order;
		this.isActive = isActive;
	}
	public Product() {
		super();
	}
	public Product(String proName, int order, boolean isActive) {
		super();
		this.proName = proName;
		this.order = order;
		this.isActive = isActive;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
