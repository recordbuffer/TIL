package com.udemy.jpa_study.relationships.repository;

import com.udemy.jpa_study.relationships.RelationshipsApplication;
import com.udemy.jpa_study.relationships.domain.Course;
import com.udemy.jpa_study.relationships.domain.Passport;
import com.udemy.jpa_study.relationships.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RelationshipsApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void someTest() {
        // transaction 동안 persistence context가 session 유지

        //Database Operation 1 - Retrieve student
        Student student = em.find(Student.class, 20001L);
        // Persistence Context -> student

        //Database Operation 2 - Retrieve passport
        Passport passport = student.getPassport();
        // Persistence Context -> student, passport

        //Database Operation 3 - update passport
        passport.setNumber("E987654");
        // Persistence Context -> student, passport(updated)

        //Database Operation 4 - update student
        student.setName("한소희 - updated");
        // Persistence Context -> student(updated), passport(updated)

        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());    //passport에는 student_id 컬럼이 없지만 가져올 수 있음 (양방향 연관관계이기때문)
    }

    @Test
    @Transactional
    public void oneToOneFetchTest() {
        Student student = repository.findById(20001L);
        logger.info("student's passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void manyToManyFetchTest() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("student's courses -> {}", student.getCourses());
    }


}
