package com.test.protoc2;

import com.test.protoc2.domain.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestTestController {

    @Autowired
    RestTestService service;

    @GetMapping("/rest/test")
    public ResponseEntity<Object> rest() {
        PersonInfo.AddPerson people = service.dummyData();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
}
