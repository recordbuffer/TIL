package com.example.secondservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
public class SecondController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome Second Service Success";
	}
	
	@GetMapping("/message")
	public String message(@RequestHeader("second-request") String header) {
		return "Second Service: "+ header;
	}
}
