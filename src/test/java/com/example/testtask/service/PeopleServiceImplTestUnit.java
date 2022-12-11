package com.example.testtask.service;

import com.example.testtask.TestTaskApplication;
import com.example.testtask.domain.Person;
import com.example.testtask.repo.PeopleRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
@AutoConfigureTestEntityManager
class PeopleServiceImplTestUnit {

    @Autowired
    private PeopleService peopleService;
    @MockBean
    private PeopleRepo peopleRepo;
    @Autowired
    private TestEntityManager manager;


    @Test
    void getPersonById() {
        //when
        Person person = new Person(1L, "Maks", "Kotlyar", 21);
        Mockito.when(peopleRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(person));

        //execute
        Person expectedPerson = peopleService.getPersonById(Mockito.anyLong());

        //check
        Assertions.assertNotNull(person);
        Assertions.assertEquals(person, expectedPerson);
        Mockito.verify(peopleRepo, Mockito.times(1)).findById(Mockito.anyLong());
    }

    @Test
    @Transactional
    void whenThereIsNoPersonWithMentionedId_thenNoSuchFieldErrorIsThrown() {
        Assertions.assertThrows(NoSuchElementException.class, () -> peopleService.getPersonById(null));
    }
}