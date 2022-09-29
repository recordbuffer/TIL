package com.udemy.jpa_study.indepth.repository;

import com.udemy.jpa_study.indepth.domain.Course;
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

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEntityManager() {
        Course course1 = new Course("EntityManager 111");      // 객체를 생성한 상태 > 비영속
        em.persist(course1);                                         // 객체를 저장한 상태 > 영속

        Course course2 = new Course("EntityManager 222");
        em.persist(course2);

        Course course3 = new Course("EntityManager 333");
        em.persist(course3);       // 엔티티매니저는 1차 캐시에 위의 엔티티를 저장하고 쓰기 지연 SQL 저장소에 쌓아 놓음

        em.flush();            // flush()를 통해 쓰기 지연 SQL 저장소의 쿼리들을 DB로 보냄

        // course1, course2, course3 모두 영속 상태
        em.detach(course2);      // 엔티티매니저에서 엔티티를 분리함 (관리를 그만둠) > 준영속 상태

        course1.setName("EntityManager 111 - updated");          // merge 안했는데 알아서 update됨 : 영속 상태이기 떄문 > dirty checking
        course2.setName("EntityManager 222 - updated");          // 준영속상태의 course2는 update 안됨
        course3.setName("EntityManager 333 - updated");

        em.refresh(course3);            // 원래 영속되어 있던 원본 엔티티를 다시 불러옴
        em.flush();

        //em.clear();          // 엔티티매니저의 모든 엔티티를 삭제함 > 준영속 상태
        //em.close();          // 엔티티매니저 종료 > 준영속 상태
    }

}
