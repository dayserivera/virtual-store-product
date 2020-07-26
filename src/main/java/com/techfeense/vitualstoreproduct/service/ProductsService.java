package com.techfeense.vitualstoreproduct.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.techfeense.vitualstoreproduct.data.ProductEntity;

public interface ProductsService {
	ProductEntity createProduct(ProductEntity productDetails);
	List<ProductEntity> getAllProducts();
	Page<ProductEntity> findAll(Specification<ProductEntity> specification, Pageable pageRequest);
}
