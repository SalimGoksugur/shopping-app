package com.patika.shoppingapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.patika.shoppingapp.dtos.CreateProductDto;
import com.patika.shoppingapp.dtos.ProductDto;
import com.patika.shoppingapp.entities.Product;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	ProductDto convertToProductDto(Product product);
	
	List<ProductDto> convertToProductDtos(List<Product> products);
	
	Product convertToProduct(CreateProductDto createProductDto);

}
