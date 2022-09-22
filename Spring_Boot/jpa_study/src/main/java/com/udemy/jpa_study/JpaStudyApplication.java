package com.udemy.jpa_study;

import com.udemy.jpa_study.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaStudyApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(JpaStudyApplication.class, args);
	}

}
