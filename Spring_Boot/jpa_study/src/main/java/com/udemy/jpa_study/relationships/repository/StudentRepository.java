package com.udemy.jpa_study.relationships.repository;

import com.udemy.jpa_study.relationships.domain.Course;
import com.udemy.jpa_study.relationships.domain.Passport;
import com.udemy.jpa_study.relationships.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }
        return student;
    }


    public void deleteById(Long id) {
        Student Student = findById(id);
        em.remove(Student);
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("김혜수");
        student.setPassport(passport);
        em.persist(student);
    }

    public void addHardCodingStudentCourse() {
        Student student = new Student("천우희");
        Course course = new Course("java with Spring", "허초희");

        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);
        em.persist(student);    //owning side
    }

}
