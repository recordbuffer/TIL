package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "이 값을 필수로 작성해주세요.")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
