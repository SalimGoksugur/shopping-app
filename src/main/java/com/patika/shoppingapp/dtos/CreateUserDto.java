package com.patika.shoppingapp.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {

	@NotBlank(message = "Name can not be null!")
	private String firstName;
	@NotBlank(message = "Surname can not be null!")
	private String lastName;
	@Email(message = "Email address is not valid!")
	private String email;
	private String phoneNumber; 

}
