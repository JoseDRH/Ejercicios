package com.example.block14testing.student;

import com.example.block14testing.Application.Exceptions.EntityNotFoundException;
import com.example.block14testing.Application.Person.Person;
import com.example.block14testing.Application.Profesor.Profesor;
import com.example.block14testing.Application.Student.Crud.RepositoryStudent;
import com.example.block14testing.Application.Student.Crud.ServiceStudent;
import com.example.block14testing.Application.Student.Student;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentServiceTest {

    @Mock
    private RepositoryStudent repository;

    @InjectMocks
    private ServiceStudent service;

    private Student student;
    @BeforeEach
    void setUp(){
        Person person=Person.builder()
                .id_persona(1)
                .usuario("Chuchi")
                .name("Jesús Javier")
                .surname("Puente Sánchez")
                .company_email("jesus.puente@bosonit.com")
                .personal_email("jesus.puente@gmail.com")
                .city("Logroño")
                .active(true)
                .created_date(new Date()).build();
        Profesor profesor= Profesor.builder()
                .id_profesor(1)
                .persona(person)
                .coments("He programado una reunión")
                .rama("Backend")
                .build();
        Person pe = Person.builder()
                .id_persona(1)
                .usuario("Jose123")
                .name("Jose")
                .surname("del Rio")
                .company_email("jose.delrio@bosonit.com")
                .personal_email("josedr.hermo@gmail.com")
                .city("SdC")
                .active(true)
                .created_date(new Date()).build();
        student=Student.builder()
                .id_estudiante(1)
                .persona(pe)
                .num_hours_week(40)
                .rama("Backend")
                .coments("Muy aplicado")
                .profesor(profesor)
                .build();
    }

    @Test
    @Order(1)
    void saveTest(){
        when(repository.save(any(Student.class))).thenReturn(student);
        Assertions.assertNotNull(service.saveStudent(student));
    }
    @Test
    @Order(2)
    void getByIdTest() throws EntityNotFoundException {
        when(repository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(student));
        Assertions.assertNotNull(service.getStudentById(1));
    }
    @Test
    @Order(3)
    void getExceptionTest(){
       assertThatExceptionOfType(EntityNotFoundException.class)
               .isThrownBy(()->service.getStudentById(1));
    }
    @Test
    @Order(4)
    void getAllTest(){
        when(repository.findAll()).thenReturn(Arrays.asList(student));
        Assertions.assertNotNull(service.getAllStudents());
    }
    @Test
    @Order(5)
    void deleteTest() throws EntityNotFoundException {
        Student s=new Student();
        when(repository.findById(any(Integer.class))).thenReturn(Optional.of(s));
        service.deleteStudent(1);
        verify(repository).findById(1);
    }
    @Test
    @Order(6)
    void deleteExceptionTest(){
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()->service.deleteStudent(1));
    }
}
