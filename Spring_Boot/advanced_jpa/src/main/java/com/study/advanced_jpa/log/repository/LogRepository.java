package com.study.advanced_jpa.log.repository;

import com.study.advanced_jpa.log.domain.StudentLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<StudentLog, Long> {

    List<StudentLog> findAllByEmail(String email);
}
