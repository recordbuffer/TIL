package com.example.userservice.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.repository.UserEntity;
import com.example.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepositroy;
	BCryptPasswordEncoder pwdEncoder;

	 @Autowired 
	 public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder pwdEncoder) {
		 this.userRepositroy = userRepository;
		 this.pwdEncoder = pwdEncoder;
	 }

	@Override
	public UserDto createUser(UserDto userDto) {
		// userId, encryptedPassword setting
		userDto.setUserId(UUID.randomUUID().toString());
		userDto.setEncyptedPassword(pwdEncoder.encode(userDto.getPassword()));

		// RequestUser -> UserDto 변환 -> service 호출
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity = mapper.map(userDto, UserEntity.class);
		
		// repository의 create 호출
		userRepositroy.save(userEntity);

		return userDto;
	}
	
	/*
	 * UsernamePasswordAuthenticationFilter - attemptAuthentication
	 * -> UserDetailService(loadUserByUsername callback override)
	 * -> UserRepository findByEmail (user name) 
	 * @return UserDetails
	 */	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepositroy.findByEmail(username);
		if(userEntity == null) throw new UsernameNotFoundException(username);
		return new User(userEntity.getEmail(), userEntity.getEncyptedPassword(), true, true, true, true, new ArrayList<>());
	}

	@Override
	public UserDto getUserByEmail(String email) {
		// UserEntity -> UserDto 변환
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity = userRepositroy.findByEmail(email);
		
		return mapper.map(userEntity, UserDto.class);
	}

}
