package com.example.userservice.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RequestLogin {
	@NotNull(message="Email cannot be null")
	@Email
	private String email;

	@NotNull(message="Password cannot be null")
	@Size(min=8, message="Password must be equal or grater than 8 character")
	private String password;
}
