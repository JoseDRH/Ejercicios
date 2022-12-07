package com.example.block14testing.person;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Exceptions.UnprocessableEntityException;
import com.example.block14testing.Application.Person.Crud.RepositoryPerson;
import com.example.block14testing.Application.Person.Crud.ServicePerson;
import com.example.block14testing.Application.Person.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonServiceTest {


    @Mock
    private RepositoryPerson repositoryPerson;
    @InjectMocks
    ServicePerson person;

    private Person pe;

    @BeforeEach
    void personBorn(){
        pe =Person.builder()
                .id_persona(1)
                .usuario("Jose123")
                .name("Jose")
                .surname("del Rio")
                .company_email("jose.delrio@bosonit.com")
                .personal_email("josedr.hermo@gmail.com")
                .city("SdC")
                .active(true)
                .created_date(new Date()).build();
    }
    @Test
    @Order(1)
     void savePersonTest()  {
        when(repositoryPerson.save(any(Person.class))).thenReturn((pe));
        assertNotNull(person.savePerson(new Person()));

    }
    @Test
    @Order(2)
     void getPersonTest() throws EntityNotFoundException {
        when(repositoryPerson.findById(any(Integer.class))).thenReturn(Optional.ofNullable(pe));

        assertNotNull(person.getPersonById(1));

    }
    @Test
    @Order(3)
     void getPeopleTest(){
        when(repositoryPerson.findAll()).thenReturn(Arrays.asList(pe));
        assertNotNull(person.getAllPeople());

    }
    @Test
    @Order(4)
     void getPersonExceptionTest() {
        Assertions.assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> person.getPersonById(2));
    }
    @Test
    @Order(5)
     void deletePersonTest() throws EntityNotFoundException {
        Person per=new Person();
        when(repositoryPerson.findById(any(Integer.class))).thenReturn(Optional.ofNullable(per));
        person.deletePerson(1);
        verify(repositoryPerson).findById(1);
    }
    @Test
    @Order(6)
    void setToDTOTest(){
        Assertions.assertThat(pe.setToDTO().getName().equals("Jose"));
    }
    @Test
    @Order(7)
    void validationTest(){
        Assertions.assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(() ->new Person().validacionJava()).withMessage(null);

    }
    @Test
    @Order(8)
    void toEntityTest(){
        Assertions.assertThat(pe.setToDTO().setToEntity().getName().equals("Jose"));
    }
    @Test
    @Order(9)
    void deletePersonExceptionTest(){
        Assertions.assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> person.deletePerson(2));
    }
}
