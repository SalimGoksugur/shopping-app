package com.patika.shoppingapp.controllers;

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
import com.patika.shoppingapp.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		
		this.productService = productService;
	}
	
	@GetMapping
	public ResponseEntity getAll() {
		return new ResponseEntity<> (productService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity getById(@PathVariable Long id) {
		
		return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/expiredProducts")
	public ResponseEntity getExpiredProducts() {
		return new ResponseEntity<> (productService.getExpiredProducts(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/freshProducts")
	public ResponseEntity getFreshProducts() {
		return new ResponseEntity<> (productService.getFreshProducts(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity createProduct (@RequestBody CreateProductDto createProductDto) {
		
		return new ResponseEntity<>(productService.create(createProductDto), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity deleteProduct(@PathVariable Long id) {
		
		return new ResponseEntity<>(productService.delete(id), HttpStatus.NO_CONTENT);
		
	}
	

}
