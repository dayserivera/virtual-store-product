package com.techfeense.vitualstoreproduct.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class ProductEntity implements Serializable{

	private static final long serialVersionUID = 7276810045615784683L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, unique=true)
	private String productId;
	
	@Column(nullable=false, length=150)
	private String title;
	
	@Column(nullable=false, length=2000)
	private String description;
	
	@Column(nullable=false)
	private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
