package com.study.advanced_jpa;

import com.study.advanced_jpa.log.domain.StudentLog;
import com.study.advanced_jpa.log.repository.LogRepository;
import com.study.advanced_jpa.service.domain.Student;
import com.study.advanced_jpa.service.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AdvancedJpaApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final LogRepository logRepository;

    public AdvancedJpaApplication(StudentRepository studentRepository, LogRepository logRepository) {
        this.studentRepository = studentRepository;
        this.logRepository = logRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AdvancedJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Student> students = studentRepository.findAll();


        students.forEach(s -> {
            System.out.println();
            System.out.println("--------[ Student ]--------");
            System.out.println(s.toString());

            System.out.println("--------[ Log ]--------");
            List<StudentLog> logs = logRepository.findAllByEmail(s.getEmail());
            logs.forEach(l -> {
                System.out.println(l.toString());
            });
            System.out.println("---------------------------");
        });
        System.out.println();

    }
}