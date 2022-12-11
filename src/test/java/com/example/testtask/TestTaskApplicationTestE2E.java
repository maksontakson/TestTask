package com.example.testtask;

import com.example.testtask.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
class TestTaskApplicationTestE2E {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mvc;
    @Autowired
    private TestEntityManager manager;
    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(context);
    }

    @Test
    @Transactional
    public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {
        Person person = Person.builder().
                name("Maks").
                surname("Kotlyar").
                age(25).
                build();
        manager.persist(person);


        mvc.perform(get("/people/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value( "Maks"));
    }
}