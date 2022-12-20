package com.example.block14testing.person;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Exceptions.UnprocessableEntityException;
import com.example.block14testing.Application.Person.Controller.ControllersPerson;
import com.example.block14testing.Application.Person.Crud.ServicePerson;
import com.example.block14testing.Application.Person.Person;
import com.example.block14testing.Application.Profesor.Crud.ServiceProfesor;
import com.example.block14testing.Application.Student.Crud.ServiceStudent;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonControllerTest {

    @Mock
    private ServicePerson service;

    @InjectMocks
    private ControllersPerson controllers;



    @Mock
    private ServiceStudent serviceStudent;

    @Mock
    private ServiceProfesor serviceProfesor;

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
    void saveTest() throws UnprocessableEntityException {
        when(service.savePerson(any(Person.class))).thenReturn(pe);
        assertTrue(controllers.add(pe).getName().equals("Jose"));

    }
    @Test
    @Order(2)
    void getByIdSimpleTest() throws EntityNotFoundException {
        when(service.getPersonById(any(Integer.class))).thenReturn(pe);
        assertNotNull(controllers.searchByID(1,"simple"));
    }

    @Test
    @Order(3)
    void getByNameSimpleTest(){
        when(service.getAllPeople()).thenReturn(Arrays.asList(pe));
        assertNotNull(controllers.searchByName("Jose","simple"));
    }
    @Test
    @Order(4)
    void seeAllSimpleTest(){
        when(service.getAllPeople()).thenReturn(Arrays.asList(pe));
        assertNotNull(controllers.seeAll("simple"));
    }
    @Test
    @Order(5)
    void deleteTest() throws EntityNotFoundException {
        Person p=new Person();
        when(service.getPersonById(any(Integer.class))).thenReturn(p);
        when(serviceProfesor.getAllProfesor()).thenReturn(new ArrayList<>());
        when(serviceStudent.getAllStudents()).thenReturn(new ArrayList<>());
        controllers.delete(1);
        verify(service).deletePerson(1);
    }
    @Test
    @Order(6)
    void getByIdTest() throws EntityNotFoundException {
        when(service.getPersonById(any(Integer.class))).thenReturn(pe);
        when(serviceStudent.getAllStudents()).thenReturn(new ArrayList<>());
        when(serviceProfesor.getAllProfesor()).thenReturn(new ArrayList<>());
        assertNotNull(controllers.searchByID(1,"full"));
    }

    @Test
    @Order(7)
    void getByNameTest(){
        when(service.getAllPeople()).thenReturn(Arrays.asList(pe));
        when(serviceStudent.getAllStudents()).thenReturn(new ArrayList<>());
        when(serviceProfesor.getAllProfesor()).thenReturn(new ArrayList<>());
        assertNotNull(controllers.searchByName("Jose","full"));
    }
    @Test
    @Order(8)
    void updateTest() throws UnprocessableEntityException {
        when(service.savePerson(any(Person.class))).thenReturn(pe);
        assertNotNull(controllers.update(pe));
    }
    @Test
    @Order(9)
    void saveExceptionTest(){
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(()->controllers.add(new Person()));
    }
    @Test
    @Order(10)
    void getExceptionIdtest() throws EntityNotFoundException {
        when(service.getPersonById(any(Integer.class))).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()->controllers.searchByID(1,"simple"));
    }

    @Test
    @Order(11)
    void deleteExceptionTest() throws EntityNotFoundException {
        when(controllers.delete(1)).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> controllers.delete(1));
    }
    @Test
    @Order(12)
    void updateExceptionTest(){
        assertThatExceptionOfType(UnprocessableEntityException.class)
                .isThrownBy(()-> controllers.update(new Person()));
    }



}
