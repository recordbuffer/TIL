package com.udemy.jpa_study.relationships.repository;

import com.udemy.jpa_study.relationships.domain.Course;
import com.udemy.jpa_study.relationships.domain.Review;
import com.udemy.jpa_study.relationships.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course Course) {
        if (Course.getId() == null) {
            em.persist(Course);
        } else {
            em.merge(Course);
        }
        return Course;
    }


    public void deleteById(Long id) {
        Course Course = findById(id);
        em.remove(Course);
    }

    public void addHardCodingReviewsCourse() {
        // hard coding
        Course course = findById(10003L);
        logger.info("course.getReviews() -> {} ", course.getReviews());

        Review review1 = new Review("Goooood","FIVE");
        Review review2 = new Review("Best ever","FIVE");

        course.addReview(review1);
        review1.setCourse(course);
        course.addReview(review2);
        review2.setCourse(course);

        em.persist(review1);
        em.persist(review2);
    }

    public void addReviewsCourse(Long courseId, List<Review> reviews) {
        //generalizing
        Course course = findById(courseId);
        logger.info("course.getReviews() -> {} ", course.getReviews());

        for(Review review: reviews) {
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }

    public void addHardCodingStudentCourse() {
        // hard coding
        Course course = new Course("Typescript lesson", "이순신");
        Student student = new Student("김고은");

        em.persist(course);
        em.persist(student);

        course.addStudent(student);
        student.addCourse(course);
    }

}
