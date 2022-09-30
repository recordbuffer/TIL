package com.udemy.jpa_study.indepth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    @CreatedDate
    private Timestamp createdDate;

    @CreationTimestamp
    private Timestamp creationTimestamp;


    public Course(String name, String author) {
        this.name = name;
        this.author =author;
    }
}
