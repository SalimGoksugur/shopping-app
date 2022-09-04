package com.patika.shoppingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patika.shoppingapp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
