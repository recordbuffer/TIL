package com.example.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
public class UserController {
	
	Environment env;
	
	@Autowired
	public UserController(Environment env) {
		super();
		this.env = env;
	}
	
	@GetMapping("/health_check")
	public String healthCheck() {
		return env.getProperty("greeting");
	}

}
