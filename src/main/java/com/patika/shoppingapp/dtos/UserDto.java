package com.patika.shoppingapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	
	private Long id;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber; 
}
