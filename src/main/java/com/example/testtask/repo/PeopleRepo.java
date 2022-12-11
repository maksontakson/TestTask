package com.example.testtask.repo;

import com.example.testtask.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepo extends JpaRepository<Person, Long> {
    Optional<Person> findById(Long id);
}
