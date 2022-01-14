//package com.myapp.springbootrest.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.constraints.Min;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.Link;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
//import com.myapp.springbootrest.entity.User;
//import com.myapp.springbootrest.exception.UserNotFoundException;
//import com.myapp.springbootrest.repository.UserRepository;
//import com.myapp.springbootrest.service.UserService;
//
//@RestController
//@RequestMapping(value = "/hateoas/users")
//public class UserHateoasController {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private UserService userService;
//
//	@GetMapping("/{id}")
//	public EntityModel<User> getUserById(@PathVariable("id") @Min(1) Long id) {
//		try {
//			Optional<User> optionalUser = userService.getUserById(id);
//			User user = optionalUser.get();
//			Long userid = user.getUserid();
//			Link selfLink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
//			user.add(selfLink);
//			EntityModel<User> finalResource = new EntityModel<User>(user);
//			return finalResource;
//		} catch (UserNotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
//		}
//	}
//
//	@GetMapping
//	public CollectionModel<User> getAllUsers() throws UserNotFoundException {
//		List<User> allUsers = userService.getAllUsers();
//		for (User user : allUsers) {
//			// Self Link
//			Long userid = user.getUserid();
//			Link selfLink = ControllerLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
//			user.add(selfLink);
//			// Relationship link with getAllOrders
//			CollectionModel<User> orders = ControllerLinkBuilder.methodOn(OrderHateoasController.class)
//					.getAllOrders(userid);
//			Link ordersLink = ControllerLinkBuilder.linkTo(orders).withRel("all-orders");
//			user.add(ordersLink);
//		}
//
//		// Self link for getAllusers
//		Link selfLinForGetAllusers = ControllerLinkBuilder.linkTo(this.getClass()).withSelfRel();
//		CollectionModel<User> finalResource = new CollectionModel(allUsers);
//		return finalResource;
//
//	}
//}
