package com.udemy.jpa_study;

import com.udemy.jpa_study.domain.Person;
import com.udemy.jpa_study.jdbc.PersonJdbcDao;
import com.udemy.jpa_study.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", repository.findAll());
		logger.info("User id 10001 -> {}", repository.findById(10001));
		repository.deleteById(10002);
		logger.info("Inserting -> {}", repository.insert(new Person("Tara", "Berlin", new Date())));
		logger.info("Update 10003 -> {}", repository.update(new Person(10003, "Pieter", "Utrecht", new Date())));
	}
}
