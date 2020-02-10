package com.myapp.springbootrest.helloworld;

import java.util.Locale;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private ReloadableResourceBundleMessageSource messageSource;

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

	@GetMapping("/hello-int")
	public String getMessageInI18NFormat(@RequestHeader(name = "Accept-Language", required = false) String locale) {

		return messageSource.getMessage("label.hello", null, new Locale(locale));
	}

}
