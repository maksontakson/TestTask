package com.example.testtask;

import com.example.testtask.domain.Person;
import com.example.testtask.repo.PeopleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);
    }
}
