package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student yeon = new Student(
                    "Yeon",
                    "yeon@gmail.com",
                    LocalDate.of(1983, Month.APRIL, 1)
            );
            Student mie = new Student(
                    "Mie",
                    "mie@gmail.com",
                    LocalDate.of(1991, Month.JANUARY, 31)
            );
            repository.saveAll(
                    List.of(yeon, mie)
            );
        };
    }
}
