package com.techfeense.vitualstoreproduct.service;

import java.util.List;

import com.techfeense.vitualstoreproduct.data.ProductEntity;

public interface ProductsService {
	ProductEntity createProduct(ProductEntity productDetails);
	List<ProductEntity> getAllProducts();
}
