package com.techfeense.vitualstoreproduct.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techfeense.vitualstoreproduct.model.CreateProductRequestModel;
import com.techfeense.vitualstoreproduct.service.ProductsService;
import com.techfeense.vitualstoreproduct.shared.ProductDto;

@RestController
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	
	@PostMapping
	public ResponseEntity<CreateProductRequestModel> createProduct(@Valid @RequestBody CreateProductRequestModel productDetail) {
		ModelMapper modelMapper = new ModelMapper();
		ProductDto productDto = modelMapper.map(productDetail, ProductDto.class);
		
		ProductDto createdProduct = productsService.createProduct(productDto);
		
		CreateProductRequestModel returnValue = modelMapper.map(createdProduct, CreateProductRequestModel.class);
		
		return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
	}
}
