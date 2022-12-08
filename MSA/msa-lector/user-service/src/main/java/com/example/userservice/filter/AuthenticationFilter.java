package com.example.userservice.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.RequestLogin;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private UserService userService;
	private Environment env;
	
	public AuthenticationFilter(AuthenticationManager authenticationManager, UserService userService, Environment env) {
		this.userService = userService;
		this.env = env;
	}

	/*
	 * login시 request로부터 requestLogin 객체 생성
	 * UsernamePasswordAuthenticationToken 생성
	 * @return Authentication
	 */	

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		//request로부터 email, password read -> RequestLogin
		try {
			RequestLogin creds = new ObjectMapper().readValue(request.getInputStream(), RequestLogin.class);
			
			//AuthenticationManager 객체의 authenticate();
			//UsernamePasswordAuthenticationToken 생성 setting
			//@return Authentication
			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.attemptAuthentication(request, response);
	}
	
	/*
	 * loadUserByUserName: User 리턴시 encytpedPassword check
	 * 로그인 성공시 JWT, userId header setting 응답
	 */

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		//Authentication객체로부터 username으로 사용된 email정보 얻기
		String email = ((User) authResult.getPrincipal()).getUsername();
		UserDto userDto = userService.getUserByEmail(email);
		
		//token 생성
		String token = Jwts.builder()
				.setSubject(userDto.getUserId())
				.setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(env.getProperty("token.expiration_time"))))
				.signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret"))
				.compact();
		
		//header 정보 setting
		response.addHeader("token", token);
		response.addHeader("userId", userDto.getUserId());
	}
	
}
