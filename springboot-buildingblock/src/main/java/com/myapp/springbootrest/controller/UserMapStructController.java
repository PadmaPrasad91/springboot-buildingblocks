package com.myapp.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.springbootrest.dto.UserMsDto;
import com.myapp.springbootrest.mapper.UserMapper;
import com.myapp.springbootrest.repository.UserRepository;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@GetMapping
	public List<UserMsDto> getAllUserDto() {
		return userMapper.usersToUserDto(userRepository.findAll());
	}
}
