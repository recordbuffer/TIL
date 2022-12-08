package com.example.userservice.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;

@RestController
@RequestMapping("/user-service")
public class UserController {
	
	Environment env;
	UserService service;
	
	
	@Autowired
	public UserController(Environment env, UserService service) {
		this.env = env;
		this.service = service;
	}
	
	@GetMapping("/health-check")
	public String healthCheck() {
		return env.getProperty("greeting");
	}
	
	/*
	 * request valid check -> business logic delegation(service) -> 일정 scope에 data 저장
	 * -> view select
	 * async : request valid check -> business logic delegate
	 * @param user
	 * @return
	 */	
	@PostMapping("/users")
	public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
		//RequestUser -> UserDto 변환 -> service 호출
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		
		UserDto userDto = mapper.map(user, UserDto.class);
		userDto = service.createUser(userDto);
		
		//UserDto -> ResponseUser 변환
		ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
	}

}
