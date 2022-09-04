package com.patika.shoppingapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.patika.shoppingapp.dtos.CreateUserDto;
import com.patika.shoppingapp.dtos.UserDto;
import com.patika.shoppingapp.entities.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDto convertToUserDto(User user);
	
	User convertToUser(CreateUserDto createUserDto);
		
	List<UserDto> convertToUserDtos(List<User> userList);

}
