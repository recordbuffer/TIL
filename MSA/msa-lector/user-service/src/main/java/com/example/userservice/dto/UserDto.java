package com.example.userservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private String email;
	private String name;
	private String password;
	private String userId;
	private String encyptedPassword;
}
