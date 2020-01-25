package com.myapp.springbootrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.springbootrest.entity.Order;
import com.myapp.springbootrest.entity.User;
import com.myapp.springbootrest.exception.UserNotFoundException;
import com.myapp.springbootrest.repository.OrderRepository;
import com.myapp.springbootrest.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	// get all order for a user

	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userid);
		if (!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found");
		return userOptional.get().getOrders();
	}

	// Create Order

	@PostMapping("{userid}/orders")
	public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException {

		Optional<User> userOptional = userRepository.findById(userid);
		if (!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found!");
		User user = userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);
	}

	@GetMapping("/{userid}/orders/{orderid}")
	public Optional<Order> getOrderById(@PathVariable Long userid, @PathVariable Long orderid)
			throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userid);
		if (!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found!");
		Optional<Order> orderOptional = orderRepository.findById(orderid);
		if (!orderOptional.isPresent())
			throw new UserNotFoundException("Order Not Found!");
		return orderRepository.findById(orderid);
	}
}
