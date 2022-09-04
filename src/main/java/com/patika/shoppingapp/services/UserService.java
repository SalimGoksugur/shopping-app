package com.patika.shoppingapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.patika.shoppingapp.dtos.CreateUserDto;
import com.patika.shoppingapp.dtos.UserDto;
import com.patika.shoppingapp.entities.User;
import com.patika.shoppingapp.response.RestResponse;

@Service
public interface UserService {
	
	RestResponse<UserDto> create(CreateUserDto createUserDto);
	
	RestResponse<List<UserDto>> getAll();
	
	RestResponse<UserDto> getById(Long id);
	
	RestResponse<Void> delete(Long id);
		
	User getUserEntityById(Long id);

}
