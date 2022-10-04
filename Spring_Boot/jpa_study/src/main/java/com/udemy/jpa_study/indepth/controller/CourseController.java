package com.udemy.jpa_study.indepth.controller;

import com.udemy.jpa_study.indepth.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseRepository repository;

    @GetMapping("/update/dateTime")
    public void updateEntity() {
        repository.updateEntityDateTime();
    }
}
