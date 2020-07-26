package com.techfeense.vitualstoreproduct.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.techfeense.vitualstoreproduct.data.ProductEntity;

public class ProductRequestModel {
	
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
	
	public Specification<ProductEntity> build(){
		return new Specification<ProductEntity>() {

			@Override
			public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new  ArrayList<>();
				
				if(productId != null) {
					predicates.add(criteriaBuilder.equal(root.get("productId"), productId));
				}
				
				if(title != null) {
					predicates.add(criteriaBuilder.like(root.get("title"), "%" + title + "%"));
				}
				
				if(description != null) {
					predicates.add(criteriaBuilder.like(root.get("description"), "%" + description + "%"));
				}
				
				return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			}
			
		};
	}

}
