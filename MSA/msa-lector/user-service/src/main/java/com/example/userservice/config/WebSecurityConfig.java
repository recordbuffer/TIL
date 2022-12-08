package com.example.userservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.userservice.filter.AuthenticationFilter;
import com.example.userservice.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserService userService;
	private Environment env;
	private BCryptPasswordEncoder pwdEncoder;
	
	public WebSecurityConfig(UserService userService, Environment env, BCryptPasswordEncoder pwdEncoder) {
		this.userService = userService;
		this.env = env;
		this.pwdEncoder = pwdEncoder;
	}

	/*
	 * 인증처리
	 * RequestLogin email, password의 password bcypt encoding 정보 비교 인증
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(pwdEncoder);
	}

	/*
	 * 권한 관리
	 * users/** 요청에 대해 AuthenticationFilter 거쳐서 인증 체크 후 접근
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/user-services/health-check").permitAll();
//		http.authorizeRequests().antMatchers("/**").hasIpAddress("localhost").and().addFilter(getAuthenticationFilter());
		http.csrf().disable();
		http.headers().frameOptions().disable();	//h2-console 사용
	}
	
	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		return new AuthenticationFilter(authenticationManager(), userService, env);
		
	}
	
}
