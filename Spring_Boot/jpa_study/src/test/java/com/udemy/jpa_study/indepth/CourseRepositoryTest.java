package com.udemy.jpa_study.indepth;

import com.udemy.jpa_study.indepth.domain.Course;
import com.udemy.jpa_study.indepth.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CourseApplication.class)
public class CourseRepositoryTest {

    @Autowired
    CourseRepository repository;

    @Test
    public void findById_test() {
        Course course = repository.findById(100001L);
        assertEquals("in28minutes", course.getAuthor());
    }

    @Test
    @DirtiesContext      //모든 테스트 실행시킬시 같은 context를 쓰기때문에 발생하는 문제를 방지
    public void deleteById_test() {
        repository.deleteById(100002L);
        assertNull(repository.findById(100002L));
    }

    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        repository.playWithEntityManager();
    }

}
