package com.techfeense.vitualstoreproduct.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateProductRequestModel {
	
	@NotNull(message="Title cannot be null")
	@Size(min=2, message = "Title must not be less than 2 characters")
	private String title;
	
	@NotNull(message="Description cannot be null")
	@Size(min=2, message = "Description must not be less than 2 characters")
	private String description;
	
	@NotNull(message="Description cannot be null")
	private double price;

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
