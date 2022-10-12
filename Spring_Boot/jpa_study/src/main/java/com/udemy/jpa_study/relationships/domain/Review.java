package com.udemy.jpa_study.relationships.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private String rating;


    public Review(String description, String rating) {
        this.description = description;
        this.rating =rating;
    }


    @Override
    public String toString() {
        return String.format("Review[%s %s]",rating, description);
    }
}
