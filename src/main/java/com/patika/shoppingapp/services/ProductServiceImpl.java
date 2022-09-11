package com.patika.shoppingapp.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.patika.shoppingapp.dtos.CreateProductDto;
import com.patika.shoppingapp.dtos.ProductDto;
import com.patika.shoppingapp.entities.Product;
import com.patika.shoppingapp.exceptions.ErrorMessages;
import com.patika.shoppingapp.exceptions.ItemNotFoundException;
import com.patika.shoppingapp.mapper.ProductMapper;
import com.patika.shoppingapp.repositories.ProductRepository;
import com.patika.shoppingapp.response.RestResponse;

@Service
public class ProductServiceImpl implements ProductService {
	
	private  ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}

	@Override
	public RestResponse<ProductDto> create(CreateProductDto createProductDto) {
		
		Product product = ProductMapper.INSTANCE.convertToProduct(createProductDto);
		Product createdProduct = productRepository.save(product);
		ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(createdProduct);
		return RestResponse.success(productDto);
	}

	@Override
	public RestResponse<List<ProductDto>> getAll() {
		
		List<Product> products = productRepository.findAll();
		List<ProductDto> productDtos = ProductMapper.INSTANCE.convertToProductDtos(products);
		return RestResponse.success(productDtos);
	}

	@Override
	public RestResponse<List<ProductDto>> getExpiredProducts() {
		
		List<Product> expiredProducts = productRepository.findByExpirationDateLessThan(new Date());
		List<ProductDto> productDtos = ProductMapper.INSTANCE.convertToProductDtos(expiredProducts);
		return RestResponse.success(productDtos);
	}

	@Override
	public RestResponse<List<ProductDto>> getFreshProducts() {
		
		List<Product> products = productRepository.findByExpirationDateGreaterThanOrExpirationDateIsNull(new Date());
		List<ProductDto> productDtos = ProductMapper.INSTANCE.convertToProductDtos(products);
		return RestResponse.success(productDtos);
	}

	@Override
	public RestResponse<ProductDto> getById(Long id) {
		
		Product product = getProductEntityById(id);
		ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(product);
		return RestResponse.success(productDto);
	}

	@Override
	public RestResponse<Void> delete(Long id) {
		
		Product product = getProductEntityById(id);
		productRepository.delete(product);
		return RestResponse.empty();
	}
	
	@Override
	public Product getProductEntityById(Long id) {
		
		return productRepository.findById(id).orElseThrow( ()->new ItemNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND.toString()));
	}
	

}
