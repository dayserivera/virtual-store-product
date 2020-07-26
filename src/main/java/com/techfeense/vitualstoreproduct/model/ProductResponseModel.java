package com.techfeense.vitualstoreproduct.model;

import org.springframework.data.domain.Page;

import com.techfeense.vitualstoreproduct.data.ProductEntity;

public class ProductResponseModel {
	private String productId;
	
	private String title;
	
	private String description;
	
	private double price;
	
	public ProductResponseModel(ProductEntity productEntity) {
		this.productId = productEntity.getProductId();
		this.title = productEntity.getTitle();
		this.description = productEntity.getDescription();
		this.price = productEntity.getPrice();
	}

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
	
	public static Page<ProductResponseModel> listFromProducts(Page<ProductEntity> products){
		return products.map(ProductResponseModel::new);
	}

}
