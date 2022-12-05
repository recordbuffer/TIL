package com.test.protoc;

import com.test.protoc.domain.PersonInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProtocApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtocApplication.class, args);

		ProtobufHttpMessageConverter protobufHttpMessageConverter = new ProtobufHttpMessageConverter();
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(protobufHttpMessageConverter);

		RestTemplate restTemplate = new RestTemplate(converters);
		HttpHeaders headers = new HttpHeaders();

		String uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/rest/test").toUriString();
		PersonInfo.AddPerson people = restTemplate.getForEntity(uri, PersonInfo.AddPerson.class).getBody();

		for (PersonInfo.Person p : people.getPeopleList()) {
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getEmail());
			System.out.println(p.getAllFields());
		}
	}

}
