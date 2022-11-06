package com.udemy.jpa_study.springdatajpa.repository;

import com.udemy.jpa_study.springdatajpa.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*@Repository
@Transactional*/
@RepositoryRestResource(path = "courses")
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);

    @Query(value = "select * from Course c where name like '%Microservices'",nativeQuery = true)
    List<Course> courseWithQuery();

}
