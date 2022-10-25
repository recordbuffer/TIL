package com.udemy.jpa_study.relationships.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    @CreationTimestamp
    private Timestamp creationTimestamp;

    @UpdateTimestamp
    private Timestamp updateTimestamp;

    public Course(String name, String author) {
        this.name = name;
        this.author =author;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return String.format("Course[%s]", name);
    }
}
