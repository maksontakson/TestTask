package com.example.testtask.repo;

import com.example.testtask.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
class PeopleRepoTestUnit {
    @Autowired
    private PeopleRepo repo;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findById() {
        //execute
        Person person = Person.builder().
                name("Maks").
                surname("Kotlyar").
                age(25).
                build();
        testEntityManager.persist(person);
        Optional<Person> expectedPerson = repo.findById(1L);

        //then
        Assertions.assertNotNull(expectedPerson);
        Assertions.assertEquals("Maks", expectedPerson.get().getName());
    }

}