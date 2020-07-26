package com.techfeense.vitualstoreproduct.shared;

import java.io.Serializable;

public class ProductDto implements Serializable {
	private static final long serialVersionUID = -6636608533198062349L;
	
	private String productId;
	private String title;
	private String description;
	private double price;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
