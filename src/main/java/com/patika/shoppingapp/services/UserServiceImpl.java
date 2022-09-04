package com.patika.shoppingapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.patika.shoppingapp.dtos.CreateUserDto;
import com.patika.shoppingapp.dtos.UserDto;
import com.patika.shoppingapp.entities.User;
import com.patika.shoppingapp.exceptions.ErrorMessages;
import com.patika.shoppingapp.exceptions.ItemNotFoundException;
import com.patika.shoppingapp.mapper.UserMapper;
import com.patika.shoppingapp.repositories.UserRepository;
import com.patika.shoppingapp.response.RestResponse;

@Service
public class UserServiceImpl implements UserService {
	
	private  UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public RestResponse<UserDto> create(CreateUserDto createUserDto) {
		
		User user = UserMapper.INSTANCE.convertToUser(createUserDto);
		User createdUser = userRepository.save(user);
		UserDto userDto = UserMapper.INSTANCE.convertToUserDto(createdUser);
		return RestResponse.success(userDto);
	}

	@Override
	public RestResponse<List<UserDto>> getAll() {
		
		List<User> users = userRepository.findAll();
		List<UserDto> userDtos = UserMapper.INSTANCE.convertToUserDtos(users);
		return RestResponse.success( userDtos);
	}

	@Override
	public RestResponse<UserDto> getById(Long id) {
		
		User user = getUserEntityById(id);
		UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);
		return RestResponse.success(userDto);
	}
	


	@Override
	public RestResponse<Void> delete(Long id) {
		
		User user = getUserEntityById(id);
		userRepository.delete(user);
		return RestResponse.empty();	
	}


	@Override
	public User getUserEntityById(Long id) {
		
		 return userRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(ErrorMessages.ITEM_NOT_FOUND.toString()));
	}
}
