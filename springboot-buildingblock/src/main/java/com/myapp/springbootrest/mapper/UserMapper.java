package com.myapp.springbootrest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.myapp.springbootrest.dto.UserMsDto;
import com.myapp.springbootrest.entity.User;

@Mapper(componentModel = "Spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	// User to UserMsDto
	@Mappings({
	@Mapping(source = "email",target = "emailaddress"),
	@Mapping(source="role",target = "rolename")})
	UserMsDto userToUserMsDto();

	// List<User> to List<UserMsDto>
	List<UserMsDto> usersToUserDto(List<User> users);
}
