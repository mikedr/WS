package com.mike.example.ejemplorestfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
	public String helloWorld() {
		return "Hello world";
	}
	
	@GetMapping(path = "/helloWorldBean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world");
	}
	
	@GetMapping(path = "/hello/{name}")
	public HelloWorldBean helloVariablePatch(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello %s",name));
	}
}
