package com.test.protoc2;

import com.test.protoc2.domain.PersonInfo;
import org.springframework.stereotype.Service;

@Service
public class RestTestService {

    public PersonInfo.AddPerson dummyData() {
        PersonInfo.Person person1 = PersonInfo.Person.newBuilder().setId(1).setName("홍길동").setEmail("hong11@test.com").build();
        PersonInfo.Person person2 = PersonInfo.Person.newBuilder().setId(2).setName("고길동").setEmail("go22@test.com").build();
        PersonInfo.Person person3 = PersonInfo.Person.newBuilder().setId(3).setName("오길동").setEmail("oh33@test.com").build();

        PersonInfo.AddPerson people = PersonInfo.AddPerson.newBuilder().addPeople(person1).addPeople(person2).addPeople(person3).build();
        return people;
    }
}
