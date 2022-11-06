package com.udemy.jpa_study.inheritance.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass   //MappedSuperClass는 엔티티아님 super class임
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "Employee_Type")    //default = "DType"
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    protected Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Employee[%s]", name);
    }
}
