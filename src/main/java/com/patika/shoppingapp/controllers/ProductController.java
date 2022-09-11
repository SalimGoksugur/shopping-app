package com.patika.shoppingapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patika.shoppingapp.dtos.CreateProductDto;
import com.patika.shoppingapp.dtos.ProductDto;
import com.patika.shoppingapp.response.RestResponse;
import com.patika.shoppingapp.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		
		this.productService = productService;
	}
	
	@GetMapping
	public ResponseEntity<RestResponse<List<ProductDto>>> getAll() {
		return new ResponseEntity<> (productService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<RestResponse<ProductDto>> getById(@PathVariable Long id) {
		
		return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/expiredProducts")
	public ResponseEntity<RestResponse<List<ProductDto>>> getExpiredProducts() {
		return new ResponseEntity<> (productService.getExpiredProducts(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/freshProducts")
	public ResponseEntity<RestResponse<List<ProductDto>>> getFreshProducts() {
		return new ResponseEntity<> (productService.getFreshProducts(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<RestResponse<ProductDto>> createProduct (@Valid @RequestBody CreateProductDto createProductDto) {
		
		return new ResponseEntity<>(productService.create(createProductDto), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<RestResponse<Void>> deleteProduct(@PathVariable Long id) {
		
		return new ResponseEntity<>(productService.delete(id), HttpStatus.NO_CONTENT);
		
	}
	

}
