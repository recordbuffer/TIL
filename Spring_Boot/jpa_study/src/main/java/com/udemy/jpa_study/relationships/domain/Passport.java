package com.udemy.jpa_study.relationships.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")    // owning side of the relationships
    private Student student;

    public Passport(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }
}
