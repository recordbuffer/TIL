package com.study.cvstodb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Library {

    @Id
    private Long no;
    private String name;
    private int guCode;
    private String address;
    private String tel;
    private String type;

    public Library() {
    }
}
