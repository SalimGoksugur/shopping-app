package com.patika.shoppingapp.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patika.shoppingapp.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByExpirationDateGreaterThanOrExpirationDateIsNull(Date expirationDate);
    List<Product> findByExpirationDateLessThan(Date expirationDate);

}
