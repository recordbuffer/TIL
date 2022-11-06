package com.udemy.jpa_study.inheritance;

import com.udemy.jpa_study.inheritance.domain.Employee;
import com.udemy.jpa_study.inheritance.domain.FullTimeEmployee;
import com.udemy.jpa_study.inheritance.domain.PartTimeEmployee;
import com.udemy.jpa_study.inheritance.repository.EmployeeRepository;
import com.udemy.jpa_study.relationships.repository.CourseRepository;
import com.udemy.jpa_study.relationships.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class InheritanceApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(InheritanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new PartTimeEmployee("김씨", new BigDecimal("50")));
		repository.insert(new FullTimeEmployee("박씨", new BigDecimal("1000")));

		logger.info("All FullTimeEmployees -> {}", repository.insertAllFullTimeEmployees());
		logger.info("All PartTimeEmployees -> {}", repository.insertAllPartTimeEmployees());

	}
}
