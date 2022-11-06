package com.udemy.jpa_study.springdatajap.repository;

import com.udemy.jpa_study.springdatajpa.SpringdatajpaApplication;
import com.udemy.jpa_study.springdatajpa.domain.Course;
import com.udemy.jpa_study.springdatajpa.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringdatajpaApplication.class)
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    public void findById() {
        Optional<Course> course = repository.findById(100001L);
        logger.info("{}", course.isPresent());
    }

    @Test
    public void saveWithSpringDataJpa() {
        Course course = new Course("MSA with 3 steps", "in28minutes");
        repository.save(course);
        course.setName("in28minutes - updated");
        repository.save(course);
        logger.info("Course -> {}", repository.findAll());
    }


    @Test
    public void findByName() {
        logger.info("FindByName -> {}", repository.findByName("Learn AWS, GCP and Azure"));
    }

    @Test
    public void findByQuery() {
        logger.info("FindByName -> {}", repository.courseWithQuery());
    }
}
