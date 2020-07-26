package com.techfeense.vitualstoreproduct.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<ProductEntity, Long> {
	ProductEntity findByProductId(String productId);
	List<ProductEntity> findAll();
}
