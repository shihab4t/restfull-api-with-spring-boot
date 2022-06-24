package com.sh048b.restapi.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student shihab = new Student("shihab", "shihab@gmail.com", 19);
            Student mahamud = new Student("mahamud", "mahanud@gmail.com", 18);
            studentRepository.saveAll(List.of(shihab, mahamud));
        };
    }
}
