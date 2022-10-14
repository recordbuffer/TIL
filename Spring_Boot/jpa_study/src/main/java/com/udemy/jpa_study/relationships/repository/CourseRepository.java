package com.udemy.jpa_study.relationships.repository;

import com.udemy.jpa_study.relationships.domain.Course;
import com.udemy.jpa_study.relationships.domain.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

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

    public void addReviewsCourse() {
        Course course = findById(10003L);
        logger.info("course.getReviews() -> {} ", course.getReviews());

        Review review1 = new Review("5", "Goooood");
        Review review2 = new Review("5", "Best Ever");

        course.addReview(review1);
        course.addReview(review2);
    }

}
