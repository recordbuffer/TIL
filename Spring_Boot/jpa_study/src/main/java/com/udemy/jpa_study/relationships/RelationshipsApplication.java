package com.udemy.jpa_study.relationships;

import com.udemy.jpa_study.relationships.domain.Review;
import com.udemy.jpa_study.relationships.repository.CourseRepository;
import com.udemy.jpa_study.relationships.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RelationshipsApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;


	public static void main(String[] args) {
		SpringApplication.run(RelationshipsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//studentRepository.saveStudentWithPassport();
		//courseRepository.addHardCodingReviewsCourse();

		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("Goooood","FIVE"));
		reviews.add(new Review("Best ever","FIVE"));
		courseRepository.addReviewsCourse(10003L, reviews);
	}
}
