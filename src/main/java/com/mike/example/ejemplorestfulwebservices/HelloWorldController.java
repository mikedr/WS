package com.mike.example.ejemplorestfulwebservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
	public String helloWorld() {
		return "Hello world";
	}
}