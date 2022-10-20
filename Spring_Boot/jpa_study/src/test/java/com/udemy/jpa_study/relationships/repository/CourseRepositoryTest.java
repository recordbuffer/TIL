package com.udemy.jpa_study.relationships.repository;

import com.udemy.jpa_study.relationships.RelationshipsApplication;
import com.udemy.jpa_study.relationships.domain.Course;
import com.udemy.jpa_study.relationships.domain.Passport;
import com.udemy.jpa_study.relationships.domain.Review;
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
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = repository.findById(10003L);
        logger.info("{}", course.getReviews());
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Review review = em.find(Review.class, 50001L);
        logger.info("{}", review.getCourse());
    }


}
