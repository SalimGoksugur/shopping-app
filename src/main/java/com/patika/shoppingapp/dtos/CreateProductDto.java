package com.patika.shoppingapp.dtos;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
	
	@NotBlank(message = "Product name can not be null!")
	private String name;
	
	@DecimalMin(value = "0.01", message = "Price can not be less then 0.01")
	private BigDecimal price ;
	
	private Date expirationDate;
	
}
