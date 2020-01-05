package com.myapp.springbootrest.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	public String helloworld() {
		return "Hello World";
	}

	@GetMapping("/hello")
	public String helloSpringBoot() {
		return "Welcome to Springboot";
	}
	
	@GetMapping("/hellodetails")
	public UserDetails helloDetails() {
		return new UserDetails("Padma", "Prasad", "Bangalore");
	}
	
}
