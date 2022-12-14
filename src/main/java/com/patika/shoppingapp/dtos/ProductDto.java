package com.patika.shoppingapp.dtos;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	
	private Long id;
	
	private String name;
	
	private BigDecimal price ;

	private Date expirationDate;

}
