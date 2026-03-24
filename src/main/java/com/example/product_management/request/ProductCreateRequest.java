package com.example.product_management.request;

public class ProductCreateRequest {
	private String proName;
	private int order;
	private boolean isActive;
	public ProductCreateRequest(String proName, int order, boolean isActive) {
		super();
		this.proName = proName;
		this.order = order;
		this.isActive = isActive;
	}
	public ProductCreateRequest() {
		super();
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

