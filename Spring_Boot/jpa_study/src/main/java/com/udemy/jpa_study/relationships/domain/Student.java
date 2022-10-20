package com.udemy.jpa_study.relationships.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    @ManyToMany
    @JoinTable(name = "relation_student_and_course",            //연관 관계 테이블 정의
    joinColumns = @JoinColumn(name = "Studnet_id"),             //연관관계 테이블의 외래키 컬럼
    inverseJoinColumns = @JoinColumn(name = "course_id"))       //반대 방향 엔티티 참조 외래키 컬럼
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return String.format("Student[%s]", name);
    }
}
