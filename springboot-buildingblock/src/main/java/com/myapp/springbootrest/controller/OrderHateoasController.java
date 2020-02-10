package com.myapp.springbootrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.springbootrest.entity.Order;
import com.myapp.springbootrest.entity.User;
import com.myapp.springbootrest.exception.UserNotFoundException;
import com.myapp.springbootrest.repository.OrderRepository;
import com.myapp.springbootrest.repository.UserRepository;

@RestController
@RequestMapping(value="/hateoas/users")
public class OrderHateoasController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/{userid}/orders")
	public CollectionModel<User> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userid);
		if (!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found");
		List<Order>allOrders = userOptional.get().getOrders();
		CollectionModel<User> finalResource = new CollectionModel(allOrders);
		return finalResource;
	}

}
