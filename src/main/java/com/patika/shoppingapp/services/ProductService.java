package com.patika.shoppingapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.patika.shoppingapp.dtos.CreateProductDto;
import com.patika.shoppingapp.dtos.ProductDto;
import com.patika.shoppingapp.entities.Product;
import com.patika.shoppingapp.response.RestResponse;

@Service
public interface ProductService {
	
	RestResponse<ProductDto> create(CreateProductDto createProductDto);
	
	RestResponse<List<ProductDto>> getAll();
	
	RestResponse<List<ProductDto>> getExpiredProducts();
	
	RestResponse<List<ProductDto>> getFreshProducts();
	
	RestResponse<ProductDto> getById(Long id);
	
	RestResponse<Void> delete(Long id);
	
	Product getProductEntityById(Long id);


}
