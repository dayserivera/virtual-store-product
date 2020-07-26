package com.techfeense.vitualstoreproduct.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
	ProductEntity findByProductId(String productId);
	List<ProductEntity> findAll();
}
