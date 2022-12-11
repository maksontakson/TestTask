package com.example.testtask.service;

import com.example.testtask.domain.Person;
import com.example.testtask.repo.PeopleRepo;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepo peopleRepo;

    public PeopleServiceImpl(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    @Override
    public Person getPersonById(Long id) {
        return peopleRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
