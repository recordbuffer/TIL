package com.hello.mvc.model;

import org.springframework.stereotype.Repository;

@Repository
public class Dao {

	public String sayHello() {
		return "Spring_MVC";
	}
}
