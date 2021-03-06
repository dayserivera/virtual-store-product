package com.techfeense.vitualstoreproduct.service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.techfeense.vitualstoreproduct.data.ProductEntity;
import com.techfeense.vitualstoreproduct.data.ProductRepository;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	ProductRepository productRepository;
	
	@Autowired
	public ProductsServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductEntity createProduct(ProductEntity productDetails) {
		productDetails.setProductId(UUID.randomUUID().toString());
		
		this.productRepository.save(productDetails);
		
		return productDetails;
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Page<ProductEntity> findAll(Specification<ProductEntity> specification, Pageable pageRequest) {
		return productRepository.findAll(specification, pageRequest);
	}
	
	

}
