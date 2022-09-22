package com.udemy.jpa_study;

import com.udemy.jpa_study.domain.Person;
import com.udemy.jpa_study.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*logger.info("All users -> {}", dao.findAll());
		logger.info("User id 10001 -> {}", dao.findById(10001));
		logger.info("Deleting 10002 -> No of Rows Deleted - {}", dao.deleteById(10002));
		logger.info("Inserting 10004 -> {}",dao.insert(new Person(10004, "Tara", "Berlin", new Date())));
		logger.info("Update 10003 -> {}", dao.update(new Person(10003, "Pieter", "Utrecht", new Date())));*/
	}
}
