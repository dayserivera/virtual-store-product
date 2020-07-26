package com.techfeense.vitualstoreproduct.service;


import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techfeense.vitualstoreproduct.data.ProductEntity;
import com.techfeense.vitualstoreproduct.data.ProductRepository;
import com.techfeense.vitualstoreproduct.shared.ProductDto;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	ProductRepository productRepository;
	
	@Autowired
	public ProductsServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductDto createProduct(ProductDto productDetails) {
		productDetails.setProductId(UUID.randomUUID().toString());
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		ProductEntity productEntity = modelMapper.map(productDetails, ProductEntity.class);
		this.productRepository.save(productEntity);
		
		ProductDto returnValue = modelMapper.map(productEntity, ProductDto.class);
		
		return returnValue;
	}

}
