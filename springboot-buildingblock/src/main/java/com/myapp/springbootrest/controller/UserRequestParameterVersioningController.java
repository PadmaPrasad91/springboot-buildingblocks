package com.myapp.springbootrest.controller;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.springbootrest.dto.UserDtoV1;
import com.myapp.springbootrest.dto.UserDtoV2;
import com.myapp.springbootrest.entity.User;
import com.myapp.springbootrest.exception.UserNotFoundException;
import com.myapp.springbootrest.service.UserService;

@RestController
@RequestMapping("/versioning/params/users")
public class UserRequestParameterVersioningController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/{id}", params = "versioning=1")
	public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
		Optional<User> userOptional = userService.getUserById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found!");
		}
		User user = userOptional.get();
		UserDtoV1 userDtoV1 = modelMapper.map(user, UserDtoV1.class);
		return userDtoV1;
	}

	@GetMapping(value = "/{id}", params = "versioning=2")
	public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
		Optional<User> userOptional = userService.getUserById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found!");
		}
		User user = userOptional.get();
		UserDtoV2 userDtoV2 = modelMapper.map(user, UserDtoV2.class);
		return userDtoV2;
	}
}
