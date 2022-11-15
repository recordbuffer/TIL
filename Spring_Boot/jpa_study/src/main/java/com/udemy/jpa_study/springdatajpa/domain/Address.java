package com.udemy.jpa_study.springdatajpa.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String line1;
    private String line2;
    private String line3;
}
