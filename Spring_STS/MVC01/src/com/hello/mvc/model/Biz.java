package com.hello.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Biz {
	
	// Dao(@Repository) 호출
	@Autowired
	private Dao dao;
	
	
	public String sayHello() {
		
		return "Hello, " + dao.sayHello();
	}
}
