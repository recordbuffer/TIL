package com.udemy.jpa_study.springdatajpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Student {
    @Id
    private Long id;

    private String name;

    @Embedded
    private Address address;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Student[%s]", name);
    }
}
