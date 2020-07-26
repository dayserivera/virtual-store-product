package com.techfeense.vitualstoreproduct.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techfeense.vitualstoreproduct.data.ProductEntity;
import com.techfeense.vitualstoreproduct.model.CreateProductRequestModel;
import com.techfeense.vitualstoreproduct.model.ProductRequestModel;
import com.techfeense.vitualstoreproduct.model.ProductResponseModel;
import com.techfeense.vitualstoreproduct.model.ProductsResponseModel;
import com.techfeense.vitualstoreproduct.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	
	@PostMapping
	public ResponseEntity<CreateProductRequestModel> createProduct(@Valid @RequestBody CreateProductRequestModel productDetail) {
		ModelMapper modelMapper = new ModelMapper();
		ProductEntity product = modelMapper.map(productDetail, ProductEntity.class);
		
		ProductEntity createdProduct = productsService.createProduct(product);
		
		CreateProductRequestModel returnValue = modelMapper.map(createdProduct, CreateProductRequestModel.class);
		
		return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ProductsResponseModel> listProducts(){
		ModelMapper modelMapper = new ModelMapper();
		ProductsResponseModel resturnValue = new ProductsResponseModel();
		List<ProductEntity> products = productsService.getAllProducts();
		
		List<ProductResponseModel> productResponseModelList = products
				  .stream()
				  .map(product -> modelMapper.map(product, ProductResponseModel.class))
				  .collect(Collectors.toList());
		resturnValue.setProducts(productResponseModelList);
		
		return new ResponseEntity<>(resturnValue, HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public Page<ProductResponseModel> searchProducts(@RequestBody(required=false) ProductRequestModel productRequestModel, Pageable pageRequest){
		if(productRequestModel == null) {
			productRequestModel = new ProductRequestModel();
		}
		
		Specification<ProductEntity> specification = productRequestModel.build();
		Page<ProductEntity> products = productsService.findAll(specification, pageRequest);
		
		return ProductResponseModel.listFromProducts(products);
	}
	
}
