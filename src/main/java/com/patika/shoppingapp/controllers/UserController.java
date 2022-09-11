package com.patika.shoppingapp.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patika.shoppingapp.dtos.CreateUserDto;
import com.patika.shoppingapp.dtos.UserDto;
import com.patika.shoppingapp.response.RestResponse;
import com.patika.shoppingapp.services.UserService;


@RestController
@RequestMapping("api/v1/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		
		this.userService=userService;
	}
	
	@GetMapping
	public ResponseEntity<RestResponse<List<UserDto>>>  getAll(){
		
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<RestResponse<UserDto>> getById(@PathVariable Long id){
		return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);

	}
	
	@PostMapping
	public ResponseEntity<RestResponse<UserDto>> createUser(@Valid @RequestBody CreateUserDto createUserDto) {
		return new ResponseEntity<>(userService.create(createUserDto), HttpStatus.CREATED);
	}

}
