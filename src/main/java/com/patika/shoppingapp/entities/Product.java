package com.patika.shoppingapp.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
public class Product {
	
	@Id
	@SequenceGenerator(name = "product", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "product", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@Column(nullable = false, precision = 11, scale = 2)
	private BigDecimal price;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationDate;
	
	@OneToMany(mappedBy = "product")
	private Set<Comment> comments;

}
