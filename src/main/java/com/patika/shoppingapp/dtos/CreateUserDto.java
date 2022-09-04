package com.patika.shoppingapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber; 

}
