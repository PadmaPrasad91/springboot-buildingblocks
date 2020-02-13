package com.myapp.springbootrest.controller;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.springbootrest.dto.UserMmDto;
import com.myapp.springbootrest.entity.User;
import com.myapp.springbootrest.exception.UserNotFoundException;
import com.myapp.springbootrest.service.UserService;

@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/{id}")
	public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
		Optional<User> userOptional = userService.getUserById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found!");
		}
		User user = userOptional.get();
		UserMmDto userMmDto = modelMapper.map(user, UserMmDto.class);
		return userMmDto;
	}
}
