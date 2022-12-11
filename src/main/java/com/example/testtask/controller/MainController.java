package com.example.testtask.controller;

import com.example.testtask.domain.Person;
import com.example.testtask.service.PeopleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final PeopleService peopleService;

    public MainController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping("/people/{id}")
    public Person getPersonById(@PathVariable Long id) {
        Person person = peopleService.getPersonById(id);
        return person;
    }
}
